package com.tiac.test.entities.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DepartureDTO {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ssZ", timezone = "UTC")
	private Date departure;

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

}
