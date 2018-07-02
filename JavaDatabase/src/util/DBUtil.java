package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class DBUtil
{
	private DBUtil() {};
	public static void Init(String JDBC_DRIVER) throws ClassNotFoundException
	{
		Class.forName(JDBC_DRIVER);
	}
	public static Connection getConnection(String JDBC_URL,String USER,String Password) throws SQLException
	{
		return DriverManager.getConnection(JDBC_URL, USER, Password);
	}
	public static String ResultSetToString(ResultSet set) throws SQLException
	{
		String string=new String("");
		ResultSetMetaData metaData=set.getMetaData();
		int col=metaData.getColumnCount();
		for(int i=1;i<=col;++i)
		{
			string+=(metaData.getColumnLabel(i)+"\t");
		}
		string+="\n";
		while(set.next())
		{
			for(int i=1;i<=col;++i)
			{
				string+=(set.getString(i)+"\t");
			}
			string+="\n";
		}
		return string;
		
	}
}
