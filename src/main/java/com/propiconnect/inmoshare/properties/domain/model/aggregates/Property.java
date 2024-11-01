package com.propiconnect.inmoshare.properties.domain.model.aggregates;

import com.propiconnect.inmoshare.properties.domain.model.commands.CreatePropertyCommand;
import com.propiconnect.inmoshare.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Entity
public class Property extends AuditableAbstractAggregateRoot<Property> {

    @Column(nullable = false)
    @Getter
    private String ownerName;

    @Column(nullable = false)
    @Getter
    private Long propertyId;

    @Column(nullable = false)
    @Getter
    private Long ownerId;

    @Column(nullable = false)
    @Getter
    private String city;

    @Column(nullable = false)
    @Getter
    private String type;

    @Column(nullable = false)
    @Getter
    private String address;

    @Column(nullable = false)
    @Getter
    private String description;

    @Column(nullable = false)
    @Getter
    private String propertyType;


    @Column(nullable = false)
    @Getter
    private String rentalType;

    @Column(nullable = false)
    @Getter
    private String image;

    @Column(nullable = false)
    @Getter
    private Double initialPrice;

    protected Property(){
        this.ownerName= Strings.EMPTY;
        this.ownerId=0L;
        this.propertyId= 0L;
        this.city=Strings.EMPTY;
        this.type=Strings.EMPTY;
        this.address=Strings.EMPTY;
        this.description=Strings.EMPTY;
        this.propertyType=Strings.EMPTY;
        this.rentalType=Strings.EMPTY;
        this.image=Strings.EMPTY;
        this.initialPrice=0.0;
    }

    public Property(CreatePropertyCommand command){
        this();
        this.ownerName=command.ownerName();
        this.propertyId= command.propertyId();
        this.ownerId=command.ownerId();
        this.city=command.city();
        this.type=command.type();
        this.address=command.address();
        this.description=command.description();
        this.propertyType=command.propertyType();
        this.rentalType=command.rentalType();
        this.image=command.image();
        this.initialPrice=command.initialPrice();
    }

    public Property updateInformation(String city, String type, String address, String description, String propertyType, String rentalType, String image, Double initialPrice) {
        this.city = city;
        this.type = type;
        this.address = address;
        this.description = description;
        this.propertyType = propertyType;
        this.rentalType = rentalType;
        this.image = image;
        this.initialPrice = initialPrice;
        return this;
    }

}

