package com.propiconnect.inmoshare.properties.domain.services;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;
import com.propiconnect.inmoshare.properties.domain.model.commands.DeletePropertyCommand;

import java.util.Optional;

public interface PropertyCommandService {
    Optional<Property> handle(CreatePropertyCommand command);
    void handle (DeletePropertyCommand command);
}
