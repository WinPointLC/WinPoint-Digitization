package com.winpoint.common.util.sql;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ConnectionManager {

	public static Connection getConnection() {
		Connection connection = null;
		SQLServerDataSource dataSource = new SQLServerDataSource();
		dataSource.setUser("sa");
<<<<<<< HEAD
		dataSource.setPassword("winpoint");
//		dataSource.setPassword("@Shradz8888");
		//dataSource.setPassword("Dockersql123");
=======
//		dataSource.setPassword("@Shradz8888");
		dataSource.setPassword("Dockersql123");
>>>>>>> 62d63d13b282f6b4845cfa0ce0e0fb1c25375f95
//		dataSource.setServerName("SHRIRANGMHALGI\\SQLEXPRESS");
		dataSource.setServerName("localhost");
//		dataSource.setServerName("DESKTOP-ARN90J1");
		dataSource.setPortNumber(Integer.parseInt("1433"));
		dataSource.setDatabaseName("WinPoint-Digitization");
		try {
			connection = dataSource.getConnection();
		} catch (SQLServerException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
