package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Text.Text;
import gui.panel.TabPanel;

public class NewActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TabPanel.getIntances().AddTab(Text.New_1, Text.Empty, Text.Empty);
	}
}
