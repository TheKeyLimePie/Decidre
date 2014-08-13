package keylimepie.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPane extends JPanel
{
	private DecisionObjectPane content;
	private ButtonRow buttons;
	

	
	public MainPane()
	{	
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		content = new DecisionObjectPane();
		add(content, BorderLayout.CENTER);
		buttons = new ButtonRow();
		add(buttons, BorderLayout.SOUTH);
		
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
