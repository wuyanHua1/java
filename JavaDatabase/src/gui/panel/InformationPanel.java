package gui.panel;




import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InformationPanel extends JScrollPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea area;
	private InformationPanel() {
		// TODO Auto-generated constructor stub
		area=new JTextArea();
		area.setEditable(false);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setViewportView(area);
		this.setPreferredSize(new Dimension(0, 200));
	}
	private static InformationPanel Instance=new InformationPanel();
	public static InformationPanel getInstance() 
	{
		return Instance;
	}
	public void AppendText(String string)
	{
		area.append(string+"\n");
	}
}
