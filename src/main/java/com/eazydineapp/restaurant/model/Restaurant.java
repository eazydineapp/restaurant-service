package com.eazydineapp.restaurant.model;

import java.util.List;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;

/**
 * Restaurant Entity
 * @author Harini Balakrishnan
 *
 */
@DynamoDBTable(tableName = "Restaurants")
public class Restaurant {

	private String id; 
	private String name;
	private String address;
    private String emailAddress;
    private String expenseRate;
    private String starRate;
    private Set<String> serviceArea;
	private List<RestaurantCuisines> cuisines;
    private Set<RestaurantTimeRange> openingHours;
	private Boolean hasReservations;
	private List<RestaurantTables> tables;
	private String occupancy;
	private String createdTime;
	private String modifiedTime;
	

	@DynamoDBHashKey(attributeName = "id")
	public String getRestaurantId() {
		return id;
	}

	public void setRestaurantId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "name")
	public String getRestaurantName() {
		return name;
	}

	public void setRestaurantName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "address")
	public String getRestaurantAddress() {
		return  address;
	}

	public void setRestaurantAddress(String address) {
		this.address = address;
	}
	
	
	@DynamoDBAttribute(attributeName = "emailAddress")
	public String getRestaurantEmailAddress() {
		return emailAddress;
	}

	public void setRestaurantEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	@DynamoDBAttribute(attributeName = "expenseRate")
	public String getRestaurantExpenseRate() {
		return expenseRate;
	}

	public void setRestaurantExpenseRate(String expenseRate) {
		this.expenseRate = expenseRate;
	}
	
	@DynamoDBAttribute(attributeName = "starRate")
	public String getRestaurantStarRate() {
		return starRate;
	}

	public void setRestaurantStarRate(String starRate) {
		this.starRate = starRate;
	}
	
	@DynamoDBAttribute(attributeName = "serviceArea")
	public Set<String> getRestaurantServiceArea() {
		return serviceArea;
	}

	public void setRestaurantServiceArea(Set<String> serviceArea) {
		this.serviceArea = serviceArea;
	}
	
	@DynamoDBAttribute(attributeName = "cuisines")
	public List<RestaurantCuisines> getRestaurantCuisines() {
		return cuisines;
	}

	public void setRestaurantCusines(List<RestaurantCuisines> cuisines) {
		this.cuisines = cuisines;
	}
	
	@DynamoDBRangeKey(attributeName = "openingHours")
	public Set<RestaurantTimeRange> getRestaurantTimeRange() {
		return openingHours;
	}

	public void setRestaurantTimeRange(Set<RestaurantTimeRange> openingHours) {
		this.openingHours = openingHours;
	}	
	
	@DynamoDBAttribute(attributeName = "hasReservations")
	public Boolean getRestaurantHasReservations() {
		return hasReservations;
	}

	public void setRestaurantHasReservation(Boolean hasReservations) {
		this.hasReservations = hasReservations;
	}	
	
	
	@DynamoDBTypeConvertedEnum
	@DynamoDBAttribute(attributeName = "tables")
	public List<RestaurantTables> getRestaurantTables() {
		return tables;
	}

	public void setRestaurantTables(List<RestaurantTables> tables) {
		this.tables = tables;
	}	
	
	@DynamoDBAttribute(attributeName = "occupancy")
	public String getRestaurantOccupancy() {
		return occupancy;
	}

	public void setRestaurantOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}	
	
	@DynamoDBRangeKey(attributeName = "createdTime")
	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	@DynamoDBRangeKey(attributeName = "modifiedTime")
	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
