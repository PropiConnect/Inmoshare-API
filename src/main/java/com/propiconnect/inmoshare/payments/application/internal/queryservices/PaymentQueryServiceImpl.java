package com.propiconnect.inmoshare.payments.application.internal.queryservices;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import com.propiconnect.inmoshare.payments.domain.services.PaymentQueryService;
import com.propiconnect.inmoshare.payments.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
}
