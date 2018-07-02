package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.Config;

public class DButil {
	private static Config config=Config.getInstance();
	private static boolean inited=false;
	private static void Init() {
		if(!inited)
		{
			try {
				Class.forName(config.getString("JDBC_DRIVER"));
				inited=true;
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				inited=false;
			}
		}
	}
	public static Connection getConnection() throws SQLException {
		Init();
		return DriverManager.getConnection(config.getString("JDBC_URL"), config.getString("JDBC_USR"),config.getString("JDBC_Password"));
	}
	public static Connection getConnection(String JDBC_URL,String JDBC_USR,String JDBC_PASSWORD) throws SQLException{
		Init();
		return DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PASSWORD);
	}
}
