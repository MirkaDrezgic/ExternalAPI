package com.tiac.test.services;


import com.tiac.test.entities.dto.ConnectionsDTO;

public interface ConnectionDao {
	
	public ConnectionsDTO getConnectionsForDepatureArrivalId(Integer departureStationId, 
			Integer arrivalStationId) throws Exception;
}
