package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Exception.PoolException;
import util.ConnectionPool;

public class ExitActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		try {
			ConnectionPool.getInstance().ClosePool();
		} catch (SQLException | PoolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
