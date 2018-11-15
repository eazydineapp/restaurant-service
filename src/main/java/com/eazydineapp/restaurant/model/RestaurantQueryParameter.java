package com.eazydineapp.restaurant.model;


/**
 * Restaurant Query Parameter 
 * @author Harini Balakrishnan
 *
 */
public enum RestaurantQueryParameter {
	
    RestaurantId("id"), RestaurantCuisine("cuisines"), RestaurantServiceArea("serviceArea"), 
    RestaurantExpenseRate("expenseRate"), RestaurantTimeRange("openingHours"), RestaurantStarRate("starRate"), 
    RestaurantHasReservations("hasReservations") ;
	
	String value;
	
	RestaurantQueryParameter(String value) {
		this.value = value;
	}
}
