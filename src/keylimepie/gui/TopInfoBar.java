package keylimepie.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopInfoBar extends JPanel
{
	private JLabel filename;
	
	public TopInfoBar()
	{
		setSize(800,20);
		setLayout(new FlowLayout());
		setBackground(new Color(35,35,35));
		setForeground(Color.WHITE);
		
		filename = new JLabel("no file open");
		filename.setForeground(Color.WHITE);
		
		add(filename);
	}
	
	public void setFilename(String name)
	{
		filename.setText(name);
	}
}
