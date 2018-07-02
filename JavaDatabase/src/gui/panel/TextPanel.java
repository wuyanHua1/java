package gui.panel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextPanel extends JScrollPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea area;
	public boolean TextChange=false;
	private String filePath;
	private String title;
	//private JScrollPane scrollPane=new JScrollPane();
	public TextPanel(String text,String filePath,String title) {
		// TODO Auto-generated constructor stub
		this.setTitle(title);
		this.setFilePath(filePath);
		area=new JTextArea();
		area.setText(text);
		area.setLineWrap(true);
		area.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				TextChange=true;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				TextChange=true;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				TextChange=true;
			}
		});
		//scrollPane.add(area);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setViewportView(area);
		
	}
	public void SetFont(Font font)
	{
		area.setFont(font);
	}
	public String getSelectText()
	{
		return area.getSelectedText();
	}
	public String AllText()
	{
		return area.getText();
	}
	public void SetText(String text) {
		area.setText(text);
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
