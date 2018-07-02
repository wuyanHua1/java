package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import gui.Text.Text;
import gui.panel.TabPanel;
import gui.panel.TextPanel;

public class SaveActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Save();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void Save() throws IOException {
		TabPanel Tabpanel=TabPanel.getIntances();
		
		TextPanel panel=(TextPanel)Tabpanel.getSelectedComponent();
		
		if(panel!=null)
		{
			if(panel.TextChange||panel.getFilePath().equals(""))
			{
				if(panel.getFilePath().equals(""))
				{
					JFileChooser chooser=new JFileChooser();
					chooser.setMultiSelectionEnabled(false);
					chooser.setCurrentDirectory(new File(Text.DesktopPath));  
					chooser.showSaveDialog(Tabpanel);
					File file=chooser.getSelectedFile();
					if(file!=null)
					{
						try(FileOutputStream fileOutputStream= new FileOutputStream(file))
						{
							fileOutputStream.write(panel.AllText().getBytes());
						}
					}
				}
				else
				{
					File file=new File(panel.getFilePath());
					try(FileOutputStream fileOutputStream= new FileOutputStream(file))
					{
						fileOutputStream.write(panel.AllText().getBytes());
					}
					
				}
			}
		}
	}
}
