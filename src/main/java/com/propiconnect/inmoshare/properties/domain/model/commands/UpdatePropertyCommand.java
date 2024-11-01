package com.propiconnect.inmoshare.properties.domain.model.commands;

public record UpdatePropertyCommand(Long id,String city,String type, String address, String description, String propertyType, String rentalType, String image, Double initialPrice) {
}
