package com.propiconnect.inmoshare.payments.domain.services;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import com.propiconnect.inmoshare.payments.domain.model.commands.CreatePaymentCommand;
import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
}
