package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		Address address =em.find(Address.class,1);
		System.out.println(address.getCity()+address.getZipCode()+address.getStudent().getName());
		Student student=em.find(Student.class,1);
		System.out.println(student.getName()+student.getAddress().getCity()+student.getAddress().getState()+student.getAddress().getZipCode());
		
				
	
	
	}
}
