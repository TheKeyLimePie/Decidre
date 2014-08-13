package keylimepie.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPane extends JPanel
{
	private DecisionObjectPane decObjectPane;
	private ButtonRow buttons;
	
	public MainPane()
	{	
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		decObjectPane = new DecisionObjectPane();
		add(decObjectPane, BorderLayout.CENTER);
		buttons = new ButtonRow();
		add(buttons, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	//overwritten to make JFrame.pack() work
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(800, 600);
	}

	public DecisionObjectPane getDecObjectPane()
	{
		return decObjectPane;
	}

	public ButtonRow getButtons()
	{
		return buttons;
	}
}
