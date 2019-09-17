package com.Alvaro.ws.rest.service;

import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Alvaro.ws.rest.Vo.AutoVo;

@Path("/RestAlvaro")
public class CreadoAutomovil {

	
	@POST
	@Path("/colorAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public AutoVo colorAuto(AutoVo miAuto) {
		
		miAuto.setColor(miAuto.getColor());
		
		JOptionPane.showMessageDialog(null, "el color del auto es : " + miAuto.getColor());
		System.out.println("el color final del Auto es " + miAuto.getColor());
		
		
		return miAuto;
		
	}
	
	@POST
	@Path("/precioAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public AutoVo precioAuto(AutoVo miAuto) {
		
		miAuto.setPrecio(miAuto.getPrecio());
		
		JOptionPane.showMessageDialog(null, "El precio del AutoMovil Es  : " + miAuto.getPrecio());
		System.out.println("el Precio final es  " + miAuto.getPrecio());
		
		
		return miAuto;
		
	}
	
	
	@POST
	@Path("/llantasAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public AutoVo llantasAuto(AutoVo miAuto) {
		
		miAuto.setLlantas(miAuto.getLlantas());
		
		JOptionPane.showMessageDialog(null, "las llantas del AutoMovil Son :  " + miAuto.getLlantas());
		System.out.println("las llantas del automovil son :  " + miAuto.getLlantas());
		
		
		return miAuto;
		
	}
	
	@POST
	@Path("/marcaAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public AutoVo marcaAuto(AutoVo miAuto) {
		
		miAuto.setMarca(miAuto.getMarca());
		
		JOptionPane.showMessageDialog(null, "la Marca del Automovil Es   " + miAuto.getMarca());
		System.out.println("la marca del Automovil es   " + miAuto.getMarca());
		
		
		return miAuto;
		
	}
	
	
	
	
	
	
}
