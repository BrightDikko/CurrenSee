package com.devbydikko.currencyconverter.Currency.Converter.services;

import java.util.Map;

public class ExchangeRateResponse {
    private Meta meta;
    private Map<String, CurrencyData> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Map<String, CurrencyData> getData() {
        return data;
    }

    public void setData(Map<String, CurrencyData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }

    public static class Meta {
        private String last_updated_at;

        public String getLast_updated_at() {
            return last_updated_at;
        }

        public void setLast_updated_at(String last_updated_at) {
            this.last_updated_at = last_updated_at;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "last_updated_at='" + last_updated_at + '\'' +
                    '}';
        }
    }

    public static class CurrencyData {
        private String code;
        private Double value;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CurrencyData{" +
                    "code='" + code + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
