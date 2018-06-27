package com.tiac.test.entities;

import java.util.ArrayList;
import java.util.List;

public class StationEntity {
	
	
	private Integer id;
	private String name;
	private String type;
	private String countryCode;
	private CoordinateEntity coordinates;
	
	private List<Integer> connections=new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CoordinateEntity getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(CoordinateEntity coordinates) {
		this.coordinates = coordinates;
	}
	
	public List<Integer> getConnections() {
		return connections;
	}

	public void setConnections(List<Integer> connections) {
		this.connections = connections;
	}
	
	
	public void addConnection(Integer id){
		if (!this.connections.contains(id)) {
			this.connections.add(id);
		}
		
	}


	



	
}
