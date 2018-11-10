package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.capgemini.business.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");//instializing the factory  by taking parameter from META-INF( i.e"JPU_PU")
		EntityManager em=emf.createEntityManager();
		
		Employee employee=new Employee();
		employee.setEmp_Id(100);
		employee.setEmp_Name("prasanna");
		employee.setBasic_salary(10000);
		employee.setEmp_Grade('a');
		employee.setEmp_Gender('f');

		
		EntityTransaction t= em.getTransaction();
		t.begin();
		em.persist(employee); // to insert the values or inserting  a new create
		t.commit();
		em.close();
		emf.close();
		System.out.println("Object stored in databse");

}

}