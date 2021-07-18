package com.example.serviceconsumer.controller;

import javax.annotation.Resource;
import com.example.serviceconsumer.service.SampleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @Resource
    private SampleService sampleService;

    @GetMapping("/getHost")
    public String getHost() {
        return sampleService.getHost();
    }
}
