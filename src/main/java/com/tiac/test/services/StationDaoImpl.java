package com.tiac.test.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.tiac.test.entities.dto.StationboardDTO;
import com.tiac.test.entities.dto.StationsDTO;

@Service
public class StationDaoImpl implements StationDao {

	public StationsDTO getDataFromApi(String searchCity) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		String url = String.format("http://transport.opendata.ch/v1/locations?query=%s&type=stations",searchCity);
		HttpGet request = new HttpGet(url);
		ObjectMapper mapper = new ObjectMapper();

		HttpResponse response = client.execute(request);
		String userDataJSON = EntityUtils.toString(response.getEntity());
		StationsDTO dtoArray = mapper.readValue(userDataJSON, StationsDTO.class);

		return dtoArray;
	}

	public StationboardDTO getConnectionsFromApi(Integer id) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		String url = String.format("http://transport.opendata.ch/v1/stationboard?station=%s&fields[]=stationboard/passList/station&limit=3",id);
		HttpGet request = new HttpGet(url);
		ObjectMapper mapper = new ObjectMapper();

		HttpResponse response = client.execute(request);
		String userDataJSON = EntityUtils.toString(response.getEntity());
		StationboardDTO  board= mapper.readValue(userDataJSON, StationboardDTO.class);
		return board;
	}


	

}
