package com.web.cloud.controller;

import com.web.cloud.entities.CommonResult;
import com.web.cloud.entities.Payment;


import com.web.cloud.enums.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private String url = "http://CLOUD-PAYMENT-SERVER";

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(url + "/payment/getPayment/" + id, CommonResult.class);
    }

    @GetMapping("/paymentEntity/{id}")
    public CommonResult<Payment> getPaymentByIdForEntity(@PathVariable("id") Long id) {
        ;
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(url + "/payment/getPayment/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }
        return new CommonResult<>(Code.ERROR.value(),"操作失败");
    }

    @PostMapping("/createPayment")
    public CommonResult createPayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(url + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/discovery")
    public Object getDiscovery() {
        //获取实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "=====" + instance.getHost() + "=====" + instance.getPort() + "=====" + instance.getUri() + "=====" + instance.getMetadata() + "=====" + instance.getScheme());
        }
        int order = discoveryClient.getOrder();
        log.info("order" + order);
        //获取服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        return discoveryClient;
    }

}
