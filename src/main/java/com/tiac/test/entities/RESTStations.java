package com.tiac.test.entities;

import java.util.ArrayList;
import java.util.List;

public class RESTStations {
	
	private String error_message;
	private List<StationEntity> stations=new ArrayList<StationEntity>();
	
	public RESTStations() {
		super();
	}
	
	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public List<StationEntity> getStations() {
		return stations;
	}

	public void setStations(List<StationEntity> stations) {
		this.stations = stations;
	}
	
	public void addStation(StationEntity station){
		if (this.stations!=null) {
			if (!this.stations.contains(station)) {
				this.stations.add(station);
			}
			
			
		}
	}
	



	
}
