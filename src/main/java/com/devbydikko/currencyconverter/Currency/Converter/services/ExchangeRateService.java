package com.devbydikko.currencyconverter.Currency.Converter.services;

import reactor.core.publisher.Mono;

public interface ExchangeRateService {

    Mono<ExchangeRateResponse> fetchExchangeRates();
}
