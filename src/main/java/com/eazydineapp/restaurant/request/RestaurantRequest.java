package com.eazydineapp.restaurant.request;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


import com.eazydineapp.restaurant.model.RestaurantCuisines;
import com.eazydineapp.restaurant.model.RestaurantTables;
import com.eazydineapp.restaurant.model.RestaurantTimeRange;


public class RestaurantRequest implements Serializable {

	/**
	 * Restaurant Request 
	 * @author Harini Balakrishnan
	 *
	 */
	private static final long serialVersionUID = 1L;
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
	

	public String getRestaurantId() {
		return id;
	}

	public void setRestaurantId(String id) {
		this.id = id;
	}


	public String getRestaurantName() {
		return name;
	}

	public void setRestaurantName(String name) {
		this.name = name;
	}
	
	public String getRestaurantAddress() {
		return  address;
	}

	public void setRestaurantAddress(String address) {
		this.address = address;
	}

	public String getRestaurantEmailAddress() {
		return emailAddress;
	}

	public void setRestaurantEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRestaurantExpenseRate() {
		return expenseRate;
	}

	public void setRestaurantExpenseRate(String expenseRate) {
		this.expenseRate = expenseRate;
	}
	

	public String getRestaurantStarRate() {
		return starRate;
	}

	public void setRestaurantStarRate(String starRate) {
		this.starRate = starRate;
	}
	
	public Set<String> getRestaurantServiceArea() {
		return serviceArea;
	}

	public void setRestaurantServiceArea(Set<String> serviceArea) {
		this.serviceArea = serviceArea;
	}
	
	public List<RestaurantCuisines> getRestaurantCuisines() {
		return cuisines;
	}

	public void setRestaurantCusines(List<RestaurantCuisines> cuisines) {
		this.cuisines = cuisines;
	}
	
	public Set<RestaurantTimeRange> getRestaurantTimeRange() {
		return openingHours;
	}

	public void setRestaurantTimeRange(Set<RestaurantTimeRange> openingHours) {
		this.openingHours = openingHours;
	}	
	
	public Boolean getRestaurantHasReservations() {
		return hasReservations;
	}

	public void setRestaurantHasReservation(Boolean hasReservations) {
		this.hasReservations = hasReservations;
	}	
	
	public List<RestaurantTables> getRestaurantTables() {
		return tables;
	}

	public void setRestaurantTables(List<RestaurantTables> tables) {
		this.tables = tables;
	}	
	
	public String getRestaurantOccupancy() {
		return occupancy;
	}

	public void setRestaurantOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}	

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
