package com.capgemini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.business.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();

		System.out.println("Connected successfully");

		String sql = "insert into Customer values(?,?,?,?)"; // Parameterized
																// query

		int inp_id = 0;
		String inp_name = "";
		String inp_city = "";
		double inp_amt = 0.0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Id:");
		inp_id = scanner.nextInt();
		System.out.print("Enter Name:");
		inp_name = scanner.next();
		System.out.println("Enter City");
		inp_city = scanner.next();
		System.out.println("Enter Salary");
		inp_amt = scanner.nextDouble();

		PreparedStatement statement =  connection
				.prepareStatement(sql);
		
		statement.setInt(1,inp_id);
		statement.setString(2,inp_name);
		statement.setString(3,inp_city);
		statement.setDouble(4,inp_amt);
		
		int r = statement.executeUpdate(); // it returns the number of
												// rows(here 1) effected on
												// successful operation
		System.out.println(r + "rows inserted");
		statement.close();
		connection.close();
		if(r>0)
		{
			return true;
		}
		else{
			return false;
			
		}
		
		
	}

	@Override
	public boolean removeCustomer(int customerId)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();
		String sql = "delete from Customer where c_id=customerId";
		PreparedStatement statement = (PreparedStatement) connection
				.prepareStatement(sql);
		statement.setInt(1, customerId);
		int r = statement.executeUpdate();
		if (r == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();

		System.out.println("Connected successfully");
		int inp_id = 0;
		double inp_amt = 0.0;
		Scanner scanner = new Scanner(System.in);
		
		String sql = "update  Customer set c_amt=c_amt+? where c_id=?";
		
		System.out.println("Enter Salary");
		inp_amt = scanner.nextDouble();
		System.out.print("Enter Id:");
		inp_id = scanner.nextInt();

		PreparedStatement statement = connection.prepareStatement(sql);
	
		
		statement.setDouble(1,inp_amt);
		statement.setInt(2,inp_id);
	
		
		
		int r = statement.executeUpdate(); // it returns the number of
												// rows(here 1) effected on
												// successful operation
		System.out.println(r + "rows updated");
		statement.close();
		connection.close(); // // releasing resources statement

		return false;
	}

	@Override
	public Customer findCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() throws ClassNotFoundException,
			SQLException {
		Connection connection = ConnectionManager.createConnection();
		String sql = "select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Customer> customerList = new ArrayList<>();

		while (rs.next()) {

			int id = rs.getInt(1);
			String name = rs.getString(2);
			String city = rs.getString(3);
			double amt = rs.getDouble(4);
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setCity(city);
			customer.setOutStandingAmount(amt);
			customerList.add(customer);
		}

		rs.close();
		statement.close();
		connection.close();
		return customerList;

	}

}
