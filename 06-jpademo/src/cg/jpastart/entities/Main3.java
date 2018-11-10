package cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main3 {
public static void main(String[] args) {
	SeatInfo seatinfo=new SeatInfo(20,15,5);
	Trip trip=new Trip();
	trip.setFrom_city("chennai");
	trip.setTo_City("Hyderabad");
	trip.setInfo(seatinfo);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
    
    em.persist(trip);
    em.getTransaction().commit();
    em.close();
	factory.close(); 

    
}
}
