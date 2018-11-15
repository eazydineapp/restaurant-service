package com.eazydineapp.restaurant.dao;

import java.util.List;
import java.util.Set;

import com.eazydineapp.restaurant.model.Restaurant;
import com.eazydineapp.restaurant.model.RestaurantCuisines;
import com.eazydineapp.restaurant.model.RestaurantTimeRange;

/**
 * Restaurant Repository to save/retrieve from DynamoDB
 * @author Harini Balakrishnan
 *
 */
public interface RestaurantDao {

	/**
	 * Create or Update Restaurant
	 * @param restaurant
	 */
	void createOrUpdate(Restaurant restaurant);

	/**
	 * Fetch all restaurants  
	 *  * @return
	 */
	List<Restaurant> getRestaurants();
	
	
	/**
	 * Fetch restaurant by restaurant id
	 * @param resId
	 * @param sortciteria
	 * @return
	 */
	Restaurant getRestaurantByRestaurantId(String resId);
	
	/**
	 * Fetch all Restaurants based on various filter criterias
	 * @param serviceArea
	 * @param cuisines
	 * @param expenseRate
	 * @param openingHours
	 * @param starRate
	 * @param hasReservations
	 * @return
	 */
	List<Restaurant> getRestaurantsBySearch(Set<String> serviceArea, List<RestaurantCuisines> cuisines,
			String expenseRate,  String starRate, Boolean hasReservations, Set<RestaurantTimeRange> openingHours);
	

	/**
	 * Fetch restaurants based on serviceArea
	 * @param serviceArea
	 * @return
	 */
	List<Restaurant> getRestaurantsBySeviceArea(Set<String> serviceArea);

	/**
	 * Fetch restaurants based on cuisines
	 * @param cuisines
	 * @return
	 */
	List<Restaurant> getRestaurantsByCuisines(List<RestaurantCuisines> cuisines);
	
	/**
	 * Fetch restaurants based on expenseRate
	 * @param expenseRate
	 * @return
	 */
	List<Restaurant> getRestaurantsByExpenseRate(String expenseRate);
	
	/**
	 * Fetch restaurants based on starRate
	 * @param starRate
	 * @return
	 */
	List<Restaurant> getRestaurantsByStarRate( String starRate);
	
	/**
	 * Fetch restaurants based on hasReservations
	 * @param hasReservations
	 * @return
	 */
	List<Restaurant> getRestaurantsWithReservations(Boolean hasReservations);
	
	/**
	 * Fetch restaurants based on openingHours
	 * @param openingHours
	 * @return
	 */
	List<Restaurant> getRestaurantsWithOpenHours(Set<RestaurantTimeRange> openingHours);
	
	/**
	 * Delete Restaurant
	 * @param restaurant
	 * @return
	 */
	void delete(Restaurant restaurant);
}
