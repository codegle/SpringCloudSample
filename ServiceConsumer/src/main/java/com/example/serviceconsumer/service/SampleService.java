package com.example.serviceconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.serviceconsumer.fallback.SampleFallback;

@FeignClient(name="service-provider", fallback=SampleFallback.class)
public interface SampleService {
    @GetMapping ("/sample/getHost")
    String getHost();
}
