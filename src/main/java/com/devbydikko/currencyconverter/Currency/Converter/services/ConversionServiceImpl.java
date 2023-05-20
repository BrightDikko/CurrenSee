package com.devbydikko.currencyconverter.Currency.Converter.services;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ConversionServiceImpl --- Service class for converting between currencies.
 * Implements the ConversionService interface.
 *
 * @author brightdikko
 */
@Service
public class ConversionServiceImpl implements ConversionService {
    // Current state of the currencies involved in the conversion
    private Currency initialCurrency;
    private Currency targetCurrency;

    // List of valid currencies
    private final String[] validCurrencies = {"USD", "EUR", "GBP", "JPY", "AED", "BRL", "CHF", "CNY", "HKD", "KWD"};

    // Mapping of currency codes to their value in USD
    private final HashMap<String, Double> currencyInUSD = new HashMap<String, Double>();

    // List of Currency objects representing all the available currencies
    private List<Currency> currencies = new ArrayList<>(10);

    /**
     * Constructor that initializes the currencyInUSD HashMap and
     * currencies List with currency values and Currency objects respectively.
     */
    public ConversionServiceImpl() {
        // Populate the currencyInUSD HashMap with corresponding USD values
        this.currencyInUSD.put("USD", 1.0000);
        this.currencyInUSD.put("EUR", 1.0843);
        this.currencyInUSD.put("GBP", 1.2473);
        this.currencyInUSD.put("JPY", 0.0073);
        this.currencyInUSD.put("AED", 0.2723);
        this.currencyInUSD.put("BRL", 0.2023);
        this.currencyInUSD.put("CHF", 1.1133);
        this.currencyInUSD.put("CNY", 0.1429);
        this.currencyInUSD.put("HKD", 0.1277);
        this.currencyInUSD.put("KWD", 3.2489);


        // Create Currency objects for each type of currency
        // United States Dollar
        Currency USD = new Currency(1, "USD", "United States Dollar", currencyInUSD.get("USD"));

        // Euro
        Currency EUR = new Currency(2, "EUR", "Euro", currencyInUSD.get("EUR"));

        // Great British Pound
        Currency GBP = new Currency(3, "GBP", "Great British Pound", currencyInUSD.get("GBP"));

        // Japanese Yen
        Currency JPY = new Currency(4, "JPY", "Japanese Yen", currencyInUSD.get("JPY"));

        // United Arab Emirates Dirham
        Currency AED = new Currency(5, "AED", "United Arab Emirates Dirham", currencyInUSD.get("AED"));

        // Brazilian Real
        Currency BRL = new Currency(6, "BRL", "Brazilian Real", currencyInUSD.get("BRL"));

        // Swiss Franc
        Currency CHF = new Currency(7, "CHF", "Swiss Franc", currencyInUSD.get("CHF"));

        // Chinese Yuan Renminbi
        Currency CNY = new Currency(8, "CNY", "Chinese Yuan Renminbi", currencyInUSD.get("CNY"));

        // Hong Kong Dollar
        Currency HKD = new Currency(9, "HKD", "Hong Kong Dollar", currencyInUSD.get("HKD"));

        // Kuwaiti Dinar
        Currency KWD = new Currency(10, "KWD", "Kuwaiti Dinar", currencyInUSD.get("KWD"));

        // Add all created Currency objects to the list
        this.currencies = List.of(USD, EUR, GBP, JPY, AED, BRL, CHF, CNY, HKD, KWD);
    }



    /**
     * Converts a given amount from one currency to another.
     *
     * @param from   The currency to convert from.
     * @param to     The currency to convert to.
     * @param amount The amount to be converted.
     * @return       The converted amount as a String.
     */
    @Override
    public String convertCurrency(String from, String to, String amount) {
        // Locate the original and target Currency objects
        for (Currency currency: currencies){
            if (currency.getAbbreviatedName().equals(from)) {
                initialCurrency = currency;
            }
            if (currency.getAbbreviatedName().equals(to)) {
                targetCurrency = currency;
            }
        }

        double amountToBeConverted = Double.parseDouble(amount);

        // Get the conversion rates for the original and target currencies
        double initialCurrencyUSDRate = currencyInUSD.get(initialCurrency.getAbbreviatedName());
        double targetCurrencyUSDRate = currencyInUSD.get(targetCurrency.getAbbreviatedName());

        // Calculate and format the converted amount, then display the result to build console for debug
        double amountAfterConversion = executeConversion(amountToBeConverted, initialCurrencyUSDRate, targetCurrencyUSDRate);
        displayResult(amountToBeConverted, amountAfterConversion, initialCurrency, targetCurrency);

        return Double.toString(amountAfterConversion);
    }

    /**
     * Performs the actual currency conversion calculation.
     *
     * @param amountToBeConverted    The amount to convert.
     * @param initialCurrencyUSDRate The conversion rate of the original currency.
     * @param targetCurrencyUSDRate  The conversion rate of the target currency.
     * @return                       The converted amount.
     */
    @Override
    public double executeConversion(double amountToBeConverted, double initialCurrencyUSDRate, double targetCurrencyUSDRate) {
        double resultInUSD = (amountToBeConverted * initialCurrencyUSDRate);
        double resultInTargetCurrency = (resultInUSD / targetCurrencyUSDRate);
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String roundedResultString = decimalFormat.format(resultInTargetCurrency);

        return Double.parseDouble(roundedResultString);

    };

    /**
     * Displays the conversion result to build console.
     *
     * @param amountToBeConverted   The original amount.
     * @param amountAfterConversion The converted amount.
     * @param initialCurrency       The original currency.
     * @param targetCurrency        The target currency.
     */
    public void displayResult(double amountToBeConverted, double amountAfterConversion, Currency initialCurrency, Currency targetCurrency) {
        System.out.println("\nConversion Result: ");
        System.out.println(amountToBeConverted + " " + initialCurrency.getAbbreviatedName() + " ==> " + amountAfterConversion + " " + targetCurrency.getAbbreviatedName());
    }
}
