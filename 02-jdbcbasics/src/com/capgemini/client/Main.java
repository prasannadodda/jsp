package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static Connection createConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/demodb";
		String username = "root";
		String password = "pass";
		Connection connection = DriverManager.getConnection(dbURL, username,
				password);

		return connection;
	}

	public static void insertRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();

		System.out.println("Connected successfully");

		String sql = "insert into Customer values(5,'sindhu', 'kolkata', 7500.00)";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(sql); // it returns the number of
												// rows(here 1) effected on
												// successful operation
		System.out.println(r + "rows inserted");
		statement.close();
		connection.close(); // releasing resources statement

	}

	public static void updateRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();

		System.out.println("Connected successfully");

		String sql = "update  Customer set c_amt=c_amt+2000 where c_id=1";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(sql); // it returns the number of
												// rows(here 1) effected on
												// successful operation
		System.out.println(r + "rows updated");
		statement.close();
		connection.close(); // releasing resources statement

	}

	public static void deleteRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();

		System.out.println("Connected successfully");

		String sql = "delete from  Customer where c_id=5";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(sql); // it returns the number of
												// rows(here 1) effected on
												// successful operation
		System.out.println(r + "row deleted");
		statement.close();
		connection.close(); // releasing resources statement

	}

	public static void diaplyAllRecords() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();
		String sql = "select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.println(rs.getString(4) + "\t");
		}
		rs.close();
		statement.close();
		connection.close();

	}

	public static void diaplyOneRecords(int id) throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();
		String sql = "select * from Customer where c_id= " + id;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.println(rs.getString(4) + "\t");
		}
		rs.close();
		statement.close();
		connection.close();

	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// insertRecord();
		 updateRecord();
		// deleteRecord();
		// diaplyAllRecords();
		//diaplyOneRecords(3);

	}
}
