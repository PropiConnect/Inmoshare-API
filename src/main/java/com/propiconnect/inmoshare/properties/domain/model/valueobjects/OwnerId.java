package com.propiconnect.inmoshare.properties.domain.model.valueobjects;

public record OwnerId(Long id) {
    public OwnerId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Property ID cannot be null or empty.");
        }
    }
}
