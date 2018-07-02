package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionPool;

public class LendDBO {
	private LendDBO(){}
	private static LendDBO Instance=new LendDBO();
	public static LendDBO getInstance() {
		return Instance;
	}
	
	private ConnectionPool pool=ConnectionPool.getInstance();
	
	public synchronized boolean InsertLend(int bookId,int ReaderId)
	{
		String lendsql="insert into Lend values(NULL,?,?,?)";
		Connection connection=pool.getConnection();
		boolean insert=false;
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(lendsql);	
			)
		{
			preparedStatement.setInt(1, bookId);
			preparedStatement.setInt(2, ReaderId);
			preparedStatement.setDate(3,new Date(System.currentTimeMillis()));
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
