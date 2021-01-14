package co.web.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consul")
public class ConsulController {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://consul-provider-payment";

    @GetMapping
    public String consult() {
        return restTemplate.getForObject(url + "/consulPayment", String.class);
    }

}
