package Main;

import java.sql.SQLException;

import Exception.PoolException;
import gui.Text.Text;
import gui.frame.MainFrame;
import util.ConnectionPool;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConnectionPool.Init(5, "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/"+Text.DatabasesName, "root", "169074163");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame frame=new MainFrame();
	}
}
