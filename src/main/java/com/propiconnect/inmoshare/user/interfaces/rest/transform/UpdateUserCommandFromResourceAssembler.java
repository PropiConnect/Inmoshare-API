package com.propiconnect.inmoshare.user.interfaces.rest.transform;

import com.propiconnect.inmoshare.user.domain.model.commands.UpdateUserCommand;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.UserResource;

public class UpdateUserCommandFromResourceAssembler {
    public static UpdateUserCommand toCommand(Long id, UserResource resource) {
        return new UpdateUserCommand(
                id,
                resource.name(),
                resource.username(),
                resource.phone(),
                resource.email(),
                resource.password(),
                resource.address(),
                resource.userType() // Mapear userType
        );
    }
}
