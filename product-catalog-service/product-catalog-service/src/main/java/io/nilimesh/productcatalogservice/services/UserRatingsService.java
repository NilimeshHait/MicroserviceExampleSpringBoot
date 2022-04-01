package io.nilimesh.productcatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.nilimesh.productcatalogservice.model.Ratings;
import io.nilimesh.productcatalogservice.model.UserRatings;

@Service
public class UserRatingsService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRatings",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "6"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
			})
	public UserRatings getUserRatings(@PathVariable("productId") String productId) {
		return restTemplate.getForObject("http://product-rating-service/ratings/" + productId, UserRatings.class);
		
	}
	
	public UserRatings getFallbackUserRatings(@PathVariable("productId") String productId) {
		UserRatings userRatings=new UserRatings();
		userRatings.setUserRatings(Arrays.asList(new Ratings("R1", "No user Id", productId, 0)));
		return userRatings;
	}
	

}
