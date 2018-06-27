package com.tiac.test.entities.dto;

public class ConnectionDTO {
	
	private DepartureDTO from;
	private ArrivalDTO to;

	public DepartureDTO getFrom() {
		return from;
	}

	public void setFrom(DepartureDTO from) {
		this.from = from;
	}

	public ArrivalDTO getTo() {
		return to;
	}

	public void setTo(ArrivalDTO to) {
		this.to = to;
	}
}
