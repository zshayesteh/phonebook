package HW4_phonebook;

import java.sql.*;

public class JDBC {
	Statement stmt;

	public void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://127.0.0.1/phonebook?user=root&password=";
			Connection conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("exception " + e);
		}
	}

}
