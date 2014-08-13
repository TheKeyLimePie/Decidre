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

import keylimepie.FileMgrText;

public class MainGUI extends JFrame
{
	private MainPane mainPane;
	private FileMgrText mgr;
	
	private JMenuBar menubar;
	private JMenu menu_file, menu_edit, menu_about;
	private JMenuItem file_filesToReadPath, file_exit, edit_decisions, about_about;

	private final String title = "Decidre";
	
	public MainGUI()
	{
		mgr = new FileMgrText();
	}
	
	public void MenuInit()
	{
		menubar = new JMenuBar();
		//File
		menu_file = new JMenu("File");
		file_filesToReadPath = new JMenuItem("Load directories to scan...");
		file_filesToReadPath.addActionListener(ae -> {System.out.println("Choose input dirs");});
		
		file_exit = new JMenuItem("Exit");
		file_exit.addActionListener(ae -> {exit();});
		menu_file.add(file_filesToReadPath);
		//------------------------------
		menu_file.add(new JSeparator());
		menu_file.add(file_exit);
		
		//Edit
		menu_edit = new JMenu("Edit");
		edit_decisions = new JMenuItem("Decision options...");
		edit_decisions.addActionListener(ae -> {System.out.println("Specify decision options");});
		menu_edit.add(edit_decisions);
		
		//About
		menu_about = new JMenu("About");
		about_about = new JMenuItem("About");
		about_about.addActionListener(ae -> {System.out.println("About tab");});
		menu_about.add(about_about);
		
		menubar.add(menu_file);
		menubar.add(menu_edit);
		menubar.add(menu_about);
	}
	
	public void GUIinit()
	{
		setTitle(title);
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
		
		mainPane = new MainPane();
		MenuInit();

		JButton b = new JButton("Start!");
		b.addActionListener(ae -> {ButtonsInit(); start();});
		mainPane.getButtonRow().addButton(b);
		
		setContentPane(mainPane);
		setJMenuBar(menubar);
		pack();
		
		setVisible(true);
	}
	
	//creates buttons with assignment names and ActionListener
	public void ButtonsInit()
	{
		mainPane.getButtonRow().clearAllButtons();
		for(String s : mgr.getAssignings().keySet())
		{
			mainPane.getButtonRow().addButton(new JButton(s));
		}
		//add ActionListeners here so there is a reference to decisionMade(); FileMgrText
		for(JButton b : mainPane.getButtonRow().getButtons())
		{
			b.addActionListener(ae ->
			{
				String value = ((JButton)ae.getSource()).getText();
				try
				{
					decisionMade(value);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			});
		}
		revalidate();
	}
	
	//after the GUI initialization is done load the technical concept
	public void start()
	{
		mgr.addDirectory(new File("texts/"));
		mgr.load();
		
		if(mgr.hasNext())
		{
			mainPane.getDecObjectPane().setTextFile(mgr.getNext());
			setTitle(title + " - " + ( ((mgr.getDecisions().indexOf(mgr.getCurrent()) + 1)*100 / mgr.getDecisions().size()) ) + "%");
		}
		else
			mainPane.getDecObjectPane().getTextArea().setText("OOPS, ERROR");
	}
	
	public void decisionMade(String s)
	{
		if(mgr.getCurrent() != null)
		{
		mgr.getCurrent().setAssigned(s);
		System.out.println(mgr.getCurrent().getFilename() + ": " + mgr.getCurrent().getAssigned());
			if(mgr.hasNext())
			{
				mainPane.getDecObjectPane().setTextFile(mgr.getNext());
				setTitle(title + " - " + ( ((mgr.getDecisions().indexOf(mgr.getCurrent()) + 1)*100 / mgr.getDecisions().size()) ) + "%");
			}
			else
			{
				setTitle(title + " - Done!");
				mainPane.getDecObjectPane().getInfo().setHeadFilename("no file open");
				mainPane.getDecObjectPane().getTextArea().setText("");
				//mgr.save();
				mgr.unload();
			}
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
			}
		});
	}
}
