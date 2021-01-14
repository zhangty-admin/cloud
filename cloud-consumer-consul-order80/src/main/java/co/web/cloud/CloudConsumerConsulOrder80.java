package co.web.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerConsulOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerConsulOrder80.class, args);
    }

}
