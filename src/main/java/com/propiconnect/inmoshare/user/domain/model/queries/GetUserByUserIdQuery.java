package com.propiconnect.inmoshare.user.domain.model.queries;

public record GetUserByUserIdQuery(Long userId) {
    public GetUserByUserIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
    }
}
