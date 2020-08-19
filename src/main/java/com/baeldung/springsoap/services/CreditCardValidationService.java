package com.baeldung.springsoap.services;

import com.baeldung.springsoap.client.gen.GetCreditCardValidationRequest;
import com.baeldung.springsoap.client.gen.GetCreditCardValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidationService {

    public GetCreditCardValidationResponse Get(GetCreditCardValidationRequest request) {
        GetCreditCardValidationResponse creditCardValidationResponse = new GetCreditCardValidationResponse();
        creditCardValidationResponse.setNumber(request.getNumber());
        creditCardValidationResponse.setIssuingNetwork("VISA");
        creditCardValidationResponse.setBalance(10000.0);
        return creditCardValidationResponse;
    }
}
