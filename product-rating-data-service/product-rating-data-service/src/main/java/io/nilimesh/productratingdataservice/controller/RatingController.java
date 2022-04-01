package io.nilimesh.productratingdataservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nilimesh.productratingdataservice.model.Ratings;
import io.nilimesh.productratingdataservice.model.UserRatings;

@RestController
@RequestMapping("ratings")
public class RatingController {
	
	@GetMapping("/{productId}")
	public UserRatings getRatings(@PathVariable("productId") String productId){
		List<Ratings> ratings =	Arrays.asList(
				new Ratings("10", "1001", "P1", 5.5),
				new Ratings("11", "1002", "P1", 8.5),
				new Ratings("12", "1002", "P2", 8.5)
			);
		UserRatings userRatings= new UserRatings();
		userRatings.setUserRatings(ratings);
		return userRatings;
	}
	
	

}
