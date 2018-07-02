package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Bean.Book;
import Util.ConnectionPool;

public class BookDBO {
	private static BookDBO Instance=new BookDBO();
	
	public static BookDBO getInstance() {
		return Instance;
	}
	
	private BookDBO() {
		
	}
	
	private ConnectionPool pool=ConnectionPool.getInstance();
	public synchronized List<Book> Select(String name) {
		String selectsql="select * from Book where name_ like ?";
		List<Book> books=new LinkedList<>();
		Connection connection=pool.getConnection();
		try(
				PreparedStatement preparedStatement=connection.prepareStatement(selectsql);
			)
		{
			preparedStatement.setString(1, "%"+name+"%");
			ResultSet set=preparedStatement.executeQuery();
			while (set.next()) {
				Book book=new Book();
				book.setId(set.getInt("id"));
				book.setName(set.getString("name_"));
				book.setType(set.getString("type_"));
				book.setPublisher(set.getString("publisher_"));
				book.setState(set.getString("state_"));
				books.add(book);
			}
			return books;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return null;
	}
	
	public synchronized boolean DeleteBookById(Integer id) {
		String deletesql="delete from Book where id=?";
		boolean deleteed=false;
		Connection connection=pool.getConnection();
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(deletesql);	
			)
		{
			preparedStatement.setInt(1, id);
			int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				deleteed=false;
			}
			else
			{
				deleteed=true;
			}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			deleteed=false;
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return deleteed;
	}
	
	public synchronized boolean InsertBook(Book book)
	{
		String deletesql="insert into Book values(NULL,?,?,?,'ÔÚ¹Ý')";
		boolean Inserted=false;
		Connection connection=pool.getConnection();
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(deletesql);	
			)
		{
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getPublisher());
			preparedStatement.setString(3, book.getType());
			int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				Inserted=false;
			}
			else
			{
				Inserted=true;
			}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			Inserted=false;
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return Inserted;
	}

	public synchronized Book Find(int id) {
		String deletesql="select * from Book where id=?";
		Book book=null;
		Connection connection=pool.getConnection();
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(deletesql);	
			)
		{
			preparedStatement.setInt(1, id);
			ResultSet set=preparedStatement.executeQuery();
			if(set.next())
			{
				book=new Book();
				book.setId(set.getInt("id"));
				book.setName(set.getString("name_"));
				book.setType(set.getString("type_"));
				book.setPublisher(set.getString("publisher_"));
				book.setState(set.getString("state_"));
			}
			else
			{
				book=null;
			}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			book=null;
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return book;
	}

	public synchronized boolean UpdateBook(Book book)
	{
		String updatesql="update Book set name_=?,type_=?,publisher_=? where id=?";
		Connection connection=pool.getConnection();
		boolean update=false;
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(updatesql);	
			)
		{
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getType());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setInt(4, book.getId());
			int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				update=false;
			}
			else
			{
				update=true;
			}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			update=false;
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return update;
	}

	public synchronized boolean UpdateBookStatue(int id,String state)
	{
		String updatesql="update Book set state_=? where id=?";
		Connection connection=pool.getConnection();
		boolean update=false;
		try(
			PreparedStatement preparedStatement=connection.prepareStatement(updatesql);	
			)
		{
			preparedStatement.setString(1, state);
			preparedStatement.setInt(2, id);
			int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				update=false;
			}
			else
			{
				update=true;
			}
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			update=false;
		}
		finally {
			pool.ReturnConnection(connection);
		}
		return update;
	}
}
