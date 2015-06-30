package test;

import java.sql.Connection;
import jdbc.JDBC;

public class JdbcTest {
	
	private static Connection conn;

	private static void testConnection(){
		conn = JDBC.getConnection();
	}
	
	public static void main(String[] argv) {
		System.out.println("JDBC Test...");
		testConnection();
	}
}
