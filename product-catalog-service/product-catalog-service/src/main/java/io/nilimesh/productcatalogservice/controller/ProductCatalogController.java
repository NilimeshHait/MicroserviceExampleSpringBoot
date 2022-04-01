package io.nilimesh.productcatalogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.nilimesh.productcatalogservice.model.ProductCatalogItems;
import io.nilimesh.productcatalogservice.model.ProductsInfo;
import io.nilimesh.productcatalogservice.model.Ratings;
import io.nilimesh.productcatalogservice.model.UserRatings;
import io.nilimesh.productcatalogservice.services.ProductInfoService;
import io.nilimesh.productcatalogservice.services.UserRatingsService;

@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogController {

	
	@Autowired
	ProductInfoService productInfoService;
	
	@Autowired
	UserRatingsService userRatingsService;

	@GetMapping("/{productId}")
	public List<ProductCatalogItems> getProductsCatalog(@PathVariable("productId") String productId) {

		UserRatings ratings = userRatingsService.getUserRatings(productId);
		return ratings.getUserRatings().stream().map(rating -> productInfoService.getProductItems(rating))
				.collect(Collectors.toList());

	}
	
	
	
	
	
	
	
	
	

	private List<ProductCatalogItems> getFallbackProductCatalog(@PathVariable("productId") String productId) {
		return Arrays.asList(new ProductCatalogItems("", "No Product", "No Desc", 0));
	}

}
