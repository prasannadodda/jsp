package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Employee;

public class Main4 {

	public static void main(String[] args) {
		// deleting a record

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Employee e = null;
		e = em.find(Employee.class, 100); // loding or finding the id
		e.setBasic_salary(50000.00);
		em.getTransaction().begin(); // opning of transcation
		em.remove(e); // remove is used for removing of the data
		em.getTransaction().commit(); // closing of the transcation
		em.close();
		emf.close();
	}
}
