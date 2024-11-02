package com.propiconnect.inmoshare.user.domain.model.queries;

public record GetUserByIdQuery(Long id) {
    public GetUserByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
    }
}
