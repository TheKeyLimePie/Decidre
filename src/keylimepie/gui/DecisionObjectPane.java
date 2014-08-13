package keylimepie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DecisionObjectPane extends JPanel
{
	private JTextArea content;
	private JScrollPane scrollPane;
	private TopInfoBar info;
	
	public DecisionObjectPane()
	{
		setBounds(0,0,800,550);
		setLayout(new BorderLayout());
		content = new JTextArea();
		content.setBackground(new Color(50, 50, 50));
		content.setForeground(Color.WHITE);
		content.setEditable(false);
		content.setMargin(new Insets(10, 10, 10, 10));
		content.setLineWrap(true);
		
		info = new TopInfoBar();
		
		scrollPane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		add(info, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

	}

	public JTextArea getContent()
	{
		return content;
	}

	public TopInfoBar getInfo()
	{
		return info;
	}
}
