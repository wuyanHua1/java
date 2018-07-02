package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.panel.TabPanel;

public class CloseActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TabPanel.getIntances().DeleteTab();
	}
}
