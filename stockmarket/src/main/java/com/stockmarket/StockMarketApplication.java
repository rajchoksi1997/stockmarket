package com.stockmarket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockMarketApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockMarketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StockMarketApplication.class, args);
		
		LOGGER.info("Inside stock market ServiceApplication main");
	}

}