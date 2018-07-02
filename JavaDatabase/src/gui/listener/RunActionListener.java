package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.PoolException;
import gui.panel.InformationPanel;
import gui.panel.TabPanel;
import gui.panel.TextPanel;
import util.ConnectionPool;
import util.DBUtil;

public class RunActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Run();
	}
	private void Run()
	{
		TabPanel tabPanel=TabPanel.getIntances();
		TextPanel panel=(TextPanel)tabPanel.getSelectedComponent();
		if(panel!=null)
		{
			String sql=panel.getSelectText();
			PreparedStatement preparedStatement=null;
			ResultSet set=null;
			String result="";
			try 
			{
				Connection connection;
				connection = ConnectionPool.getInstance().getConnection();
				preparedStatement=connection.prepareStatement(sql);
				set=preparedStatement.executeQuery();
				result=DBUtil.ResultSetToString(set);
			} catch (PoolException|SQLException e)
			{
				// TODO Auto-generated catch block
				InformationPanel.getInstance().AppendText(e.getMessage());
			}
			finally {
				
				try {
					if (set!=null) 
					{
						set.close();
					}
					if(preparedStatement!=null)
					{
						preparedStatement.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					InformationPanel.getInstance().AppendText(e.getMessage());
				}
			}
			InformationPanel.getInstance().AppendText(result);
			System.out.println(sql);
		}
		
	}

}
