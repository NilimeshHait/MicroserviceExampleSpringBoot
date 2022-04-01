package io.nilimesh.productinfoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.nilimesh.productinfoservice.dao.ProductInfoServiceRepository;
import io.nilimesh.productinfoservice.model.ProductsInfo;

@RestController
@RequestMapping("/product-info")
public class ProductInfoController {
	
	@Autowired
	private ProductInfoServiceRepository productInfoServiceRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/abcd/{productId}")
	public ProductsInfo getProductsList(@PathVariable("productId") String productId){
		
		ProductsInfo productInfo=productInfoServiceRepository.findByProductId(productId);
		//return new ProductsInfo(productId, "Product 1", "product desc 1", 50.00);
		return productInfo;
		
	}
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductsInfo productsInfo) {
		productInfoServiceRepository.save(productsInfo);
		return "Product Added with Id "+productsInfo.getProductId();
		
	}

}
