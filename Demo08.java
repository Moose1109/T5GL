package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI
public class Demo08 {
	
	//listado de todos los Usuario existente
	//Mostrando el tipo de usuario
	public static void main(String[] args) {
		
		//1. obtener coxion > llamar al persistence-unit		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_Sesion01");
		
		//2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//3. proceso
		
		//select * from tb_usuarios where idtipo = ?-- List					
		String jpql = "select u from Usuario u where u.idtipo= :xtipo";
		List<Usuario> listUsuarios = em.createQuery(jpql,Usuario.class).setParameter("xtipo" ,1) .getResultList();
		
		//4.Imprimir listado
		for (Usuario u: listUsuarios) {
			System.out.println("Codigo...:" + u.getCod_usua());
			System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo...:" +  u.getIdtipo()+ " " + u.getObjTipo().getDescripcion());
			System.out.println("-----------------------------");
			
		}
		em.close();
		
		
		
	}
}
