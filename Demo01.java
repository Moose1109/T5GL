package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI
public class Demo01 {
	
	//registro de un Usuario
	public static void main(String[] args) {
		
		//1. obtener coxion > llamar al persistence-unit		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_Sesion01");
		
		//2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//3. proceso
		Usuario u = new Usuario(321, "Clara", "Valac", "farfal", "familia", "2000/05/10", 1, 1, null);
	
		//Ojo !! si el proceso es registrar/actualizar/eliminar -->Transaccion
		try {
			em.getTransaction().begin();
			em.persist(u); //--> inser into 
			em.getTransaction().commit();
			System.out.println("Registro OK!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:" + e.getCause().getMessage());
		}
		
		
		em.close();
		
		
		
	}
}
