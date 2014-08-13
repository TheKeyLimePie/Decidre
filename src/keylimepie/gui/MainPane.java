package keylimepie.gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPane extends JPanel
{
	private DecisionObjectPane content;
	private ButtonRow buttons;
	private MainGUI root;
	
	public MainPane(MainGUI m)
	{
		root = m;
		setSize(800, 600);
		setLayout(null);
		
		content = new DecisionObjectPane();
		add(content);
		buttons = new ButtonRow(root);
		add(buttons);
		
		setVisible(true);
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(800, 600);
	}

	public DecisionObjectPane getContent()
	{
		return content;
	}

	public ButtonRow getButtons()
	{
		return buttons;
	}
}
