package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import Exception.PoolException;

public class ConnectionPool {
	//使用单例模式初始化连接池
	public static void Init(int PoolMaxSize,String JDBC_Driver,String JDBC_URL,String USER,String Password) throws ClassNotFoundException, SQLException
	{
		Instance=new ConnectionPool(PoolMaxSize, JDBC_Driver, JDBC_URL, USER, Password);
	}
	
	private static ConnectionPool Instance; 
	//获取唯一连接池
	public static ConnectionPool getInstance() throws PoolException
	{
		if (Instance==null) {
			throw new PoolException("未初始化连接池");
		}
		else
		{
			return Instance;
		}
	}
	
	private LinkedList<Connection> pool=new LinkedList<>();
	private ConnectionPool(int PoolMaxSize,String JDBC_Driver,String JDBC_URL,String USER,String Password) throws ClassNotFoundException, SQLException
	{
		DBUtil.Init(JDBC_Driver);
		for(int i=0;i<PoolMaxSize;++i)
		{
			pool.add(DBUtil.getConnection(JDBC_URL, USER, Password));
		}
	}
	public Connection getConnection()
	{
		if(pool.isEmpty())
		{
			return null;
		}
		else
		{
			return pool.removeLast();
		}
	};
	public void ReturnConnection(Connection connection) throws PoolException
	{
		if(connection==null)
		{
			throw new PoolException("不能返回空连接对象！");
		}
		else
			pool.add(connection);
	}
	public void ClosePool() throws SQLException
	{
		for(Connection connection:pool)
		{
			connection.close();
		}
	}
}
