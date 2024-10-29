package com.propiconnect.inmoshare.properties.domain.model.queries;

public record GetPropertiesByIdQuery(Long id) {
    public GetPropertiesByIdQuery {
        if ( id == null || id <= 0)
            throw new IllegalArgumentException("id cannot be null or zero");
    }
}
