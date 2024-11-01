package com.propiconnect.inmoshare.properties.interfaces.rest.transform;

import com.propiconnect.inmoshare.properties.domain.model.commands.UpdatePropertyCommand;
import com.propiconnect.inmoshare.properties.interfaces.rest.resources.UpdatePropertyResource;

public class UpdatePropertyCommandFromResourceAssembler {
    public static UpdatePropertyCommand toCommandFromResource(Long id, UpdatePropertyResource resource) {
        return new UpdatePropertyCommand(id, resource.city(), resource.type(), resource.address(), resource.description(), resource.propertyType(), resource.rentalType(), resource.image(), resource.initialPrice()
        );
    }
}
