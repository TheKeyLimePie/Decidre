package keylimepie;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FileMgr<T> implements Iterable<DecisionObject<T>>
{
	private ArrayList<File> directories;
	private ArrayList<DecisionObject<T>> decisions;
	private DecisionObject<T> current;
	
	public FileMgr()
	{
		directories = new ArrayList<>();
		decisions = new ArrayList<>();
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
