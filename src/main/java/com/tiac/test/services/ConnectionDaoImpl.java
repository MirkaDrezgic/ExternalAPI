package com.tiac.test.services;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiac.test.entities.dto.ConnectionsDTO;

@Service
public class ConnectionDaoImpl implements ConnectionDao{
	
	public ConnectionsDTO getConnectionsForDepatureArrivalId(Integer departureStationId, 
															Integer arrivalStationId) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		String url = String.format("http://transport.opendata.ch/v1/connections?from=%s&to=%s&fields[]=connections/from/departure&fields[]=connections/to/arrival",departureStationId,arrivalStationId);
		HttpGet request = new HttpGet(url);
		ObjectMapper mapper = new ObjectMapper();

		HttpResponse response = client.execute(request);
		String userDataJSON = EntityUtils.toString(response.getEntity());
		ConnectionsDTO  connList= mapper.readValue(userDataJSON, ConnectionsDTO.class);
		return connList;
	}
}
