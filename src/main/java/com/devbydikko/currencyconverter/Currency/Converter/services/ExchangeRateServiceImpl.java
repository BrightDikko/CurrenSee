package com.devbydikko.currencyconverter.Currency.Converter.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final WebClient client;


    public ExchangeRateServiceImpl(WebClient.Builder builder) {
        this.client = builder.baseUrl("https://api.currencyapi.com").build();
    }

    public Mono<ExchangeRateResponse> fetchExchangeRates() {
        return this.client.get().uri("/v3/latest?apikey=Pa5QmW9zit4fy8uz818FReXj1qAI3bemes0nk7kG").retrieve().bodyToMono(ExchangeRateResponse.class);
    }
}
