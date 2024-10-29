package com.propiconnect.inmoshare.properties.domain.model.commands;

public record CreatePropertyCommand(String ownerName,long ownerId,String city,String type, String address, String description, String propertyType, String rentalType, String image, long initialPrice) {
}
