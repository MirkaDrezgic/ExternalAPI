package com.tiac.test.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class StationsDTO {
	private List<StationDTO> stations = new ArrayList<StationDTO>();

	public List<StationDTO> getStations() {
		return stations;
	}

	public void setStations(List<StationDTO> stations) {
		this.stations = stations;
	}

}
