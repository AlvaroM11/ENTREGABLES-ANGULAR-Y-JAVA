package com.Alvaro.ws.rest.Dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.Alvaro.ws.rest.Model.Automovil;
import com.Alvaro.ws.rest.Model.JPAUtil;


public class AutomovilDao {

	
	EntityManager miEntity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void GuardarAuto(Automovil miAuto) {
		
		miEntity.getTransaction().begin();
		miEntity.persist(miAuto);
		miEntity.getTransaction().commit();
		miAuto.setMensaje("Automovil Registrado Exitosamente...  ");
		
	}
	

	
	public Automovil buscar(int id) {
		Automovil misAutos = new Automovil();
		misAutos=miEntity.find(Automovil.class, misAutos);
		return misAutos;
	}
	
	
	public List<Automovil> ObtenerAutomoviles(){
		
		List<Automovil> listaAutos=new ArrayList<>();
		Query miQuery=miEntity.createQuery("SELECT misAutos FROM Autos misAutos ");
		listaAutos=miQuery.getResultList();
		return listaAutos;
	}
	
	public Automovil Eliminar (int id) {
		Automovil misAutos = new Automovil();
		misAutos=miEntity.find(Automovil.class, misAutos);
		miEntity.getTransaction().begin();
		miEntity.remove(misAutos);
		miEntity.getTransaction().commit();
		misAutos.setMensaje(" Se Elimino CorrectaMente ... ");
		return misAutos;
	}
	
	
	public void EditarAuto(Automovil miAuto) {
		
		miEntity.getTransaction().begin();
		miEntity.persist(miAuto);
		miEntity.getTransaction().commit();
		miAuto.setMensaje("Automovil Registrado Exitosamente...  ");
		
	}
	
	
	
	
	
	
	
	
	
	
}
