package com.propiconnect.inmoshare.properties.domain.services;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;
import com.propiconnect.inmoshare.properties.domain.model.commands.DeletePropertyCommand;
import com.propiconnect.inmoshare.properties.domain.model.commands.UpdatePropertyCommand;

import java.util.Optional;

public interface PropertyCommandService {
    Optional<Property> handle(CreatePropertyCommand command);
    Optional<Property> handle(UpdatePropertyCommand command);
    void handle (DeletePropertyCommand command);
}
