package com.eazydineapp.restaurant.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;

/**
 * Restaurant Reservations
 * @author Harini Balakrishnan
 *
 */
@DynamoDBDocument
public class WaitingList {

	private String id; 
	private String restaurantId;
	private String customerName;
	private Number customerId;
    private RestaurantTables requestedTable ;
    private Number peopleCount;
    private String createdTime;
    private String modifiedTime;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Number getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Number customerId) {
		this.customerId = customerId;
	}
	
	@DynamoDBTypeConvertedEnum
	public RestaurantTables getRequestedTable() {
		return requestedTable;
	}
	public void setRequestedTable(RestaurantTables requestedTable) {
		this.requestedTable = requestedTable;
	}
	public Number getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(Number peopleCount) {
		this.peopleCount = peopleCount;
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
