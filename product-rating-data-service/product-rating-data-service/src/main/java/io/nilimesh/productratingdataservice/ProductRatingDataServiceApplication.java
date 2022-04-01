package io.nilimesh.productratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductRatingDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRatingDataServiceApplication.class, args);
	}

}
