package gui.frame;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.Text.Text;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JMenu file;
	public JMenuItem New;
	public JMenuItem save;
	public JMenuItem open;
	public JMenuItem saveAs;
	public JMenuItem close;
	public JMenuItem exit;
	
	
	public JMenuItem utf_8;
	public JMenuItem GBK;
	public JMenuItem utf_16;
	
	
	JMenu edItem;
	private MenuBar() {
		JMenu file=new JMenu(Text.File);
			New=new JMenuItem(Text.New);
			save=new JMenuItem(Text.Save);
			open=new JMenuItem(Text.Open);
			saveAs=new JMenuItem(Text.SaveAs);
			close=new JMenuItem(Text.Close);
			exit=new JMenuItem(Text.Exit);
		file.add(New);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(close);
		file.addSeparator();
		file.add(exit);
		
		JMenu edItem=new JMenu(Text.Edit+"(E)");
			utf_8=new JMenuItem("“‘UTF-8±‡¬Î");
			GBK=new JMenuItem("“‘GBK±‡¬Î");
			utf_16=new JMenuItem("“‘UTF-16±‡¬Î");
		edItem.add(utf_8);
		edItem.add(utf_16);
		edItem.add(GBK);
		
		
		this.add(file);
		this.add(edItem);
		
	}
	
	private static MenuBar Instance=new MenuBar();
	
	public static MenuBar getInstance()
	{
		return Instance;
	}
}
