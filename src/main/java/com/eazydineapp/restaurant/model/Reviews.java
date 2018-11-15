package com.eazydineapp.restaurant.model;


/**
 * Restaurant Reviews
 * @author Harini Balakrishnan
 *
 */

public class Reviews {

	private String id; 
	private String restaurantId;
	private String reviewerName;
	private String reviewContent;
	private Number reviewRate;
	private String createdTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Number getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(Number reviewRate) {
		this.reviewRate = reviewRate;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
}
