package com.example.serviceconsumer.fallback;

import org.springframework.stereotype.Component;
import com.example.serviceconsumer.service.SampleService;

@Component
public class SampleFallback implements SampleService {
    @Override
    public String getHost() {
        return "The 'getHost' calls failed.";
    }
}
