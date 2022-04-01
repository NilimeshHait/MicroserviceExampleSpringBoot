package io.nilimesh.productcatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCatalogItems {
	
	String userId;
	String productName;
	String desc;
	double ratingCL;
	
	

}
