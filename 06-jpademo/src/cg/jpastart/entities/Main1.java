package cg.jpastart.entities;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = factory.createEntityManager();
        System.out.println("Enter id to fetch details:");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        Student student = null;
        student=em.find(Student.class,id);
        System.out.println(student);
        em.close();
        factory.close();
        scanner.close();
}
}
