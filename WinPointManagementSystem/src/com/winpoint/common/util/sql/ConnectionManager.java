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
=======
//		dataSource.setPassword("@Shradz8888");
		dataSource.setPassword("Dockersql123");
>>>>>>> d6636d8a128611c7a6fbb66ccaad44a18a5cf04b
//		dataSource.setServerName("SHRIRANGMHALGI\\SQLEXPRESS");
		dataSource.setServerName("DESKTOP-8PA8OIH");
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
