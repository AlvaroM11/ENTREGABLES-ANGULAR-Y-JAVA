package com.javarevolution.ws.rest.service;


import com.javarevolution.ws.rest.vo.VOUsuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClientJR {
	
	public static void main(String[] args) {
	
		String urlRestService = "http://localhost:8080/RESTSemana1/restJR/JavaRevolutions/validaUsuario";
		System.out.println("######## Invoke Rest Service: ["+urlRestService+"]");
		
		
		VOUsuario vo = new VOUsuario();
		
		vo.setUsuario("Java");
		vo.setPassword("111");
		vo.setUserValido(true);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        
        WebResource webResource = client.resource(urlRestService);
        
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, vo);
        
        
        vo = response.getEntity(VOUsuario.class);
        
        
        System.out.println("######## Response: [Usuario: "+vo.getUsuario()+"]");
        System.out.println("######## Response: [User is Valid: "+vo.isUserValido()+"]");
	}

}
