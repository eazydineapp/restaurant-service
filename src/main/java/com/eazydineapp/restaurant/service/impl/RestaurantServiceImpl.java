package com.eazydineapp.restaurant.service.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.eazydineapp.restaurant.dao.RestaurantDao;
import com.eazydineapp.restaurant.model.Restaurant;
import com.eazydineapp.restaurant.model.RestaurantCuisines;
import com.eazydineapp.restaurant.model.RestaurantQueryParameter;
import com.eazydineapp.restaurant.model.RestaurantTimeRange;
import com.eazydineapp.restaurant.request.RestaurantRequest;
import com.eazydineapp.restaurant.response.RestaurantResponse;
import com.eazydineapp.restaurant.service.RestaurantService;
import com.google.gson.Gson;

/**
 * Restaurant Service Implementation class
 * 
 * @author Harini Balakrishnan 
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao RestaurantDao;

	private Gson gson = new Gson();

	@Override
	public RestaurantResponse createRestaurant(RestaurantRequest createRestaurantRequest) {
		String json = gson.toJson(createRestaurantRequest);
		Restaurant restaurant= gson.fromJson(json, Restaurant.class);
		
		restaurant.setRestaurantId(UUID.randomUUID().toString()); // generate Restaurant id
		String currentTime = String.valueOf(System.currentTimeMillis()); // generate created time

		restaurant.setCreatedTime(currentTime);
		restaurant.setModifiedTime(currentTime);
        restaurant.setRestaurantName(createRestaurantRequest.getRestaurantName());
        restaurant.setRestaurantAddress(createRestaurantRequest.getRestaurantAddress());
        restaurant.setRestaurantCusines(createRestaurantRequest.getRestaurantCuisines());
        restaurant.setRestaurantEmailAddress(createRestaurantRequest.getRestaurantEmailAddress());
        restaurant.setRestaurantHasReservation(createRestaurantRequest.getRestaurantHasReservations());
        restaurant.setRestaurantOccupancy(createRestaurantRequest.getRestaurantOccupancy());
        restaurant.setRestaurantTables(createRestaurantRequest.getRestaurantTables());
        restaurant.setRestaurantServiceArea(createRestaurantRequest.getRestaurantServiceArea());
        restaurant.setRestaurantTimeRange(createRestaurantRequest.getRestaurantTimeRange());
        restaurant.setRestaurantExpenseRate(createRestaurantRequest.getRestaurantExpenseRate());
        restaurant.setRestaurantStarRate(createRestaurantRequest.getRestaurantStarRate());
        
		RestaurantDao.createOrUpdate(restaurant);
		String restaurantJson = gson.toJson(restaurant);
		RestaurantResponse response = gson.fromJson(restaurantJson, RestaurantResponse.class);
		return response;
	}

	@Override
	public List<RestaurantResponse> getRestaurantsBySearch(Set<String> serviceArea, List<RestaurantCuisines> cuisines, String expenseRate, String starRate, Boolean hasReservations, Set<RestaurantTimeRange> openingHours){
		
		RestaurantQueryParameter filterCriteria = null;
		if(serviceArea.size() != 0 ) { filterCriteria = RestaurantQueryParameter.RestaurantServiceArea;}
		else if(cuisines.size() != 0) { filterCriteria = RestaurantQueryParameter.RestaurantCuisine; }
		else if(expenseRate != null) {filterCriteria = RestaurantQueryParameter.RestaurantExpenseRate; } 
		else if(starRate != null) { filterCriteria = RestaurantQueryParameter.RestaurantStarRate;}
		else if(openingHours.size() != 0) { filterCriteria = RestaurantQueryParameter.RestaurantTimeRange;}
		else if(hasReservations != null) { filterCriteria = RestaurantQueryParameter.RestaurantHasReservations;}

		List<Restaurant> Restaurants = null;
		switch (filterCriteria) {

		case RestaurantServiceArea:
			Restaurants = RestaurantDao.getRestaurantsBySeviceArea(serviceArea); // filter by service area list 
			break;
			
		case RestaurantCuisine:
			Restaurants = RestaurantDao.getRestaurantsByCuisines(cuisines); // filter by service area list 
			break;
			
		case RestaurantExpenseRate:
			Restaurants = RestaurantDao.getRestaurantsByExpenseRate(expenseRate); // filter by service area list 
			break;
			
		case RestaurantTimeRange:
			Restaurants = RestaurantDao.getRestaurantsWithOpenHours(openingHours); // filter by service area list 
			break;
			
		case RestaurantStarRate:
			Restaurants = RestaurantDao.getRestaurantsByStarRate(starRate); // filter by service area list 
			break;
			
		case RestaurantHasReservations:
			Restaurants = RestaurantDao.getRestaurantsWithReservations(hasReservations); // filter by service area list 
			break;
			
		default:
			Restaurants = RestaurantDao.getRestaurants();
			break;

		}

		List<RestaurantResponse> response = new ArrayList<>();
		if (!CollectionUtils.isEmpty(Restaurants)) {
			for (Restaurant Restaurant : Restaurants) {
				String RestaurantJson = gson.toJson(Restaurant);
				RestaurantResponse RestaurantResponse = gson.fromJson(RestaurantJson, RestaurantResponse.class);
				response.add(RestaurantResponse);
			}
		}
		return response;
	}
	
	@Override
	public RestaurantResponse getRestaurant(String id) {
		Restaurant restaurant = null;
		RestaurantResponse response = new  RestaurantResponse();
		restaurant = RestaurantDao.getRestaurantByRestaurantId(id);
		String RestaurantJson = gson.toJson(restaurant);
		response  = gson.fromJson(RestaurantJson, RestaurantResponse.class);
		return response;
	}

	
    @Override
    public RestaurantResponse updateRestaurant(RestaurantRequest updateRestaurantRequest) {
    	Restaurant restaurant = RestaurantDao.getRestaurantByRestaurantId(updateRestaurantRequest.getRestaurantId());

		if (null == restaurant) {
			// TODO: throw exception
		}
		String currentTime = String.valueOf(System.currentTimeMillis()); // generate modified time
		restaurant.setModifiedTime(currentTime);
		restaurant.setRestaurantName(updateRestaurantRequest.getRestaurantName());
        restaurant.setRestaurantAddress(updateRestaurantRequest.getRestaurantAddress());
        restaurant.setRestaurantCusines(updateRestaurantRequest.getRestaurantCuisines());
        restaurant.setRestaurantEmailAddress(updateRestaurantRequest.getRestaurantEmailAddress());
        restaurant.setRestaurantHasReservation(updateRestaurantRequest.getRestaurantHasReservations());
        restaurant.setRestaurantOccupancy(updateRestaurantRequest.getRestaurantOccupancy());
        restaurant.setRestaurantTables(updateRestaurantRequest.getRestaurantTables());
        restaurant.setRestaurantServiceArea(updateRestaurantRequest.getRestaurantServiceArea());
        restaurant.setRestaurantTimeRange(updateRestaurantRequest.getRestaurantTimeRange());
        restaurant.setRestaurantExpenseRate(updateRestaurantRequest.getRestaurantExpenseRate());
        restaurant.setRestaurantStarRate(updateRestaurantRequest.getRestaurantStarRate());
        
    	RestaurantDao.createOrUpdate(restaurant);

		String RestaurantJson = gson.toJson(restaurant);
		RestaurantResponse response = gson.fromJson(RestaurantJson, RestaurantResponse.class);
		return response;
    }

    @Override
    public void  deleteRestaurant(RestaurantRequest deleteRestaurantRequest) {
    	Restaurant restaurant = RestaurantDao.getRestaurantByRestaurantId(deleteRestaurantRequest.getRestaurantId());
    	if (null == restaurant) {
			// TODO: throw exception
		}
    	RestaurantDao.delete(restaurant);
    }


	

	
	

}
