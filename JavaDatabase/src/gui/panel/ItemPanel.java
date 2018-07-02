package gui.panel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import Exception.PoolException;
import gui.Text.Text;
import util.ConnectionPool;

public class ItemPanel extends JPanel implements TreeSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPopupMenu popupMenu;
	private String SelectNodeString;
	private ItemPanel() throws PoolException, SQLException{
		// TODO Auto-generated constructor stub\
		Init();
	}
	private void Init() throws PoolException, SQLException
	{
		Connection connection = ConnectionPool.getInstance().getConnection();
		if(connection!=null)
		{
			InitTree(connection);
			ConnectionPool.getInstance().ReturnConnection(connection);
			InitPopMenu();
		}
	}
	public static ItemPanel getIntsance(){
		if(Intsance==null)
		{
			try {
				Intsance=new ItemPanel();
			} catch (PoolException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Intsance;
	}
	private static ItemPanel Intsance;
	
	private  void InitTree(Connection connection) throws SQLException
	{
		JTree tree=AddDatabaseNameChild(connection);
		this.add(tree);
	}
	
	private JTree AddDatabaseNameChild(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode root=new DefaultMutableTreeNode(Text.DatabasesName);
		PreparedStatement preparedStatement=connection.prepareStatement("show tables");
		ResultSet set=preparedStatement.executeQuery();
		DefaultTreeModel model=new DefaultTreeModel(root);
		while(set.next())
		{
			DefaultMutableTreeNode node=new DefaultMutableTreeNode(set.getString(1));
			model.insertNodeInto(node, root,root.getChildCount());
			AddTablesChild(node,model,set.getString(1),connection);
		}
		
		JTree tree = new JTree(model);  
        //设置Tree的选择为一次只能选择一个节点  
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  
        //注册监听器 
        tree.addTreeSelectionListener(this);  
        return tree;
	}
	private void AddTablesChild(DefaultMutableTreeNode node,DefaultTreeModel model,String name,Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement=connection.prepareStatement("show columns from "+name);
		ResultSet set=preparedStatement.executeQuery();
		while(set.next())
		{
			DefaultMutableTreeNode col=new DefaultMutableTreeNode(set.getString(1));
			model.insertNodeInto(col, node,node.getChildCount());
		}
		set.close();
		preparedStatement.close();
	}
	public String getSelectNodeString()
	{
		return SelectNodeString;
	}
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		JTree tree = (JTree)e.getSource();  
        //获取目前选取的节点  
        DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();  
        SelectNodeString = selectionNode.toString();  
	}
	private void InitPopMenu()
	{
		popupMenu=new JPopupMenu();
		JMenuItem refresh=new JMenuItem(Text.Refresh);
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ItemPanel.getIntsance().removeAll();
					ItemPanel.getIntsance().Init();
					ItemPanel.getIntsance().revalidate();
				} catch (PoolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popupMenu.add(refresh);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON3) {
                    // 弹出菜单
                    popupMenu.show(ItemPanel.this, e.getX(), e.getY());
                }
			}
		});
	}
}