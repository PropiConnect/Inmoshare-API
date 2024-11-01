package com.propiconnect.inmoshare.properties.domain.model.valueobjects;

public record PropertyId(Long id) {
    public PropertyId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Property ID cannot be null or empty.");
        }
    }
}
