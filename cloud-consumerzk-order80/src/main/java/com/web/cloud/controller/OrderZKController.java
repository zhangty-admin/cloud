package com.web.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderZKController {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://cloud-provider-payment";

    @GetMapping
    private String getZookeeper() {
        return restTemplate.getForObject(url + "/zookeeper/payment/zk",String.class);
    }
}
