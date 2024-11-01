package com.propiconnect.inmoshare.properties.application.internal.commandservices;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;
import com.propiconnect.inmoshare.properties.domain.model.commands.DeletePropertyCommand;
import com.propiconnect.inmoshare.properties.domain.model.commands.UpdatePropertyCommand;
import com.propiconnect.inmoshare.properties.domain.services.PropertyCommandService;
import com.propiconnect.inmoshare.properties.infrastructure.persistence.jpa.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyCommandServiceImpl implements PropertyCommandService {
    private final PropertyRepository propertyRepository;

    public PropertyCommandServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Optional<Property> handle(CreatePropertyCommand command) {
        if(propertyRepository.existsByOwnerIdAndAddress(command.ownerId(), command.address()))
            throw new IllegalArgumentException("Property with same address already exists");
        var property = new Property(command);
        var createdProperty = propertyRepository.save(property);
        return Optional.of(createdProperty);
    }

    @Override
    public Optional<Property> handle(UpdatePropertyCommand command) {
        if (propertyRepository.existsByIdAndAddressIsNot(command.id(), command.address()))
            throw new IllegalArgumentException("Property with the same address already exists");
        var result = propertyRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException(("Property does not exist"));
        var propertyToUpdate = result.get();
        try {
            var updatedProperty = propertyRepository.save(propertyToUpdate.updateInformation(command.city(), command.type(), command.address(), command.description(), command.propertyType(), command.rentalType(), command.image(), command.initialPrice()
            ));
            return Optional.of(updatedProperty);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating property: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeletePropertyCommand command) {
        if(!propertyRepository.existsById(command.id()))
            throw new IllegalArgumentException("Property does not exist");
        try {
            propertyRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting property: " + e.getMessage());
        }
    }
}
