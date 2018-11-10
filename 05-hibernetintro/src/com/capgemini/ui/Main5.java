package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Contact;

public class Main5 {
public static void main(String[] args) {
	Contact contact1 =new Contact(591,"prasanna","9441175582");
	Contact contact2 =new Contact(592,"prasanna","9441175582");// these 3 object are called as transient objects after storing in database they will beceom attached objects.
	Contact contact3 =new Contact(593,"prasanna","9441175582");
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");//instializing the factory  by taking parameter from META-INF( i.e"JPU_PU")
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	/*em.persist(contact1);
	em.persist(contact2);
	em.persist(contact3);*/
	contact3.setPhoneNumber("9948755582");
	em.merge(contact3);
	em.getTransaction().commit();
	em.close();
	emf.close();
	Contact contact4=null;
	emf=Persistence.createEntityManagerFactory("JPA-PU");
	em=emf.createEntityManager();
	contact4=em.find(Contact.class,591);
	contact4.setPhoneNumber("9441175582");
	em.merge(contact4);
	System.out.println(contact4.equals(contact1));
	em.close();
	emf.close();
}
	
	
}
