package com.Alvaro.ws.rest.Cliente;

import javax.swing.JOptionPane;

import com.Alvaro.ws.rest.Vo.AutoVo;

public class Rest_App {

	public static void main(String[] args) {
	
	int opcion=0;
	
	CreacionMovil miMovil;
	AutoVo miAuto;
	
	
	
	
	while (opcion!=5) {
		String menu="";

		menu+="BIENVENIDO A NUNTRO CENTRO DE AUTOMOVIL \n ";
		
		menu+=" 1. Color Automovil \n";
		menu+=" 2. Precio Automovil  \n";	
		menu+=" 3. Llantas Automovil \n";	
		menu+=" 4. Marca Automovil \n";	
		menu+="5. Salir \n";
		menu+="ELIJA UNA OPCION \n";
		
		opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (opcion) {
		case 1:
			miMovil= new CreacionMovil();
			miAuto= new AutoVo();
			
			miAuto.setColor(JOptionPane.showInputDialog("Ingrese el Color Del Automovil : "));
			miMovil.ObtenerAutomovil("colorAuto", miAuto);
			System.out.println();
			break;
			
		case 2:
			miMovil= new CreacionMovil();
			miAuto= new AutoVo();
			
			miAuto.setPrecio(Integer.parseInt(JOptionPane.showInputDialog(" Dijite El Precio  pagar ")));
			miMovil.ObtenerAutomovil("precioAuto", miAuto);
			System.out.println();
			break;
			
		case 3:
			
			miMovil= new CreacionMovil();
			miAuto= new AutoVo();
			
			miAuto.setLlantas(Integer.parseInt(JOptionPane.showInputDialog("ingrese cuantas llantas va a llevar su Automovil ")));
			miMovil.ObtenerAutomovil("llantasAuto", miAuto);
			System.out.println();
			break;
			
		 case 4:
			
			miMovil= new CreacionMovil();
			miAuto= new AutoVo();
			
			miAuto.setMarca(JOptionPane.showInputDialog("Dijite la Marca que Desea En su Automovil "));
			miMovil.ObtenerAutomovil("marcaAuto", miAuto);
			System.out.println();
			break;
			
		 case 5:
			 JOptionPane.showInternalMessageDialog(null, "que tengas una linda tarde ");
			 System.out.println();
			 break;
			 
			

		default:
			System.out.println("Opcion no Valida");
			break;
		}
	}
	
	
		
		
	}
	
}
