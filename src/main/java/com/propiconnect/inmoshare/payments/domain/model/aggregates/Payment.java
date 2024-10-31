package com.propiconnect.inmoshare.payments.domain.model.aggregates;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Participant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String cardNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    @Getter
    private List<Participant> participants;

    public Payment(String cardNumber, List<Participant> participants) {
        this.cardNumber = cardNumber;
        this.participants = participants;
    }
}
