package gui.frame;


import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton run=new JButton();
	public JButton runAll=new JButton();
	public JButton save=new JButton();
	public JButton open=new JButton();
	public JButton About=new JButton();
	public JButton New=new JButton();
	public JButton SaveAs=new JButton();
	public JButton Cut=new JButton();
	private ToolBar(){
		try
		{
			Image Icon=ImageIO.read(new File("ico//Save.png"));
			save.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//Play.png"));
			run.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//Play All.png"));
			runAll.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//Open.png"));
			open.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//About.png"));
			About.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//Close.png"));
			SaveAs.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//New.png"));
			New.setIcon(new ImageIcon(Icon));
			
			Icon=ImageIO.read(new File("ico//Break.png"));
			Cut.setIcon(new ImageIcon(Icon));
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		this.add(New);
		this.add(save);
		this.add(open);
		this.add(SaveAs);
		this.add(Cut);
		this.addSeparator();
		this.add(run);
		this.add(runAll);
		this.addSeparator();
		this.add(About);
	}
	private static ToolBar Instance;
	public static ToolBar getInstance()
	{
		if(Instance==null)
		{
			Instance=new ToolBar();
		}
		return Instance;
	}
}
