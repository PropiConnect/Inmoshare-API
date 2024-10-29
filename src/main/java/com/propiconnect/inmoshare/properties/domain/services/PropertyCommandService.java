package com.propiconnect.inmoshare.properties.domain.services;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;

import java.util.Optional;

public interface PropertyCommandService {
    Optional<Property> handle(CreatePropertyCommand command);
}
