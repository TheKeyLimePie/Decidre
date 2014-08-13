package keylimepie.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopInfoBar extends JPanel
{
	private JLabel headFilename;
	
	public TopInfoBar()
	{
		setSize(800,20);
		setLayout(new FlowLayout());
		setBackground(new Color(35,35,35));
		setForeground(Color.WHITE);
		
		headFilename = new JLabel("no file open");
		headFilename.setForeground(Color.WHITE);
		
		add(headFilename);
	}
	
	public void setHeadFilename(String name)
	{
		headFilename.setText(name);
	}
}
