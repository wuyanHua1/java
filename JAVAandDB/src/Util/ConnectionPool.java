package Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import config.Config;

public class ConnectionPool {
	private static ConnectionPool Instance=new ConnectionPool();
	public static ConnectionPool getInstance() {
		return Instance;
	}
	
	private Config config=Config.getInstance();
	private List<Connection> connections=new LinkedList<>();
	private ConnectionPool() {
		for(int i=0;i<config.getInt("POOL_SIZE");++i)
		{
			try {
				connections.add(DButil.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Connection getConnection() {
		synchronized (connections) {
			return connections.get(0);
		}
	}
	public void ReturnConnection(Connection connection)
	{
		synchronized (connections) {
			connections.add(connection);
		}
	}
}
