package com.propiconnect.inmoshare.payments.interfaces.rest;

import com.propiconnect.inmoshare.payments.application.internal.commandservices.PaymentCommandServiceImpl;
import com.propiconnect.inmoshare.payments.application.internal.queryservices.PaymentQueryServiceImpl;
import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import com.propiconnect.inmoshare.payments.interfaces.rest.resources.CreatePaymentResource;
import com.propiconnect.inmoshare.payments.interfaces.rest.resources.PaymentResource;
import com.propiconnect.inmoshare.payments.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import com.propiconnect.inmoshare.payments.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentCommandServiceImpl paymentCommandService;
    private final PaymentQueryServiceImpl paymentQueryService;

    @Autowired
    public PaymentController(PaymentCommandServiceImpl paymentCommandService, PaymentQueryServiceImpl paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
    }

    // Endpoint para crear un nuevo pago
    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource) {
        var command = CreatePaymentCommandFromResourceAssembler.toCommand(resource);
        Optional<Payment> paymentOpt = paymentCommandService.handle(command);

        if (paymentOpt.isPresent()) {
            var paymentResource = PaymentResourceFromEntityAssembler.toResource(paymentOpt.get());
            return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para obtener un pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable Long id) {
        Optional<Payment> paymentOpt = paymentQueryService.getPaymentById(id);

        return paymentOpt
                .map(payment -> new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResource(payment), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<PaymentResource>> getAllPayments() {
        List<Payment> payments = paymentQueryService.getAllPayments();
        List<PaymentResource> paymentResources = payments.stream()
                .map(PaymentResourceFromEntityAssembler::toResource)
                .toList();
        return new ResponseEntity<>(paymentResources, HttpStatus.OK);
    }
}
