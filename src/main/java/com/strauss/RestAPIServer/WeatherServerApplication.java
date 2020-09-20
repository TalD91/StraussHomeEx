package com.strauss.RestAPIServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Tal David
 */
@SpringBootApplication
public class WeatherServerApplication {

	/**
	 * @return WebClient needed later to connect the weather API
	 */
	@Bean
	public WebClient.Builder initClient() {
		return WebClient.builder();
	}

	/**
	 * Main runner for Sprint framework
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeatherServerApplication.class, args);
	}

}
