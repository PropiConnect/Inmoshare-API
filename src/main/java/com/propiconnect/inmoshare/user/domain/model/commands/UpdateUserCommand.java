package com.propiconnect.inmoshare.user.domain.model.commands;

import com.propiconnect.inmoshare.user.domain.model.enums.UserType;

public record UpdateUserCommand(
        Long sourceId,
        String name,
        String username,
        String phone,
        String email,
        String password,
        String address,
        UserType userType // Añadir userType aquí
) {
    public UpdateUserCommand {
        if (sourceId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (userType == null) {
            throw new IllegalArgumentException("UserType cannot be null");
        }
    }
}
