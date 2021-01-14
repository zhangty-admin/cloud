package com.web.cloud.service;

import com.web.cloud.entities.Payment;

public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
