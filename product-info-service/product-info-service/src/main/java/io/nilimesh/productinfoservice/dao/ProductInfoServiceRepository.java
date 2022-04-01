package io.nilimesh.productinfoservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.nilimesh.productinfoservice.model.ProductsInfo;

public interface ProductInfoServiceRepository extends MongoRepository<ProductsInfo, String>{
	
	public ProductsInfo findByProductId(String productId);

}
