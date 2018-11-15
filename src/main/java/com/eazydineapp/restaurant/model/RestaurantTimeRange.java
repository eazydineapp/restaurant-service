package com.eazydineapp.restaurant.model;


/**
 * Restaurant TimeRange
 * @author Harini Balakrishnan
 *
 */
public class RestaurantTimeRange {

	private String id; 
	private String fromDay;
	private String toDay;
	private String fromTime;
	private String toTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromDay() {
		return fromDay;
	}
	public void setFromDay(String fromDay) {
		this.fromDay = fromDay;
	}
	public String getToDay() {
		return toDay;
	}
	public void setToDay(String toDay) {
		this.toDay = toDay;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	} 
	
}
