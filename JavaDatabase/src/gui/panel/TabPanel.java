package gui.panel;


import javax.swing.JTabbedPane;  


public class TabPanel extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JPopupMenu menu=new JPopupMenu();
	TextPanel textPanel;
	private TabPanel() {
		// TODO Auto-generated constructor stub
		//InitPopMenu();
		//this.addTab(NewName, new TextPanel(Text.Empty,Text.Empty,NewName));
	}
	//删除tab
	public void DeleteTab()
	{
		this.remove(this.getSelectedComponent());
	}
	//添加tab
	public void AddTab(String title,String text,String filePath)
	{
		this.addTab(title,new TextPanel(text,filePath,title));
	}
	private static TabPanel Instance=new TabPanel();
	public static TabPanel getIntances()
	{
		return Instance;
	}
	//初始化弹窗菜单
	/*private void InitPopMenu()
	{
		JMenuItem item=new JMenuItem(Text.Add);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			   AddTab(Text.New_1,Text.Empty,Text.Empty);
			}
		});
		
		JMenuItem item2=new JMenuItem(Text.Delete);
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteTab();
			}
		});
		
		menu.add(item);
		menu.add(item2);

		this.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    // 弹出菜单
                    menu.show(TablePanel.this, e.getX(), e.getY());
                }
                }
		});
	
	}*/
}
