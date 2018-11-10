package cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main4 {

	public static void main(String[] args) {
	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
	
		 em.getTransaction().begin();
		    
		 Trip trip=em.find(Trip.class,1);
		 System.out.println(trip);
		 
		   em.getTransaction().commit();
		    em.close();
			emf.close(); 
		

	}

}
