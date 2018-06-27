package com.tiac.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.tiac.test.entities.RESTStations;

import com.tiac.test.entities.StationEntity;

import com.tiac.test.entities.dto.StationDTO;
import com.tiac.test.entities.dto.StationboardDTO;
import com.tiac.test.entities.dto.StationsDTO;
import com.tiac.test.fromDTOtoEntity.FromDTOtoRESTStation;
import com.tiac.test.fromDTOtoEntity.FromStationboardDTOtoRESTStation;

import com.tiac.test.services.StationDaoImpl;

@RestController
@RequestMapping(path = "/test/v1/")
public class StationController {

	@Autowired
	private StationDaoImpl stationService;
	@Autowired
	private FromDTOtoRESTStation dtoToStation;
	@Autowired
	private FromStationboardDTOtoRESTStation dtoBoardToStation;
	// repository for station data
	private static List<StationDTO> listStations = new ArrayList<StationDTO>();

	//Zadatak 1
	@RequestMapping(method = RequestMethod.GET, value = "/stations")
	public ResponseEntity<?> getStationsFromAPI() {

		RESTStations stations = new RESTStations();
		try {
			stations.setError_message("ok");
			getDataFromApi();
			List<StationEntity> listEntity = getDataEntity();
			stations.setStations(listEntity);

			if (stations.getStations() == null || stations.getStations().size() < 1) {
				return new ResponseEntity<RESTStations>(stations, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<RESTStations>(stations, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "Exception occurred: " + e.getMessage();
			stations.setError_message(msg);
			stations.setStations(new ArrayList<StationEntity>());
			return new ResponseEntity<RESTStations>(stations, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//Zadatak 2
	@RequestMapping(method = RequestMethod.GET, value = "/stationsWithConnections")
	public ResponseEntity<?> getConnectionsForStation() {

		RESTStations stations = new RESTStations();
		try {
			stations.setError_message("ok");
			getDataFromApi();
			List<StationEntity> listEntity = getDataEntity();
			stations.setStations(listEntity);
			StationboardDTO stDTO;
			List<StationEntity> connStations;
			List<StationEntity> addStations = new ArrayList<StationEntity>();
			if (stations.getStations() != null || stations.getStations().size() < 1) {
				for (StationEntity station : stations.getStations()) {
					Integer id = station.getId();
					if (id != null) {
						stDTO = stationService.getConnectionsFromApi(id);
						connStations = dtoBoardToStation.convert(stDTO);
						for (StationEntity s : connStations) {

							Integer idconn = s.getId();
							boolean exists = false;
							for (StationEntity st : stations.getStations()) {
								if (st.getId() == idconn) {
									exists = true;
									break;
								}

							}
							// make list with new stations
							if (!exists) {
								addStations.add(s);
							}
							station.addConnection(idconn);

						}

					}
				}
				// add new stations which not exist in list of stations
				if (addStations != null) {
					for (StationEntity st : addStations) {
						stations.addStation(st);
					}
				}
			} else {
				stations.setStations(new ArrayList<StationEntity>());
				return new ResponseEntity<RESTStations>(stations, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<RESTStations>(stations, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "Exception occurred: " + e.getMessage();
			stations.setError_message(msg);
			stations.setStations(new ArrayList<StationEntity>());
			return new ResponseEntity<RESTStations>(stations, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//set static object-list of stations from external api
	private void getDataFromApi() throws Exception {

		if (listStations == null || listStations.isEmpty()) {

			StationsDTO first = stationService.getDataFromApi("Be");
			listStations = first.getStations();

			StationsDTO second = stationService.getDataFromApi("La");
			listStations.addAll(second.getStations());

			StationsDTO third = stationService.getDataFromApi("Ge");
			listStations.addAll(third.getStations());
		}
	}

	//converts static object-list of stations to listEntity
	private List<StationEntity> getDataEntity() throws Exception {
		List<StationEntity> listEntity = dtoToStation.convert(listStations);
		return listEntity;
	}

}
