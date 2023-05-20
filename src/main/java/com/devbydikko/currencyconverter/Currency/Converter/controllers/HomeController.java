package com.devbydikko.currencyconverter.Currency.Converter.controllers;

import com.devbydikko.currencyconverter.Currency.Converter.services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * HomeController --- Controller class that handles incoming requests for the currency conversion operation.
 *
 * @author brightdikko
 */
@RestController
public class HomeController {

    // An instance of ConversionService for performing the currency conversion
    private final ConversionService conversionService;

    /**
     * Constructor for HomeController. Has Autowired annotation which allows for automatic dependency injection.
     *
     * @param conversionService a service for converting currencies.
     */
    @Autowired
    public HomeController(ConversionService conversionService) {
        this.conversionService = conversionService;
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

        /*
        // System.out.println("\nAll request parameters: \n" +
        //        "from = " + from + ",\n" +
        //        "to = " + to + ",\n" +
        //        "amount = " + amount + "\n");
        */

        String result = conversionService.convertCurrency(from, to, amount);

        Map<String, String> response = new HashMap<>();
        response.put("from", from);
        response.put("to", to);
        response.put("amount", amount);
        response.put("result", result);

        return response;

    }
}
