package keylimepie;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FileMgr<T> implements Iterable<DecisionObject<T>>
{
	private ArrayList<File> directories;
	private ArrayList<DecisionObject<T>> decisions;
	
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

	public abstract void save();
	
	public ArrayList<File> getDirectories()
	{
		return directories;
	}

	public ArrayList<DecisionObject<T>> getDecisions()
	{
		return decisions;
	}

	public Iterator<DecisionObject<T>> iterator()
	{
		return decisions.iterator();
	}
}
