package com.propiconnect.inmoshare.payments.domain.model.commands;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Participant;
import java.util.List;

public record CreatePaymentCommand(String cardNumber, List<Participant> participants) {}
