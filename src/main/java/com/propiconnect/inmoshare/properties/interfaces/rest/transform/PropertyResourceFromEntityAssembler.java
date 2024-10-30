package com.propiconnect.inmoshare.properties.interfaces.rest.transform;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.interfaces.rest.resources.PropertyResource;

public class PropertyResourceFromEntityAssembler {
    public static PropertyResource toResourceFromEntity(Property entity) {
        return new PropertyResource(entity.getOwnerName(), entity.getOwnerId(), entity.getCity(), entity.getType(), entity.getAddress(), entity.getDescription(), entity.getPropertyType(), entity.getRentalType(), entity.getImage(), entity.getInitialPrice()
        );
    }
}
