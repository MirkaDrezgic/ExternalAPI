package com.tiac.test.entities;

import java.util.ArrayList;
import java.util.List;

public class RESTConnection {
	
	private String error_message;
	private Integer totalResults;
	private List<TripEntity> trips=new ArrayList<TripEntity>();
	
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	public List<TripEntity> getTrips() {
		return trips;
	}
	public void setTrips(List<TripEntity> trips) {
		this.trips = trips;
	}
	public void addTrip(TripEntity trip){
		this.trips.add(trip);
	}
}
