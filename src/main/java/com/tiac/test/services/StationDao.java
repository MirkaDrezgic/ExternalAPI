package com.tiac.test.services;





import com.tiac.test.entities.dto.StationboardDTO;
import com.tiac.test.entities.dto.StationsDTO;


public interface StationDao {
	
	public StationsDTO getDataFromApi(String searchCity) throws Exception;
	public StationboardDTO getConnectionsFromApi(Integer id) throws Exception;
}
