import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



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
		connection.close(); // releasing resources statement

	}

	public static void updateRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();

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
		connection.close(); // releasing resources statement

	}

	public static void deleteRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();

		System.out.println("Connected successfully");
		int inp_id = 0;
		Scanner scanner = new Scanner(System.in);
		String sql = "delete from  Customer where c_id=?";
		System.out.print("Enter Id:");
		inp_id = scanner.nextInt();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setInt(1,inp_id);
		int r = statement.executeUpdate(); // it returns the number of
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

	public static void diaplyOneRecords() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();
		Scanner scanner=new Scanner(System.in);
		int inp_id=scanner.nextInt();
		String sql = "select * from Customer where c_id=  + ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

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
		//insertRecord();
		 updateRecord();
		//deleteRecord();
		// diaplyAllRecords();
		// diaplyOneRecords(3);

	}
}
