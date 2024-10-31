package com.propiconnect.inmoshare.payments.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private String email;

    @Column(nullable = false)
    @Getter
    private Double paymentPercentage;

    @Column(nullable = false)
    @Getter
    private Double ownershipPercentage;

    public Participant(String name, String email, Double paymentPercentage, Double ownershipPercentage) {
        this.name = name;
        this.email = email;
        this.paymentPercentage = paymentPercentage;
        this.ownershipPercentage = ownershipPercentage;
    }
}
