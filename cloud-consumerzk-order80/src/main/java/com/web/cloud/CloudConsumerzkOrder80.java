package com.web.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerzkOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerzkOrder80.class, args);
    }
}
