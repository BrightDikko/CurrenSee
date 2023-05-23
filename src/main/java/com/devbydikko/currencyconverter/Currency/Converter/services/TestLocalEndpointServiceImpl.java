package com.devbydikko.currencyconverter.Currency.Converter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

@Service
public class TestLocalEndpointServiceImpl implements TestLocalEndpointService{
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void testLocalEndpoint() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/currency-converter?from=USD&to=GBP&amount=10";

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            System.out.println(response.getBody());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
        }
    }

}
