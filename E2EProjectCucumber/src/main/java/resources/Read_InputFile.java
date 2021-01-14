package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Method to get Rowcount of an excel file
public class Read_InputFile
{
	public static int getRowcount(String Path) throws FileNotFoundException
	{
		int rc=0;
		try(Scanner scanner=new Scanner(new File(Path)))
		{
			scanner.useDelimiter("\n");
			while(scanner.hasNext())
			{
				rc++;
				scanner.next();
			}
		}
		return rc;
	}


	// Method to read exceldata of a given row and column

	public String getValue(String Path,int rc,int cc) throws FileNotFoundException
	{
		String v="";
		try(Scanner scanner=new Scanner(new File(Path)))
		{
			scanner.useDelimiter("\n");
			for(int i=1;i<=rc;i++)
			{
				if (scanner.hasNext())	
					v=scanner.next();


			}			

		}
		return v.split(",")[cc-1];

	}
	
	

}
