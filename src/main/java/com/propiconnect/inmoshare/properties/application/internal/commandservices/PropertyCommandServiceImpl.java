package com.propiconnect.inmoshare.properties.application.internal.commandservices;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;
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
}
