package com.devbydikko.currencyconverter.Currency.Converter.controllers;

import com.devbydikko.currencyconverter.Currency.Converter.services.ConversionService;
import com.devbydikko.currencyconverter.Currency.Converter.services.ExchangeRateResponse;
import com.devbydikko.currencyconverter.Currency.Converter.services.ExchangeRateServiceImpl;
import com.devbydikko.currencyconverter.Currency.Converter.services.TestLocalEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * HomeController --- Controller class that handles incoming requests for the currency conversion operation.
 *
 * @author brightdikko
 */
@RestController
public class HomeController {
    private final ConversionService conversionService;
    private final TestLocalEndpointService testLocalEndpointService;
    private final ExchangeRateServiceImpl exchangeRateServiceImpl;

    /**
     * Constructor for HomeController. Has Autowired annotation which allows for automatic dependency injection.
     *
     * @param conversionService a service for converting currencies.
     */

    @Autowired
    public HomeController(ConversionService conversionService, TestLocalEndpointService testLocalEndpointService, ExchangeRateServiceImpl exchangeRateServiceImpl) {
        this.conversionService = conversionService;
        this.testLocalEndpointService = testLocalEndpointService;
        this.exchangeRateServiceImpl = exchangeRateServiceImpl;
    }

    /**
     * GET endpoint for currency conversion. Accepts query parameters for source currency, target currency,
     * and the amount to convert. Returns the conversion result as a JSON object.
     *
     * @param allParams map containing the query parameters from the request.
     * @return a map containing the original query parameters and the conversion result.
     */
    @GetMapping("/currency-converter")
    // @ResponseBody //@RestController already contains this annotation
    public Map<String, String> digestRequestParameters(@RequestParam Map<String, String> allParams) {
        String from = allParams.get("from");
        String to = allParams.get("to");
        String amount = allParams.get("amount");

        String result = conversionService.convertCurrency(from.toUpperCase(), to.toUpperCase(), amount);

        Map<String, String> response = new HashMap<>();
        response.put("from", from.toUpperCase());
        response.put("to", to.toUpperCase());
        response.put("amount", amount);
        response.put("result", result);

        return response;

    }

    @GetMapping("/currency-converter/test")
    public String convertUsingExternalApi() throws IOException, InterruptedException {

        testLocalEndpointService.testLocalEndpoint();

        return "Test ran successfully. See build console for test output.";
    }

    @GetMapping("/currency-converter/today-rates")
    public Mono<ExchangeRateResponse> getTodayExchangeRates() {
        
        Mono<ExchangeRateResponse> rates = exchangeRateServiceImpl.fetchExchangeRates();
        
        /*
        // Get rates and print to build console

        Mono<ExchangeRateResponse> rates = exchangeRateService.fetchExchangeRates()
                .doOnNext(response -> System.out.println(">> Response = " + response));
         */

        return rates;
    }
}
