package keylimepie.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import keylimepie.Assigning;

public class ButtonRow extends JPanel
{
	private ArrayList<JButton> buttons;
	private MainGUI root;
	
	public ButtonRow(MainGUI m)
	{
		root = m;
		setBounds(0,550,800,50);
		setLayout(new GridLayout());
		
		buttons = new ArrayList<>();
		
		for(int x = 0; x < Assigning.values().length; x++)
		{
			JButton b = new JButton(Assigning.values()[x].getValue());
			b.addActionListener(ae ->
			{
				String value = ((JButton)ae.getSource()).getText();
				try
				{
					Assigning a = Assigning.fromString(value);
					root.decisionMade(a);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			});
			buttons.add(b);
			buttons.get(x).setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 20));
			add(buttons.get(x));
			
		}
	}
}
