package com.propiconnect.inmoshare.payments.domain.services;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
}
