package com.propiconnect.inmoshare.user.domain.model.queries;

public record GetUserByEmailAndPasswordQuery(String email, String password) {
    public GetUserByEmailAndPasswordQuery {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }
}
