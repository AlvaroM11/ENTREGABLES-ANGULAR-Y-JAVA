package com.Alvaro.ws.rest.Cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class CreacionMovil {
	
	public  void ObtenerAutomovil(String funciones, CreacionMovil miMovil){
		String urlServicio="http://localhost:8080/Api-Rest/service/RestAlvaro/"+funciones;
		System.out.println("service:" + urlServicio);
		
		ClientConfig clienteConfig=new DefaultClientConfig();
		clienteConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client cliente=Client.create(clienteConfig);
		
		WebResource webResource=cliente.resource(urlServicio);
		
		ClientResponse respuesta=webResource.type("application/json").post(ClientResponse.class,miMovil);
		miMovil=respuesta.getEntity(CreacionMovil.class);
		
	}

}
