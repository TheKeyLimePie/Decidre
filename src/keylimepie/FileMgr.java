package keylimepie;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class FileMgr<T> implements Iterable<DecisionObject<T>>
{
	private ArrayList<File> directories;
	private ArrayList<DecisionObject<T>> decisions;
	private HashMap<String, File> assignings;
	private DecisionObject<T> current;
	private String root;
	
	public FileMgr()
	{
		directories = new ArrayList<>();
		decisions = new ArrayList<>();
		assignings = new HashMap<>();
		root = "DECISIONS";
		assignings.put("decision A", new File(root + "/decision A"));
		assignings.put("decision B", new File(root + "/decision B"));
		assignings.put("neutral", new File(root + "/neutral"));
	}

	public void addDirectory(File f)
	{
		directories.add(f);
	}
	
	protected void addDecision(DecisionObject<T> d)
	{
		decisions.add(d);
	}
	
	public abstract void load();

	public void unload()
	{
		current = null;
		decisions = null;
	}
	
	public abstract void save();
	
	public ArrayList<File> getDirectories()
	{
		return directories;
	}

	public ArrayList<DecisionObject<T>> getDecisions()
	{
		return decisions;
	}

	public File getAssigningPath(String s, String f)
	{
		if(assignings.get(s) != null)
			return new File(assignings.get(s).getAbsolutePath() + "/" + f);
		else
			return new File(root + "/ERROR/" + f);
	}
	
	public String getRoot()
	{
		return root;
	}
	
	public void setRoot(String s)
	{
		root = s;
	}
	
	public HashMap<String, File> getAssignings()
	{
		return assignings;
	}
	
	public boolean hasNext()
	{
		if(current == null && decisions.size() > 0)
			return true;
		else if(current == null && decisions.size() == 0)
			return false;
		
		if(decisions.contains(current) && decisions.indexOf(current) < (decisions.size() - 1))
			return true;
		return false;
	}
	
	public DecisionObject<T> getCurrent()
	{
		return current;
	}
	
	public DecisionObject<T> getNext()
	{
		if(current == null)
			current = decisions.get(0);
		else
			current = decisions.get(decisions.indexOf(current) + 1);
		
		return current;
	}
	
	public Iterator<DecisionObject<T>> iterator()
	{
		return decisions.iterator();
	}
}
