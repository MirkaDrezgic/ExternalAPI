package com.tiac.test.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class PassListDTO {
	
	private List<ConnectionStationDTO> passList=new ArrayList<ConnectionStationDTO>();

	public List<ConnectionStationDTO> getPassList() {
		return passList;
	}

	public void setPassList(List<ConnectionStationDTO> passList) {
		this.passList = passList;
	}


	



}
