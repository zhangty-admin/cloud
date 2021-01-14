package com.web.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = {"com.web.cloud.dao"})
public class ProviderPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8001Application.class);
    }
}
