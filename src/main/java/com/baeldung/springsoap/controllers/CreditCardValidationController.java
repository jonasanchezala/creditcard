package com.baeldung.springsoap.controllers;

import com.baeldung.springsoap.client.gen.GetCreditCardValidationRequest;
import com.baeldung.springsoap.client.gen.GetCreditCardValidationResponse;
import com.baeldung.springsoap.services.CreditCardValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreditCardValidationController {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    private final CreditCardValidationService creditCardValidationService;

    @Autowired
    public CreditCardValidationController(CreditCardValidationService creditCardValidationService) {
        this.creditCardValidationService = creditCardValidationService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCreditCardValidationRequest")
    @ResponsePayload
    public GetCreditCardValidationResponse getCreditCard(@RequestPayload GetCreditCardValidationRequest request) {
        return creditCardValidationService.Get(request);
    }
}
