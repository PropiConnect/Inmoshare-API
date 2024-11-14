package com.propiconnect.inmoshare.user.interfaces.rest.resources;

public record CreateUserResource(
        String name,
        String username,
        String phone,
        String email,
        String password,
        String address
) {}
