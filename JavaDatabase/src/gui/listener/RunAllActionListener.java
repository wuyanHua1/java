package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.panel.TabPanel;
import gui.panel.TextPanel;

public class RunAllActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RunAll();
	}
	private void RunAll() {
		TabPanel tabPanel=TabPanel.getIntances();
		TextPanel panel=(TextPanel)tabPanel.getSelectedComponent();
		if(panel!=null)
		{
			String sql=panel.AllText();
			System.out.println(sql);
		}
		
	}
}
