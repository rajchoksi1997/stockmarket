package com.stockmarket.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockmarketApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockmarketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StockmarketApplication.class, args);
		
		LOGGER.info("Inside  Stockmarket ServiceApplication main");
	}

}
