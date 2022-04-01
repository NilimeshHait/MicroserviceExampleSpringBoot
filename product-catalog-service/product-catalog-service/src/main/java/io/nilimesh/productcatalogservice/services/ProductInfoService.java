package io.nilimesh.productcatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.nilimesh.productcatalogservice.model.ProductCatalogItems;
import io.nilimesh.productcatalogservice.model.ProductsInfo;
import io.nilimesh.productcatalogservice.model.Ratings;

@Service
public class ProductInfoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackProductCatalog",
			commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "6"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
	})
	public ProductCatalogItems getProductItems(Ratings rating) {
		ProductsInfo productsInfo = restTemplate.getForObject(
				"http://product-info-service/product-info/abcd/" + rating.getProductId(), ProductsInfo.class);
		//restTemplate.exchange(null, null, null, null)
		return new ProductCatalogItems(rating.getUserId(), productsInfo.getProductName(), productsInfo.getProductDesc(),
				rating.getRating());
		
	}
	
	public ProductCatalogItems getFallbackProductCatalog(Ratings rating) {
		return new ProductCatalogItems(rating.getUserId(), "Product Not found", "",
				rating.getRating());
	}

}
