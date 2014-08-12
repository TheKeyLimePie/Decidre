package keylimepie;

//Possible options to attach an object/file to - values are directory names!
public enum Assigning
{
	NONE("NONE"), ME("me"), HIM("him");
	
	private String path;
	
	private Assigning(String path)
	{
		this.path = path;
	}
	
	public String getValue()
	{
		return path;
	}
}
