package com.propiconnect.inmoshare.payments.interfaces.rest.resources;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Participant;
import java.util.List;

public record CreatePaymentResource(String cardNumber, List<Participant> participants) {}
