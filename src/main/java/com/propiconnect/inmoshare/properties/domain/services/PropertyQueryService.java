package com.propiconnect.inmoshare.properties.domain.services;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetAllPropertiesQuery;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertiesByOwnerIdQuery;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertyByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PropertyQueryService {
    //
    List<Property> handle(GetPropertiesByOwnerIdQuery query);
    Optional<Property> handle(GetPropertyByIdQuery query);
    List<Property> handle(GetAllPropertiesQuery query);
}
