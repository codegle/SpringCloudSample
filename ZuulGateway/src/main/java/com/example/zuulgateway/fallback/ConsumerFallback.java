package com.example.zuulgateway.fallback;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;

@Component
public class ConsumerFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return 200;
            }

            @Override
            public String getStatusText() {
                return "OK";
            }

            @Override
            public void close() {
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() {
                String message = String.format("The '%s' is unavailable.", route);
                return new ByteArrayInputStream(message.getBytes());
            }
        };
    }
}
