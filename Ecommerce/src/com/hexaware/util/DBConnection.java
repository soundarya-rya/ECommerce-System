package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection;
	static DBPropertyUtil db= new DBPropertyUtil();
	
	public static Connection getMyDbConnection() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

	public static Connection createConnection() {
		String connectionString = DBPropertyUtil.getConnectionString();
		Connection connection = null;
		try {		
			connection=DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return connection;
	}
	
	public static void main(String[] args) {
		System.out.println(getMyDbConnection());

	}

}
