package keylimepie.gui;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import keylimepie.Assigning;
import keylimepie.DecisionObject;
import keylimepie.FileMgrText;

public class MainGUI extends JFrame
{
	private MainPane mainPane;
	private FileMgrText mgr;
	
	public void GUIinit()
	{
		setTitle("Decidre");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setLayout(null);
		setResizable(false);
		mainPane = new MainPane();
		for(JButton b : mainPane.getButtons().getButtons())
		{
			b.addActionListener(ae ->
			{
				String value = ((JButton)ae.getSource()).getText();
				try
				{
					Assigning a = Assigning.fromString(value);
					decisionMade(a);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			});
		}
		setContentPane(mainPane);
		pack();
		
		setVisible(true);
	}
	
	public void start()
	{
		mgr = new FileMgrText();
		mgr.addDirectory(new File("texts/"));
		mgr.load();

		mainPane.getContent().getContent().setText(mgr.hasNext() ? mgr.getNext().getContent() : "OOPS, ERROR");
	}
	
	public void decisionMade(Assigning a)
	{
		mgr.getCurrent().setAssigned(a);
		System.out.println(mgr.getCurrent().getFilename() + ": " + mgr.getCurrent().getAssigned());
		if(mgr.hasNext())
			mainPane.getContent().getContent().setText(mgr.getNext().getContent());
		else
		{
			mainPane.getContent().getContent().setText("");
			//mgr.save();
			mgr.unload();
		}
	}
	
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				MainGUI main = new MainGUI();
				main.GUIinit();
				main.start();
			}
		});
	}
}
