package com.propiconnect.inmoshare.properties.interfaces.rest;


import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;

import com.propiconnect.inmoshare.properties.domain.model.queries.GetPropertyByIdQuery;
import com.propiconnect.inmoshare.properties.domain.services.PropertyCommandService;
import com.propiconnect.inmoshare.properties.domain.services.PropertyQueryService;
import com.propiconnect.inmoshare.properties.interfaces.rest.resources.CreatePropertyResource;
import com.propiconnect.inmoshare.properties.interfaces.rest.resources.PropertyResource;
import com.propiconnect.inmoshare.properties.interfaces.rest.transform.CreatePropertyCommandFromResourceAssembler;
import com.propiconnect.inmoshare.properties.interfaces.rest.transform.PropertyResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



@RestController
@RequestMapping(value = "api/v1/properties", produces = APPLICATION_JSON_VALUE)
@Tag( name="Properties", description = "Operations related to properties")
public class PropertyController {
    private final PropertyCommandService propertyCommandService;
    private final PropertyQueryService propertyQueryService;

    public PropertyController(PropertyCommandService propertyCommandService,
                              PropertyQueryService propertyQueryService) {
        this.propertyCommandService = propertyCommandService;
        this.propertyQueryService = propertyQueryService;
    }

    @PostMapping
    public ResponseEntity<PropertyResource> createProperty(@RequestBody CreatePropertyResource resource) {
        Optional<Property> property = propertyCommandService
                .handle(CreatePropertyCommandFromResourceAssembler.toCommandFromResource(resource));
        return property.map(p ->
                        new ResponseEntity<>(PropertyResourceFromEntityAssembler.toResourceFromEntity(p), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResource> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyQueryService.handle((new GetPropertyByIdQuery(id)));
        return property.map(p -> ResponseEntity.ok(PropertyResourceFromEntityAssembler.toResourceFromEntity(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    @GetMapping
    public ResponseEntity<?> getPropertiesWithParameters(@Parameter(name= "params", hidden = true)
                                                              @RequestParam Map<String, String> params) {
        if(params.containsKey("ownerId") && params.containsKey("")) {

    }


     */
}
