package com.test.testJava.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
