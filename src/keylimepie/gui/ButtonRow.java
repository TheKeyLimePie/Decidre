package keylimepie.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonRow extends JPanel
{
	private ArrayList<JButton> buttons;
	
	public ButtonRow()
	{
		setSize(800,50);
		setLayout(new GridLayout());
		
		buttons = new ArrayList<>();
	}
	
	public ArrayList<JButton> getButtons()
	{
		return buttons;
	}
	
	public void addButton(JButton b)
	{
		b.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 20));
		buttons.add(b);
		add(b);
	}
	
	public void removeButton(JButton b)
	{
		if(buttons.contains(b))
			buttons.remove(b);
		
		remove(b);
	}
	
	public void clearAllButtons()
	{
		for(JButton b : buttons)
		{
			remove(b);
		}
		buttons.clear();
	}
}
