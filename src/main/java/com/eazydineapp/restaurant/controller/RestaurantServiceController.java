package com.eazydineapp.restaurant.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazydineapp.restaurant.model.RestaurantCuisines;
import com.eazydineapp.restaurant.model.RestaurantTimeRange;
import com.eazydineapp.restaurant.request.RestaurantRequest;
import com.eazydineapp.restaurant.response.RestaurantResponse;
import com.eazydineapp.restaurant.service.RestaurantService;

/**
 * Rest Controller for Restaurant Microservice
 * 
 * @author Harini Balakrishnan
 *
 */
@RestController
@RequestMapping("restaurant")
public class RestaurantServiceController {

	@Autowired
	RestaurantService restaurantService;

	/**
	 * Create Restaurant API
	 * 
	 * @param createRestaurantRequest
	 * @return
	 */
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createRestaurant(@RequestBody RestaurantRequest createRestaurantRequest) {
		RestaurantResponse restaurant = restaurantService.createRestaurant(createRestaurantRequest);
		return new ResponseEntity<RestaurantResponse>(restaurant, HttpStatus.OK);
	}
	
	
	/**
	 * Get Restaurant API using the Restaurant ID
	 * @param resId
	 * @return
	 */
	@GetMapping(value = "/")
	public ResponseEntity<?> getRestaurant(@RequestParam(name = "resId", required = true) String resId){
		RestaurantResponse restaurant = restaurantService.getRestaurant(resId);
		return new ResponseEntity<RestaurantResponse>(restaurant, HttpStatus.OK);
	}
	
	
	/**
	 * Update Restaurant API using the Restaurant ID
	 * @param updateRestaurantRequest
	 * @return
	 */
	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantRequest updateRestaurantRequest) {
		RestaurantResponse restaurant = restaurantService.updateRestaurant(updateRestaurantRequest);
		return new ResponseEntity<RestaurantResponse>(restaurant, HttpStatus.OK);
	}
	
	/**
	 * Delete Restaurant API using the Restaurant ID
	 * @param updateRestaurantRequest
	 * @return
	 */
	@DeleteMapping(value="/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteRestaurant(@RequestBody RestaurantRequest deleteRestaurantRequest) {
		restaurantService.deleteRestaurant(deleteRestaurantRequest);
		return new ResponseEntity<RestaurantResponse>(HttpStatus.OK);
	}
		
	
	/**
	 * Get Restaurants API using various filters and sort criteria
	 * @param serviceArea
	 * @param cuisines
	 * @param expenseRate
	 * @param openingHours
	 * @param starRate
	 * @param hasReservations
	 * @return
	 */
	@GetMapping(value = "/search")
	public ResponseEntity<?> getRestaurants(@RequestParam(name = "serviceArea", required = true) Set<String> serviceArea,
			@RequestParam(name = "cuisines", required = false)  List<RestaurantCuisines> cuisines,
			@RequestParam(name = "expenseRate", required = false) String expenseRate,
			@RequestParam(name = "starRate", required = false)  String starRate,
			@RequestParam(name = "hasReservations", required = false)  Boolean hasReservations,
			@RequestParam(name = "openingHours", required = false)  Set<RestaurantTimeRange> openingHours) {
		List<RestaurantResponse> restaurants = restaurantService.getRestaurantsBySearch(serviceArea, cuisines, expenseRate, starRate, hasReservations, openingHours);
		return new ResponseEntity<List<RestaurantResponse>>(restaurants, HttpStatus.OK);
	}
	
}
