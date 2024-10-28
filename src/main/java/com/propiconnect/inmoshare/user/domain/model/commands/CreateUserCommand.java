package com.propiconnect.inmoshare.user.domain.model.commands;

public record CreateUserCommand(
        String name,
        String username,
        String password,
        String subscription,
        String userType
) {
    public CreateUserCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (subscription == null || subscription.isBlank()) {
            throw new IllegalArgumentException("subscription cannot be null or empty");
        }
        if (userType == null || userType.isBlank()) {
            throw new IllegalArgumentException("userType cannot be null or empty");
        }
    }
}


