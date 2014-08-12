package keylimepie;

public abstract class DecisionObject<T>
{
	private String filename;
	private String path;			//File path
	private Assigning assigned;		//Assignment of Object
	private T content;				//content you have to make a decision to
	
	public DecisionObject(String filename, String path, Assigning assigned, T content)
	{
		this.filename = filename;
		this.path = path;
		this.assigned = assigned;
		this.content = content;
	}

	public String getFilename()
	{
		return filename;
	}
	
	public String getPath()
	{
		return path;
	}

	public Assigning getAssigned()
	{
		return assigned;
	}

	public T getContent()
	{
		return content;
	}
	
	public void setAssigned(Assigning a)
	{
		assigned = a;
	}
}
