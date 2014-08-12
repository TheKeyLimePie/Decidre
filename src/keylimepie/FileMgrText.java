package keylimepie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMgrText extends FileMgr<String>
{
	public FileMgrText()
	{
		super();
	}
	
	//add every selected file to FileMgr
	public void load()
	{
		for(File f : getDirectories())
		{
			for(File file : f.listFiles())
			{
				//contains whole file content
				String content = "";
				try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr))
				{
					//contains just one line of the file
					String l;
					while((l = br.readLine()) != null)
					{
						//took care of UTF-8 encoding
						content += new String(l.getBytes(), "UTF-8") + System.lineSeparator();
					}
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(IOException ioE)
				{
					ioE.printStackTrace();
				}
				
				addDecision(new TextFileObject(file.getName(), file.getPath(), Assigning.NONE, content));
			}
		}
	}
	
	//save files according to decision
	//ADD CUSTOM OUTPUT DIRECTORIES OPTION LATER!
	public void save()
	{
		for(DecisionObject<String> d : this)
		{
			File f = new File("DECISIONS/" + d.getAssigned().getValue() + "/" + d.getFilename());
			//if the directory does not exist yet
			f.getParentFile().mkdirs();
			System.out.println(f.getAbsolutePath());
			try(FileWriter fw = new FileWriter(f); BufferedWriter bw = new BufferedWriter(fw))
			{
				bw.write(d.getContent());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
