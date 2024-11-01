package com.propiconnect.inmoshare.properties.interfaces.rest.transform;

import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;
import com.propiconnect.inmoshare.properties.interfaces.rest.resources.CreatePropertyResource;

public class CreatePropertyCommandFromResourceAssembler {
    public static CreatePropertyCommand toCommandFromResource(CreatePropertyResource resource) {
        return new CreatePropertyCommand(resource.ownerName(), resource.ownerId(), resource.city(), resource.type(), resource.address(), resource.description(), resource.propertyType(), resource.rentalType(), resource.image(), resource.initialPrice()
        );
    }
}
