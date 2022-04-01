package io.nilimesh.productinfoservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productinfoservice")
@Data
public class ProductsInfo {
	
	String productId;
	String productName;
	String productDesc;
	double productPrice;
	
	

}
