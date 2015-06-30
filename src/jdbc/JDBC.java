package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {

	private static String user = "postgres";
	private static String pw = "postgres";
	private static String dbName = "postgres";
	
	
	private static Connection Connection() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		
		return conn;
	}
	
	public static Connection getConnection(){
		Connection conn = JDBC.Connection();
		return conn;
	}
	   
}
