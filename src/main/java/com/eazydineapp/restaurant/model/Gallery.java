package com.eazydineapp.restaurant.model;


/**
 * Restaurant Gallery
 * @author Harini Balakrishnan
 *
 */
public class Gallery {

	private String id; 
	private String restaurantId;
	private String name;
	private String imageURL;
	private ImageCategory category; 
	private String createdTime;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public ImageCategory getCategory() {
		return category;
	}
	public void setCategory(ImageCategory category) {
		this.category = category;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
}
