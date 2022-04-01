package io.nilimesh.productcatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {
	
	String ratingId;
	String userId;
	String productId;
	double rating;
	
}
