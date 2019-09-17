package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.ecodeup.model.Producto;

public class MainApp {

	public static void main(String[] args) {
		int opcion =0;
		Scanner miScanner=new Scanner(System.in);
		Producto miAutomovil;
		String nombre;
		double precio;
		long id;
		
		EntityManager miEntity=JPAUtil.getEntityManagerFactory().createEntityManager();
		
		while (opcion!=5) {
			String menu="";
			
			menu+="CREA TU PROPIO AUTOMOVIL SIEMPRE COMO TU QUIERAS \n ";
			
			menu+="1. crear marca Automovil \n";
			menu+="2. buscar Automovil \n";
			menu+="3. Actualizar Automovil \n";
			menu+="4. eliminar Automovil \n";
			menu+="5.salir \n";
			
			menu+="DIJITE UNA OPCION  \n ";
			
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch(opcion) {
			
			case 1:
				
				miAutomovil =new Producto();
				miAutomovil.setId(null);
				nombre=JOptionPane.showInputDialog("ingrese el marca del automovil");
				miAutomovil.setNombre(nombre);
				
				precio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Precio del automovil "));
				
				miAutomovil.setPrecio(precio);
				
				miEntity.getTransaction().begin();
				miEntity.persist(miAutomovil);
				miEntity.getTransaction().commit();
				
			JOptionPane.showMessageDialog(null, "Producto creado con exito ");
				
				break;
				
			case 2:
				
				id=Long.parseLong(JOptionPane.showInputDialog("ingrese el id de el automovil "));
				
				miAutomovil = new Producto();
				miAutomovil=miEntity.find(Producto.class , id );
					if (miAutomovil!=null) {
					JOptionPane.showMessageDialog(null, miAutomovil);
						
					}else {
						
						JOptionPane.showMessageDialog(null, "no se econtro el automovil ");
						List<Producto> listaProductos= new ArrayList<>();
						Query miQuery = miEntity.createQuery("SELECT p FROM Producto p");
						listaProductos=miQuery.getResultList();
						
						for (Producto p : listaProductos) {
							
							JOptionPane.showMessageDialog(null, p);
							
						}
						
					}
				
					break;
			
			case 3:
				miAutomovil = new Producto();
				id = Long.parseLong(JOptionPane.showInputDialog("ingrese el id de el automovil que desea actualizar"));
				miAutomovil = miEntity.find(Producto.class, id);
				
			if (miAutomovil != null) {
				JOptionPane.showConfirmDialog(null, miAutomovil);
				
				nombre = JOptionPane.showInputDialog("ingrese el nombre del automovil");
				miAutomovil.setNombre(nombre);
				
				precio = Double.parseDouble(JOptionPane.showInputDialog("ingrese el precio del automovil"));
				miAutomovil.setPrecio(precio);
				
				miEntity.getTransaction().begin();
				miEntity.merge(miAutomovil);
				miEntity.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null, "automovil actualizado");

			} else {
					
				JOptionPane.showMessageDialog(null, "automovil no encontrado...");

			}				
			
			break;
				
			case 4:
				
				id=Long.parseLong(JOptionPane.showInputDialog("dijite el id del automovil a eliminar : "));
				miAutomovil = new Producto();
				
				miAutomovil = miEntity.find(Producto.class, id);
				if (miAutomovil !=null) {
					
					JOptionPane.showConfirmDialog(null, miAutomovil);
					miEntity.getTransaction().begin();
					miEntity.remove(miAutomovil);
					miEntity.getTransaction().commit();
					
					JOptionPane.showMessageDialog(null, " Pedido del Automovil Eliminado ");
					
					
				}else {
					JOptionPane.showMessageDialog(null, "no se puedo Actualizar el Automovil  ");
					
				}
				break;
				
			case 5: 
				
				JOptionPane.showConfirmDialog(null, "seguro que desa salir ");
				
				miEntity.close();
				JPAUtil.shutdown();
				break;
				
				default:
					
					JOptionPane.showMessageDialog(null, " hasta luego  ");

					break;
				 
			}
		}
	}

}
