package com.web.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/consulPayment")
public class ConsulPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t"
                + UUID.randomUUID().toString();
    }

}
