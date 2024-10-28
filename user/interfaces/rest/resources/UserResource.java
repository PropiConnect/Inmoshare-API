package com.propiconnect.inmoshare.user.interfaces.rest.resources;

public record UserResource(
        String name,
        String username,
        String password,
        String subscription,
        String userType
) {
}
