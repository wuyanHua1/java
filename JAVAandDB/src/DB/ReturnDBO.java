package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionPool;

public class ReturnDBO {
	private ReturnDBO(){}
	private static ReturnDBO Instance=new ReturnDBO();
	public static ReturnDBO getInstance() {
		return Instance;
	}
	
	private ConnectionPool pool=ConnectionPool.getInstance();
	
	public synchronized boolean InsertReturn(int bookId)
	{
		String lendsql="insert into Renturn values(NULL,?,?)";
		Connection connection=pool.getConnection();
		boolean insert=false;
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(lendsql);	
			)
		{
			preparedStatement.setInt(1, bookId);
			preparedStatement.setDate(2,new Date(System.currentTimeMillis()));
			int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				insert=false;
			}
			else
			{
				insert=true;
			}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			insert=false;
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return insert;
	}
}
