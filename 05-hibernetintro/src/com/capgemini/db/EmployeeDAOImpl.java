package com.capgemini.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.business.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean addEmployee(Employee employee) {

		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");// instializing the
															// factory by taking
															// parameter from
															// META-INF(
															// i.e"JPU_PU")
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean removeEmployee(Employee employee) {
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");// instializing the
															// factory by taking
															// parameter from
															// META-INF(
															// i.e"JPU_PU")
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee e = null;
			e = em.find(Employee.class, 102);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean employee(Employee employee) {
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();

			Employee e = null;

			e = em.find(Employee.class, 100); // loding or finding the id

			e.setBasic_salary(50000.00);

			em.getTransaction().begin(); // opning of transcation
			em.merge(e); // merge is used for updation of the data
			em.getTransaction().commit(); // closing of the transcation

			em.close();
			emf.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Employee findEmployee(int id) {
		Employee e = null;
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			e = em.find(Employee.class, 100);
			em.close();
			emf.close();
			return e;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emplist = null;

		try {
			Query q = ((EntityManager) emplist).createQuery("from Employee");
			emplist = q.getResultList();
		
	
			return emplist;

		} catch (Exception execption) {
			return null;
		}

	}

}
