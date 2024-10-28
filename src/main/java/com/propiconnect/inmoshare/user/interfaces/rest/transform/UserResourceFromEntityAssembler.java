package com.propiconnect.inmoshare.user.interfaces.rest.transform;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toUserResource(User entity) {
        return new UserResource(
                entity.getName(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getSuscription(),
                entity.getUserType()
        );
    }
}
