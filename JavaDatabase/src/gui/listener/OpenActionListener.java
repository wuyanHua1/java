package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import gui.Text.Text;
import gui.panel.TabPanel;

public class OpenActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			OpenAction();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void OpenAction() throws IOException {
		TabPanel tabPanel=TabPanel.getIntances();
		JFileChooser chooser=new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		chooser.setCurrentDirectory(new File(Text.DesktopPath));  
		chooser.showOpenDialog(tabPanel);
		File file=chooser.getSelectedFile();
		if(file!=null)
		{
			try (FileInputStream fileInputStream=new FileInputStream(file))
			{
					byte[] b=new byte[10000];
					fileInputStream.read(b);
					tabPanel.AddTab(file.getName(),new String(b),file.getPath());
			}
			
		}
	}
}
