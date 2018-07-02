package DB;

import java.sql.Connection;
import java.sql.SQLException;

import Bean.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.ConnectionPool;

public class LoginDBO {
	
	private static LoginDBO Instance=new LoginDBO();
	
	public static LoginDBO getInstance() {
		return Instance;
	}
	
	private LoginDBO()
	{
		
	}
	
	private ConnectionPool pool=ConnectionPool.getInstance();
	public synchronized int find(Manager user){
		String selectsql="select * from Login where id=? and password_=?";
		int Return=3;
		Connection connection=pool.getConnection();
		try
		(
				PreparedStatement preparedStatement=connection.prepareStatement(selectsql);
		)
		{
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				if(resultSet.getInt("id")==1)
				{
					Return=1;//��ʾ���û��ǳ�������Ա
				}
				else
				{
					Return=2;//���û���ͨ����Ա
				}
			}
			else
			{
				Return=3;//���û����ǹ���Ա
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Return=3;
		}
		finally
		{
			pool.ReturnConnection(connection);
		}
		return Return;
	}
	
	public synchronized boolean UpdateManager(Manager manager,String NewPasswords) {
		String updatesql="update Login set password_=? where id=? and password_=?";
		boolean Update=false;
		Connection connection=pool.getConnection();
		try
		(
				PreparedStatement preparedStatement=connection.prepareStatement(updatesql);
		)
		{
			preparedStatement.setString(1, NewPasswords);
			preparedStatement.setInt(2, manager.getId());
			preparedStatement.setString(3, manager.getPassword());
			int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				Update=false;
			}
			else
			{
				Update=true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Update=false;
		}
		finally
		{
			pool.ReturnConnection(connection);
		}
		return Update;
	}
}
