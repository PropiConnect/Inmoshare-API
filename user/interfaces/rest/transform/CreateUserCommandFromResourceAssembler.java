package com.propiconnect.inmoshare.user.interfaces.rest.transform;

import com.propiconnect.inmoshare.user.domain.model.commands.CreateUserCommand;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.name(),
                resource.username(),
                resource.password(),
                resource.subscription(),
                resource.userType()
        );
    }
}
