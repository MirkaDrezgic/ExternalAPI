package com.tiac.test.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiac.test.entities.RESTConnection;

import com.tiac.test.entities.SearchFromToEntity;

import com.tiac.test.entities.TripEntity;
import com.tiac.test.entities.dto.ConnectionDTO;
import com.tiac.test.entities.dto.ConnectionsDTO;

import com.tiac.test.services.ConnectionDaoImpl;

@RestController
@RequestMapping(path = "/test/connection/")
public class ConnectionController {
	@Autowired
	private ConnectionDaoImpl connService;

	
	//Zadatak br3
	@RequestMapping(method = RequestMethod.POST, value = "/search")
	public ResponseEntity<?> getConnectionsBetweenTwoCityes(@RequestBody SearchFromToEntity searchFromTo) {

		RESTConnection connection = new RESTConnection();
		try {
			connection.setError_message("ok");

			Integer idDeparture = searchFromTo.getDepartureStationId();
			Integer idArrival = searchFromTo.getArrivalStationId();
			ConnectionsDTO connsDTO = connService.getConnectionsForDepatureArrivalId(idDeparture, idArrival);

			if (connsDTO.getConnections() != null) {
				for (ConnectionDTO connDTO : connsDTO.getConnections()) {
					TripEntity trip = new TripEntity();
					trip.setDepartureStationId(idDeparture);
					trip.setArrivalStationId(idArrival);
					if (connDTO.getFrom() != null) {
						Date departure = connDTO.getFrom().getDeparture();
						trip.setDepartureTime(departure);
					}
					if (connDTO.getTo() != null) {
						Date arrival = connDTO.getTo().getArrival();
						trip.setArrivalTime(arrival);
					}
					connection.addTrip(trip);
				}
				connection.setTotalResults(connsDTO.getConnections().size());

			} else {
				return new ResponseEntity<RESTConnection>(connection, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<RESTConnection>(connection, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "Exception occurred: " + e.getMessage();
			connection.setError_message(msg);
			connection.setTotalResults(0);
			connection.setTrips(new ArrayList<TripEntity>());
			return new ResponseEntity<RESTConnection>(connection, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
