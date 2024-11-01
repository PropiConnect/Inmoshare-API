package com.propiconnect.inmoshare.payments.interfaces.rest.transform;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import com.propiconnect.inmoshare.payments.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {

    public static PaymentResource toResource(Payment entity) {
        return new PaymentResource(entity.getId(), entity.getCardNumber(), entity.getParticipants());
    }
}
