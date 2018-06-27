package com.tiac.test.fromDTOtoEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tiac.test.entities.CoordinateEntity;
import com.tiac.test.entities.dto.CoordinateDTO;
@Component
public class FromDTOtoCoordinate implements Converter<CoordinateDTO, CoordinateEntity> {

	@Override
	public CoordinateEntity convert(CoordinateDTO dto) {
		CoordinateEntity coordinate=new CoordinateEntity();
		if (dto!=null) {
			coordinate.setLatitude(dto.getX());
			coordinate.setLongitude(dto.getY());
		}
		
		return coordinate;
	}

}
