package com.propiconnect.inmoshare.payments.application.internal.commandservices;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import com.propiconnect.inmoshare.payments.domain.model.commands.CreatePaymentCommand;
import com.propiconnect.inmoshare.payments.domain.services.PaymentCommandService;
import com.propiconnect.inmoshare.payments.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        Payment payment = new Payment(command.cardNumber(), command.participants());
        Payment savedPayment = paymentRepository.save(payment);
        return Optional.of(savedPayment);
    }
}
