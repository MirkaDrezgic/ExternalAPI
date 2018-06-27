package com.tiac.test.fromDTOtoEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tiac.test.entities.CoordinateEntity;
import com.tiac.test.entities.StationEntity;
import com.tiac.test.entities.dto.StationDTO;

@Component
public class FromDTOtoRESTStation implements Converter<StationDTO, StationEntity> {
	@Autowired
	FromDTOtoCoordinate fromDtoCoordinate;
	
//	/** convert list of stationDTO object in stationEntity object  **/
	@Override
	public StationEntity convert(StationDTO dto) {
		
		StationEntity station = new StationEntity();
		if (dto != null) {
			station.setId(dto.getId());
			station.setName(dto.getName());
			station.setCountryCode("DE");
			station.setType("train_station");
			CoordinateEntity coordinates = new CoordinateEntity();
			if (dto.getCoordinate() != null) {
				coordinates = fromDtoCoordinate.convert(dto.getCoordinate());
			}
			station.setCoordinates(coordinates);
		}

		return station;
	}



	public List<StationEntity> convert(List<StationDTO> dtoList) {
		
		ArrayList<StationEntity> entityList=new ArrayList<StationEntity>();
		
		for (StationDTO dto : dtoList) {
			StationEntity station=new StationEntity();
			station=convert(dto);
			entityList.add(station);
		}
		return entityList;
	}

}
