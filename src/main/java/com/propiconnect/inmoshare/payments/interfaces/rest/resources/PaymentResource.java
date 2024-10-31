package com.propiconnect.inmoshare.payments.interfaces.rest.resources;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Participant;
import java.util.List;

public record PaymentResource(Long id, String cardNumber, List<Participant> participants) {}
