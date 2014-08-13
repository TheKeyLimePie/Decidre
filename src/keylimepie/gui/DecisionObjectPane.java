package keylimepie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import keylimepie.DecisionObject;

public class DecisionObjectPane extends JPanel
{
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private TopInfoBar info;
	private static final String tutorial = "Welcome to Decidre!\n\nLoad your files you have to make a decision to via \"File\" - \"Load directories to scan...\".\nThen you specify your choose options with their paths via \"Edit\" - \"Specify decision options...\".\nFinally, click \"Start!\".";
	
	public DecisionObjectPane()
	{
		setSize(800,550);
		setLayout(new BorderLayout());
		textArea = new JTextArea();
		textArea.setBackground(new Color(50, 50, 50));
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setText(tutorial);
		
		info = new TopInfoBar();
		info.setHeadFilename("-Welcome to Decidre-");
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		add(info, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

	}
	
	//sets TextArea and InfoBar with attributes of DecisionObject<>
	public void setTextFile(DecisionObject<String> t)
	{
		textArea.setText(t.getContent());
		info.setHeadFilename(t.getFilename());
		scrollPane.getViewport().setViewPosition(new Point(0,0));
	}
	
	public JTextArea getTextArea()
	{
		return textArea;
	}

	public TopInfoBar getInfo()
	{
		return info;
	}
}
