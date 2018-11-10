package com.capgemini.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.business.Employee;

public class Main2 { //to print all the objects
public static void main(String arg[])
{
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em=emf.createEntityManager();
	String myQuery =" from  Employee"; // A java Persistence query language
	Query query =em.createQuery(myQuery);
	
	List<Employee> empList= query.getResultList();
	
	System.out.println(empList);
	
	em.close();
	emf.close();
}
}