package com.devbydikko.currencyconverter.Currency.Converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The main entry point for the CurrencyConverter application.
 *
 * @author brightdikko
 */
@SpringBootApplication
public class CurrencyConverterApplication {

	/**
	 * Starts the CurrencyConverter application.
	 *
	 * @param args  command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
