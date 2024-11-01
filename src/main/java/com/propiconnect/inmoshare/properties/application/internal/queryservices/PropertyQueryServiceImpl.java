package com.propiconnect.inmoshare.properties.application.internal.queryservices;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetAllPropertiesQuery;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertiesByOwnerIdQuery;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertyByIdQuery;
import com.propiconnect.inmoshare.properties.domain.services.PropertyQueryService;
import com.propiconnect.inmoshare.properties.infrastructure.persistence.jpa.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyQueryServiceImpl implements PropertyQueryService {
    private final PropertyRepository propertyRepository;

    public PropertyQueryServiceImpl(PropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> handle(GetPropertiesByOwnerIdQuery query) {
       return propertyRepository.findAllByOwnerId(query.ownerId());
    }

    @Override
    public Optional<Property> handle(GetPropertyByIdQuery query) {
        return propertyRepository.findById(query.id());
    }

    @Override
    public List<Property> handle(GetAllPropertiesQuery query) {
        return propertyRepository.findAll();
    }


}
