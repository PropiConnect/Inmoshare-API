package com.propiconnect.inmoshare.payments.interfaces.rest.transform;

import com.propiconnect.inmoshare.payments.domain.model.commands.CreatePaymentCommand;
import com.propiconnect.inmoshare.payments.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {

    public static CreatePaymentCommand toCommand(CreatePaymentResource resource) {
        return new CreatePaymentCommand(resource.cardNumber(), resource.participants());
    }
}
