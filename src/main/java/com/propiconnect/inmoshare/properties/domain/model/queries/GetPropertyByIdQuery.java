package com.propiconnect.inmoshare.properties.domain.model.queries;

public record GetPropertyByIdQuery(Long id) {
    public GetPropertyByIdQuery {
        if ( id == null || id <= 0)
            throw new IllegalArgumentException("id cannot be null or zero");
    }
}
