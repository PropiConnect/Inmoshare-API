package com.propiconnect.inmoshare.user.interfaces.rest.transform;

import com.propiconnect.inmoshare.user.domain.model.commands.UpdateUserCommand;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.CreateUserResource;

public class UpdateUserCommandFromResourceAssembler {
    public static UpdateUserCommand toCommand(Long userId, CreateUserResource resource) {
        return new UpdateUserCommand(
                userId,
                resource.name(),
                resource.username(),
                resource.password(),
                resource.subscription(),
                resource.userType()
        );
    }

}
