package com.eazydineapp.restaurant.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.eazydineapp.restaurant.dao.RestaurantDao;
import com.eazydineapp.restaurant.model.Restaurant;
import com.eazydineapp.restaurant.model.RestaurantCuisines;
import com.eazydineapp.restaurant.model.RestaurantTimeRange;
import com.eazydineapp.restaurant.util.DynamoDbClient;

/**
 * Repository implementation class
 * 
 * @author Harini Balakrishnan
 *
 */
@Repository
public class RestaurantDaoImpl implements RestaurantDao {

	@Autowired
	DynamoDbClient dynamodbClient;

	@Override
	public void createOrUpdate(Restaurant restaurant) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();
		mapper.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantByRestaurantId(String Id) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#id", "id");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
		expressionAttributeValues.put(":idValue", new AttributeValue().withS(Id));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants.get(0);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();
		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withConsistentRead(false);
		
		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public List<Restaurant> getRestaurantsBySearch(Set<String> serviceArea, List<RestaurantCuisines> cuisines,
			String expenseRate,  String starRate, Boolean hasReservations, Set<RestaurantTimeRange> openingHours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getRestaurantsBySeviceArea(Set<String> serviceArea) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#serviceArea", "serviceArea");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
		expressionAttributeValues.put(":serviceAreaValue", new AttributeValue().withSS(serviceArea));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public List<Restaurant> getRestaurantsByCuisines(List<RestaurantCuisines> cuisines) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#cuisines", "cuisines");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
//		expressionAttributeValues.put(":cuisinesValue", new AttributeValue().withL(List<RestaurantCuisines> cuisines));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public List<Restaurant> getRestaurantsByExpenseRate(String expenseRate) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#expenseRate", "expenseRate");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
		expressionAttributeValues.put(":expenseRateValue", new AttributeValue().withS(expenseRate));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public List<Restaurant> getRestaurantsByStarRate( String starRate) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#starRate", "starRate");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
		expressionAttributeValues.put(":starRateValue", new AttributeValue().withS(starRate.toString()));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public List<Restaurant> getRestaurantsWithReservations(Boolean hasReservations) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#hasReservations", "hasReservations");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
		expressionAttributeValues.put(":hasReservationsValue", new AttributeValue().withBOOL(hasReservations));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public List<Restaurant> getRestaurantsWithOpenHours(Set<RestaurantTimeRange> openingHours) {
		DynamoDBMapper mapper = dynamodbClient.getDynamoDBMapper();

		Map<String, String> expressionAttributesNames = new HashMap<>();
		expressionAttributesNames.put("#openingHours", "openingHours");

		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
//		expressionAttributeValues.put(":openingHoursValue", new AttributeValue().withSS(openingHours));

		DynamoDBQueryExpression<Restaurant> dynamoDBQueryExpression = new DynamoDBQueryExpression<Restaurant>()
				.withExpressionAttributeNames(expressionAttributesNames)
				.withExpressionAttributeValues(expressionAttributeValues)
				.withConsistentRead(false);

		List<Restaurant> restaurants = mapper.query(Restaurant.class, dynamoDBQueryExpression);
		return restaurants;
	}

	@Override
	public void delete(Restaurant restaurant) {
		// TODO Auto-generated method stub
	}

}
