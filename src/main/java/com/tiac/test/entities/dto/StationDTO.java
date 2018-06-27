package com.tiac.test.entities.dto;




public class StationDTO {
	
	private Integer id;
	private String name;
	private String score;
	private CoordinateDTO coordinate;
	private Integer distance;
	
	public StationDTO() {
		super();
	}
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public CoordinateDTO getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(CoordinateDTO coordinate) {
		this.coordinate = coordinate;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	
}
