package com.Alvaro.ws.rest.Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Alvaro.ws.rest.Dao.AutomovilDao;
import com.Alvaro.ws.rest.Model.Automovil;





@Path("/AlvaroPrueba")
public class Servicio {
	
	
	@GET
	@Path("/listaAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Automovil> listadoLibros() {
		
		AutomovilDao misAutos= new AutomovilDao();
		return misAutos.ObtenerAutomoviles();
	}
	
	
	@POST
	@Path("/RegistrarAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String RegistrarAuto(Automovil miAuto) {
		AutomovilDao misAutos= new  AutomovilDao();
	 	misAutos.GuardarAuto(miAuto);
	 	return miAuto.getMensaje();
	}
	
	
	
	@PUT
	@Path("/EditarAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String EditarAuto(Automovil miAuto) {
		AutomovilDao misAutos= new AutomovilDao();
		misAutos.EditarAuto(miAuto);
		return miAuto.getMensaje();
	}
	
	

	@DELETE
	@Path("/ElimiarAuto/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String EliminarAuto(@PathParam("id") int id) {
		Automovil miAuto=new Automovil();	
		AutomovilDao misAutos= new AutomovilDao();
		misAutos.Eliminar(id);
		return miAuto.getMensaje();
	}
	
	@GET
	@Path("/BuscarAuto/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Automovil BuscarAuto(@PathParam("id") int id) {
		
		AutomovilDao misAutos= new AutomovilDao();
		return misAutos.buscar(id);
	}
	

	
	
}
