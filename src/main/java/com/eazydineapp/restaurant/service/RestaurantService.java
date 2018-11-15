package com.eazydineapp.restaurant.service;

import java.util.List;
import java.util.Set;

import com.eazydineapp.restaurant.model.RestaurantCuisines;
import com.eazydineapp.restaurant.model.RestaurantTimeRange;
import com.eazydineapp.restaurant.request.RestaurantRequest;
import com.eazydineapp.restaurant.response.RestaurantResponse;

/**
 * Service Layer for all Restaurant APIs
 * @author Harini Balakrishnan 
 *
 */
public interface RestaurantService {

	/**
	 * Create Restaurant
	 * @param createRestaurantRequest
	 * @return
	 */
	RestaurantResponse createRestaurant(RestaurantRequest createRestaurantRequest);
	
	/**
	 * Get Restaurant based on Restaurant ID
	 * @param getRestaurant
	 * @return
	 */
	RestaurantResponse getRestaurant(String id);

	
	/**
	 * Update Restaurant
	 * @param updateRestaurantRequest
	 * @return
	 */
	RestaurantResponse updateRestaurant(RestaurantRequest updateRestaurantRequest);

	
	/**
	 * Delete Restaurant
	 * @param deleteRestaurantRequest
	 * @return
	 */
	void deleteRestaurant(RestaurantRequest deleteRestaurantRequest);


	/**
	 * Get Restaurants based on various filters and criteria
	 * @param serviceArea
	 * @param cuisines
	 * @param expenseRate
	 * @param openingHours
	 * @param starRate
	 * @param hasReservations
	 * @return
	 */
	List<RestaurantResponse> getRestaurantsBySearch(Set<String> serviceArea, List<RestaurantCuisines> cuisines,
			String expenseRate, String starRate, Boolean hasReservations, Set<RestaurantTimeRange> openingHours);
}
