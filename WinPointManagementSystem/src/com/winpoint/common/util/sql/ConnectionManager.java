package com.winpoint.common.util.sql;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ConnectionManager {

	public static Connection getConnection() {
		Connection connection = null;
		SQLServerDataSource dataSource = new SQLServerDataSource();

		dataSource.setUser("sa");

		dataSource.setPassword("winpoint");
		dataSource.setServerName("DESKTOP-8PA8OIH");

		//dataSource.setPassword("Dockersql123");

//		dataSource.setPassword("@Shradz8888");
		//dataSource.setPassword("Dockersql123");

		//dataSource.setServerName("localhost");


//	dataSource.setPassword("winpoint");
		//dataSource.setPassword("Dockersql123");

//		dataSource.setPassword("@Shradz8888");
		dataSource.setPassword("Dockersql123");
//		dataSource.setServerName("SHRIRANGMHALGI\\SQLEXPRESS");
	//	dataSource.setServerName("localhost");

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
