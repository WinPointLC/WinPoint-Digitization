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
