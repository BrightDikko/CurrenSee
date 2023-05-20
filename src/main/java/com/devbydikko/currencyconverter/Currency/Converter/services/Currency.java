package com.devbydikko.currencyconverter.Currency.Converter.services;

/**
 * Currency --- A class representing a currency.
 *
 * @author brightdikko
 */
public class Currency {
    private int id;
    private String abbreviatedName;
    private String fullName;
    private double usdValue;

    /**
     * Constructs a new Currency instance with the provided parameters.
     *
     * @param id               the ID of the currency.
     * @param abbreviatedName  the abbreviated name of the currency (e.g., "USD").
     * @param fullName         the full name of the currency (e.g., "United States Dollar").
     * @param usdValue         the value of the currency in terms of USD.
     */
    public Currency(int id, String abbreviatedName, String fullName, double usdValue) {
        this.id = id;
        this.abbreviatedName = abbreviatedName;
        this.fullName = fullName;
        this.usdValue = usdValue;
    }

    /**
     * Returns the ID of the currency.
     *
     * @return the ID of the currency.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the currency.
     *
     * @param id  the new ID of the currency.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the abbreviated name of the currency.
     *
     * @return the abbreviated name of the currency.
     */
    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    /**
     * Sets the abbreviated name of the currency.
     *
     * @param abbreviatedName  the new abbreviated name of the currency.
     */
    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }

    /**
     * Returns the full name of the currency.
     *
     * @return the full name of the currency.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the currency.
     *
     * @param fullName  the new full name of the currency.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns the value of the currency in terms of USD.
     *
     * @return the value of the currency in terms of USD.
     */
    public double getUsdValue() {
        return usdValue;
    }

    /**
     * Sets the value of the currency in terms of USD.
     *
     * @param usdValue  the new value of the currency in terms of USD.
     */
    public void setUsdValue(double usdValue) {
        this.usdValue = usdValue;
    }

    /**
     * Returns a string representation of the Currency instance.
     *
     * @return a string representation of the Currency instance.
     */
    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", abbreviatedName='" + abbreviatedName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", usdValue=" + usdValue +
                '}';
    }
}
