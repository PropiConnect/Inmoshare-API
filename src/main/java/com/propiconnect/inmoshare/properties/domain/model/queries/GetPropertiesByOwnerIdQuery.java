package com.propiconnect.inmoshare.properties.domain.model.queries;

public record GetPropertiesByOwnerIdQuery(Long ownerId) {
    public GetPropertiesByOwnerIdQuery{
        if(ownerId == null || ownerId <= 0)
            throw new IllegalArgumentException("ownerId cannot be null or zero");

    }
}
