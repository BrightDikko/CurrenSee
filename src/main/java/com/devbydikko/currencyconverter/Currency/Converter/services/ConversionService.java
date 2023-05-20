package com.devbydikko.currencyconverter.Currency.Converter.services;

/**
 * Interface defining methods for currency conversion services.
 */
public interface ConversionService {

    /**
     * Method to convert a specified amount from one currency to another.
     *
     * @param from   The currency to convert from.
     * @param to     The currency to convert to.
     * @param amount The amount to be converted.
     * @return       The converted amount as a String.
     */
    String convertCurrency(String from, String to, String amount);

    /**
     * Performs the actual conversion calculation from the initial currency to the target currency.
     *
     * @param amountToBeConverted    The amount to be converted.
     * @param initialCurrencyUSDRate The conversion rate of the initial currency.
     * @param targetCurrencyUSDRate  The conversion rate of the target currency.
     * @return                       The converted amount.
     */
    double executeConversion(double amountToBeConverted, double initialCurrencyUSDRate, double targetCurrencyUSDRate);
}
