package com.tiac.test.entities.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ArrivalDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ssZ", timezone = "UTC")
	private Date arrival;

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

}
