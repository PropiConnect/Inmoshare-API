package com.propiconnect.inmoshare.properties.interfaces.rest.resources;

public record UpdatePropertyResource(String city,String type, String address, String description, String propertyType, String rentalType, String image, Double initialPrice) {
}
