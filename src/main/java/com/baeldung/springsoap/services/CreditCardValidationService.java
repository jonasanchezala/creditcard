package com.baeldung.springsoap.services;

import com.baeldung.springsoap.client.gen.GetCreditCardValidationRequest;
import com.baeldung.springsoap.client.gen.GetCreditCardValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidationService {

    private static final String MASTERCARD_PREFIX = "5";
    private static final String MASTERCARD_NAME = "MASTERCARD";
    private static final int MASTERCARD_LENGHT = 16;
    private static final double MASTERCARD_CREDIT = 10000000.0;
    private static final String VISA_PREFIX = "4";
    private static final String VISA_NAME = "VISA";
    private static final int VISA_LENGHT = 16;
    private static final double VISA_CREDIT = 5000000.0;
    private static final String AMERICANEXPRESS_PREFIX = "3";
    private static final String AMERICANEXPRESS_NAME = "AMERICANEXPRESS";
    private static final int AMERICANEXPRESS_LENGHT = 15;
    private static final double AMERICANEXPRESS_CREDIT = 300000.0;
    private static final String INVALID_CARD = "Invalid Card";

    public GetCreditCardValidationResponse Get(GetCreditCardValidationRequest request) {
        GetCreditCardValidationResponse creditCardValidationResponse = new GetCreditCardValidationResponse();

        String cardNumber = request.getNumber();
        creditCardValidationResponse.setNumber(cardNumber);

        if(cardNumber.startsWith(MASTERCARD_PREFIX) && cardNumber.length() == MASTERCARD_LENGHT){
            creditCardValidationResponse.setIssuingNetwork(MASTERCARD_NAME);
            creditCardValidationResponse.setBalance(MASTERCARD_CREDIT);
        } else if(cardNumber.startsWith(VISA_PREFIX) && cardNumber.length() == VISA_LENGHT){
            creditCardValidationResponse.setIssuingNetwork(VISA_NAME);
            creditCardValidationResponse.setBalance(VISA_CREDIT);
        } else if(cardNumber.startsWith(AMERICANEXPRESS_PREFIX) && cardNumber.length() == AMERICANEXPRESS_LENGHT){
            creditCardValidationResponse.setIssuingNetwork(AMERICANEXPRESS_NAME);
            creditCardValidationResponse.setBalance(AMERICANEXPRESS_CREDIT);
        } else {
            creditCardValidationResponse.setIssuingNetwork(INVALID_CARD);
            creditCardValidationResponse.setBalance(0);
        }

        return creditCardValidationResponse;
    }
}
