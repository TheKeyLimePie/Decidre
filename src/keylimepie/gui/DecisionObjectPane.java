package keylimepie.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DecisionObjectPane extends JPanel
{
	private JTextArea content;
	private JScrollPane scrollPane;
	
	public DecisionObjectPane()
	{
		setBounds(0,0,800,550);
		setLayout(new BorderLayout());
		content = new JTextArea();
		content.setEditable(false);
		content.setLineWrap(true);
		
		scrollPane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(scrollPane, BorderLayout.CENTER);

	}

	public JTextArea getContent()
	{
		return content;
	}
	
}
