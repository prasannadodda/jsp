package com.capgemini.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.business.Customer;
import com.capgemini.db.ConnectionManager;
import com.capgemini.db.CustomerDAO;
import com.capgemini.db.CustomerDAOImpl;

public class Main {
	public static void add() throws ClassNotFoundException, SQLException {
		int id = 0;
		String name = "null", city = "null";
		double amt = 0.0;
		Customer customer = new Customer();
		customer.setOutStandingAmount(amt);
		CustomerDAO dao = new CustomerDAOImpl();
		boolean result = dao.addCustomer(customer);
		if (result == true) {
			System.out.println("Added successfully");
		}

		else {
			System.out.println("Add function failed");
		}
	}

	public static void update() throws ClassNotFoundException, SQLException {

		int id = 0;
		Customer customer = new Customer();
		CustomerDAO dao = new CustomerDAOImpl();
		boolean result = dao.updateCustomer(customer);
		if (result == true) {
			System.out.println("Updated successfully");
		}
		else {
			System.out.println("Updatiion  failed");
		}

	}

	public static void display() throws ClassNotFoundException, SQLException {
		CustomerDAO dao = new CustomerDAOImpl();
		List<Customer> customerlist = dao.getAllCustomer();
		// System.out.println(customerlist);
		for (Customer customer : customerlist) {

			System.out.print(customer.getId() + "\t");
			System.out.print(customer.getName() + "\t");
			System.out.print(customer.getCity() + "\t");
			System.out.println(customer.getOutStandingAmount());
		}

	}

	public static void remove() throws ClassNotFoundException, SQLException {
		int inp_id = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id  to remove");
		inp_id = scanner.nextInt();

		CustomerDAO dao = new CustomerDAOImpl();
		boolean result = dao.removeCustomer(inp_id);
		if (result == true) {
			System.out.println("Record deleted successfuly");
		} else {
			System.out.println("Record not deleted");
		}

	}

	public static void main(String... args) throws ClassNotFoundException,
			SQLException {
		System.out.println("Customer Application");

		System.out.println("..........................................");
		System.out.println("1.Add New Customer");
		System.out.println("2.Update Customer");
		System.out.println("3.Display All Customer");
		System.out.println("4.Delete");
		System.out.println("5.Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter choice");
		int choice = scanner.nextInt();
		switch (choice) {

		case 1:
			add();

			break;
		case 2:
			update();

			break;

		case 3:
			display();

			break;
		case 4:
			remove();

			break;
		case 5:
			System.out.println("Thank you");
			break;
		default:
			break;
		}
	}

}
