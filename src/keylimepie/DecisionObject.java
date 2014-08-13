package keylimepie;

public abstract class DecisionObject<T>
{
	private String filename;
	private String path;			//File path
	private String assigned;		//Assignment of Object
	private T content;				//content you have to make a decision to
	
	public DecisionObject(String filename, String path, String assigned, T content)
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

	public String getAssigned()
	{
		return assigned;
	}

	public T getContent()
	{
		return content;
	}
	
	public void setAssigned(String s)
	{
		assigned = s;
	}
}
