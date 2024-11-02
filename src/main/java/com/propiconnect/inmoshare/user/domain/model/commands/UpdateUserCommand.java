package com.propiconnect.inmoshare.user.domain.model.commands;

public record UpdateUserCommand(
        Long sourceId,
        String name,
        String username,
        String password,
        String subscription,
        String userType
) {
    public UpdateUserCommand {
        if (name == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
    }
}
