package keylimepie.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPane extends JPanel
{
	private DecisionObjectPane decObjectPane;
	private ButtonRow buttonRow;
	
	public MainPane()
	{	
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		decObjectPane = new DecisionObjectPane();
		add(decObjectPane, BorderLayout.CENTER);
		buttonRow = new ButtonRow();
		add(buttonRow, BorderLayout.SOUTH);
		
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

	public ButtonRow getButtonRow()
	{
		return buttonRow;
	}
}
