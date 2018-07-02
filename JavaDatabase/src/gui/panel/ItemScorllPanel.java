package gui.panel;

import java.awt.Dimension;

import javax.swing.JScrollPane;


public class ItemScorllPanel extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ItemPanel itemPanel;
	private ItemScorllPanel() {
		// TODO Auto-generated constructor stub
		itemPanel=ItemPanel.getIntsance();
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setPreferredSize(new Dimension(150, 0));
		this.setViewportView(itemPanel);
	}
	public static ItemScorllPanel getInstance() {
		return Instance;
	}
	private static ItemScorllPanel Instance=new ItemScorllPanel();
	
}
