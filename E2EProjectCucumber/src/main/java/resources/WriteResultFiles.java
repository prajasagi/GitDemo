package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteResultFiles {


	public FileInputStream prop;
	public String Path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
	public String DBserver;
	public String rpath=System.getProperty("user.dir");
	
	public StringBuilder sb;
	public PrintWriter writer;


	
	public PrintWriter writer() throws FileNotFoundException 
	{
		String rp=""+rpath+"\\reports\\xlresults.csv";

		PrintWriter writer=new PrintWriter(new File(rp));
		return writer;
	}
	
	public StringBuilder WriteResultsFile() throws IOException
	{
		
		writer=writer();
		StringBuilder sb=new StringBuilder();
		sb.append(" ");
		sb.append("Testcase");
		sb.append(",");
		sb.append("Username");
		sb.append(",");
		sb.append("Password");
		sb.append(",");
		sb.append("Status");
		sb.append("\n");
		
		return sb;	
					
	}
	
	
	
	
}
