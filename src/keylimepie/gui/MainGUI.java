package keylimepie.gui;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import keylimepie.Assigning;
import keylimepie.FileMgrText;

public class MainGUI extends JFrame
{
	private MainPane mainPane;
	private FileMgrText mgr;
	
	private JMenuBar menubar;
	private JMenu menu_file;
	private JMenuItem file_filesToReadPath, file_decisions, file_exit;

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
		
		menubar = new JMenuBar();
		menu_file = new JMenu("File");
		file_filesToReadPath = new JMenuItem("Directories to scan...");
		file_filesToReadPath.addActionListener(ae -> {System.out.println("Choose input dirs");});
		file_decisions = new JMenuItem("Decision options...");
		file_decisions.addActionListener(ae -> {System.out.println("Choose decision options");});
		file_exit = new JMenuItem("Exit");
		file_exit.addActionListener(ae -> {exit();});
		menu_file.add(file_filesToReadPath);
		menu_file.add(file_decisions);
		//------------------------------
		menu_file.add(new JSeparator());
		menu_file.add(file_exit);
		
		menubar.add(menu_file);
		
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
		setJMenuBar(menubar);
		pack();
		
		setVisible(true);
	}
	
	public void start()
	{
		mgr = new FileMgrText();
		mgr.addDirectory(new File("texts/"));
		mgr.load();

		if(mgr.hasNext())
			mainPane.getContent().setTextFile(mgr.getNext());
		else
			mainPane.getContent().getContent().setText("OOPS, ERROR");
	}
	
	public void decisionMade(Assigning a)
	{
		mgr.getCurrent().setAssigned(a);
		System.out.println(mgr.getCurrent().getFilename() + ": " + mgr.getCurrent().getAssigned());
		if(mgr.hasNext())
			mainPane.getContent().setTextFile(mgr.getNext());
		else
		{
			mainPane.getContent().getInfo().setFilename("no file open");
			mainPane.getContent().getContent().setText("");
			//mgr.save();
			mgr.unload();
		}
	}
	
	
	public void exit()
	{
		int i = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(i == JOptionPane.YES_OPTION)
			System.exit(0);
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
