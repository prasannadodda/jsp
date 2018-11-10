package cg.jpastart.entities;

import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	public static void main(String[] args) {
	
	
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
					EntityManager em = emf.createEntityManager();
					String myQuery = " from Student";
					Query query = (Query) em.createQuery(myQuery);
					List<Student> stuList = null;
					stuList = ((javax.persistence.Query) query).getResultList();
					for(Student student:stuList){
						student.setName(student.getName().toUpperCase());
						em.getTransaction().begin();
						em.merge(student);
						em.getTransaction().commit();
					}
					em.close();
					emf.close(); 
			 



	}

}
