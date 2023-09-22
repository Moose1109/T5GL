package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

//GUI
public class Demo09 {
	
	//listado de todos los Usuario existente
	//Mostrando el tipo de usuario
	public static void main(String[] args) {
		
		String usuario = JOptionPane.showInputDialog("Ingrese usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");
		
		//1. obtener coxion > llamar al persistence-unit		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_Sesion01");
		
		//2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//3. proceso
		
		//select * from tb_usuarios where idtipo = ?-- List					
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla ";
		
		try {
			Usuario u = 
					
					em.createQuery(jpql,Usuario.class).
						setParameter("xusr",usuario).
						setParameter("xcla", clave).
						getSingleResult();
			
			//Abrir la ventana
			
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			//dispose();
			
			
//				System.out.println("Codigo...:" + u.getCod_usua());
//				System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
//				System.out.println("Tipo...:" +  u.getIdtipo()+ " " + u.getObjTipo().getDescripcion());
//				System.out.println("-----------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block

			
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}
			
		
		em.close();
		
		
		
	}
}


