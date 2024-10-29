package com.propiconnect.inmoshare.properties.domain.services;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertiesByIdQuery;
import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertiesByOwnerIdQuery;

import java.util.List;

public interface PropertyQueryService {
    List<Property> handle(GetPropertiesByIdQuery query);
    List<Property> handle(GetPropertiesByOwnerIdQuery query);
}
