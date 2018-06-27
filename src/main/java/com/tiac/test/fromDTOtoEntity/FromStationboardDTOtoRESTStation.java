package com.tiac.test.fromDTOtoEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import com.tiac.test.entities.StationEntity;
import com.tiac.test.entities.dto.ConnectionStationDTO;
import com.tiac.test.entities.dto.PassListDTO;
import com.tiac.test.entities.dto.StationDTO;
import com.tiac.test.entities.dto.StationboardDTO;

@Component
public class FromStationboardDTOtoRESTStation implements Converter<StationboardDTO, List<StationEntity>> {
	@Autowired
	FromDTOtoRESTStation fromDtoStation;
	@Autowired
	FromDTOtoCoordinate fromDtoCoordinate;
	
	@Override
	public List<StationEntity> convert(StationboardDTO dtoBoard) {
		List<StationEntity> stationlist = new ArrayList<StationEntity>();
		if (dtoBoard != null) {
			ArrayList<PassListDTO> pass = dtoBoard.getStationboard();
			if (pass!=null) {
				for (PassListDTO st : pass) {
					List<ConnectionStationDTO> list = st.getPassList();
					if (list!=null) {
							StationDTO stationDTO = list.get(0).getStation();

							// stationboard-passList[0]-station
							
							StationEntity station=fromDtoStation.convert(stationDTO);
							stationlist.add(station);
					}
				}
			}
			
		}
		return stationlist;
	}

}
