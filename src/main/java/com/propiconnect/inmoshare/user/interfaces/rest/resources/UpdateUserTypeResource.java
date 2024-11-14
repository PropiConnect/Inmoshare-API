package com.propiconnect.inmoshare.user.interfaces.rest.resources;

import com.propiconnect.inmoshare.user.domain.model.enums.UserType;

public record UpdateUserTypeResource(
        UserType userType
) {}
