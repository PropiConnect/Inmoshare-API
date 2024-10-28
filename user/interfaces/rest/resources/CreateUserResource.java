package com.propiconnect.inmoshare.user.interfaces.rest.resources;

public record CreateUserResource(

        String name,
        String username,
        String password,
        String subscription,
        String userType
) {
    public CreateUserResource {

        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (username == null) {
            throw new IllegalArgumentException("username cannot be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password cannot be null");
        }
        if (subscription == null) {
            throw new IllegalArgumentException("subscription cannot be null");
        }
        if (userType == null) {
            throw new IllegalArgumentException("userType cannot be null");
        }
    }
}
