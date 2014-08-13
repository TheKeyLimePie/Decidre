package keylimepie.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import keylimepie.Assigning;

public class ButtonRow extends JPanel
{
	private ArrayList<JButton> buttons;
	
	public ButtonRow()
	{
		setSize(800,50);
		setLayout(new GridLayout());
		
		buttons = new ArrayList<>();
		
		for(int x = 0; x < Assigning.values().length; x++)
		{
			JButton b = new JButton(Assigning.values()[x].getValue());
			buttons.add(b);
			buttons.get(x).setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 20));
			add(buttons.get(x));
			
		}
	}
	
	public ArrayList<JButton> getButtons()
	{
		return buttons;
	}
}
