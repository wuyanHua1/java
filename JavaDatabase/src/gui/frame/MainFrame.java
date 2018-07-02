package gui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import javax.swing.JFrame;
import gui.Text.Text;
import gui.listener.CloseActionListener;
import gui.listener.ExitActionListener;
import gui.listener.NewActionListener;
import gui.listener.OpenActionListener;
import gui.listener.RunActionListener;
import gui.listener.RunAllActionListener;
import gui.listener.SaveActionListener;
import gui.listener.SaveAsActionListener;
import gui.panel.InformationPanel;
import gui.panel.ItemScorllPanel;
import gui.panel.TabPanel;
import gui.panel.TextPanel;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuBar bar;
	private TabPanel Tabpanel;
	private ToolBar toolBar;
	private ItemScorllPanel itemPanel;
	private InformationPanel informationPanel;
	public MainFrame()
	{
		informationPanel=InformationPanel.getInstance();
		bar=MenuBar.getInstance();
		Tabpanel=TabPanel.getIntances();
		toolBar=ToolBar.getInstance();
		itemPanel=ItemScorllPanel.getInstance();
		InitLayout();
		InitListener();
	    Init();
	}
	
	private void InitLayout()
	{
		this.add(toolBar,BorderLayout.NORTH);
		this.setJMenuBar(bar);
		this.add(itemPanel,BorderLayout.WEST);
		this.add(informationPanel,BorderLayout.SOUTH);
		this.add(Tabpanel);
	}
	
	private void Init()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		this.setTitle(Text.MainTitle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(screen.width/4,screen.height/4,screen.width/2,screen.height/2);
		//this.setResizable(false);
	}
	private  void InitListener() {
		toolBar.open.addActionListener(new OpenActionListener());
		//添加工具栏中的打开时间响应
		bar.open.addActionListener(new OpenActionListener());
		//添加菜单栏中开始事件响应
		
		toolBar.New.addActionListener(new NewActionListener());
		
		bar.New.addActionListener(new NewActionListener());
		
		toolBar.run.addActionListener(new RunActionListener());
		
		toolBar.runAll.addActionListener(new RunAllActionListener());
		
		toolBar.save.addActionListener(new SaveActionListener());
		
		bar.save.addActionListener(new SaveActionListener());
		
		toolBar.SaveAs.addActionListener(new SaveAsActionListener());
		
		bar.saveAs.addActionListener(new SaveAsActionListener());
		
		bar.close.addActionListener(new CloseActionListener());
		
		toolBar.Cut.addActionListener(new CloseActionListener());
		
		bar.exit.addActionListener(new ExitActionListener());
		
		bar.utf_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeEncoding("UTF-8");
			}
		});
		
		bar.GBK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeEncoding("GBK");
			}
		});
		bar.utf_16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeEncoding("UTF-16");
			}
		});
	}
	/*private void OpenAction() {
		JFileChooser chooser=new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		chooser.setCurrentDirectory(new File(Text.DesktopPath));  
		chooser.showOpenDialog(Tabpanel);
		File file=chooser.getSelectedFile();
		if(file!=null)
		{
			try (FileInputStream fileInputStream=new FileInputStream(file);
					){
					byte[] b=new byte[10000];
					fileInputStream.read(b);
					Tabpanel.AddTab(file.getName(),new String(b),file.getPath());
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, e1.getMessage(),"错误", JOptionPane.ERROR_MESSAGE);
				}
		}
	}
	private void NewAction() {
		Tabpanel.AddTab(Text.New_1, Text.Empty, Text.Empty);
	}
	private void Run()
	{
		TextPanel panel=(TextPanel)Tabpanel.getSelectedComponent();
		if(panel!=null)
		{
			String sql=panel.getSelectText();
			System.out.println(sql);
		}
		
	}
	
	private void RunAll() {
		TextPanel panel=(TextPanel)Tabpanel.getSelectedComponent();
		if(panel!=null)
		{
			String sql=panel.AllText();
			System.out.println(sql);
		}
		
	}
	
	private void Save() {
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
						try (FileOutputStream fileOutputStream= new FileOutputStream(file);){
							fileOutputStream.write(panel.AllText().getBytes());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e.getMessage(),"错误", JOptionPane.ERROR_MESSAGE);
						}
					}
						
				}
				else
				{
					File file=new File(panel.getFilePath());
					try (FileOutputStream fileOutputStream= new FileOutputStream(file);){
						fileOutputStream.write(panel.AllText().getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e.getMessage(),"错误", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
	
	private void SaveAs() {
		TextPanel panel=(TextPanel)Tabpanel.getSelectedComponent();
		if(panel!=null)
		{
			JFileChooser chooser=new JFileChooser();
			chooser.setMultiSelectionEnabled(false);
			chooser.setCurrentDirectory(new File(Text.DesktopPath));  
			chooser.showSaveDialog(Tabpanel);
			File file=chooser.getSelectedFile();
			if(file!=null)
			{
				try (FileOutputStream fileOutputStream= new FileOutputStream(file);){
					fileOutputStream.write(panel.AllText().getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, e.getMessage(),"错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	private void Exit()
	{
		System.exit(0);
	}*/
	
	private void ChangeEncoding(String encoding){
		TextPanel panel=(TextPanel)Tabpanel.getSelectedComponent();
		panel.SetText(new String(panel.AllText().getBytes(),Charset.forName(encoding)));
		
	}
}

