package com.example.serviceprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @Value("${eureka.instance.hostname}")
    private String hostname;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getHost")
    public String getHost() {
        return String.format("%s:%d", hostname, port);
    }
}
