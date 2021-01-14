package resources;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;




public class ReusableFunctions {

	public  WebDriver driver;
	public Properties prop;
	public String rpath=System.getProperty("user.dir");
	public String Path=""+rpath+"\\src\\main\\java\\resources\\data.properties";
	public String DBserver,Host;



	public String URL() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(Path);
		prop.load(fis);
		Host=prop.getProperty("url");
		System.out.println("Host :"+Host);
		
		return Host;		
	}


	public WebDriver initializeDriver() throws IOException
	{
		System.out.println(System.getProperty("user.dir"));
		prop= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		// reading maven commands
		//String browserName=System.getProperty("browser");
		// reading from properties file
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\WebDrivers\\Chrome\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");	 
			}
			driver= new ChromeDriver(options);


		}
		else if (browserName.equals("firefox"))
		{

			System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"\\WebDrivers\\FireFox\\geckodriver.exe");
			driver= new FirefoxDriver();
			//firefox code
		}
		else if (browserName.equals("IE"))
		{
			//		IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;


	}

	public Connection MySQLConnect() throws SQLException, IOException{


		Properties props= new Properties();
		FileInputStream fis=new FileInputStream(Path);
		props.load(fis);
		String Host=props.getProperty("MySQLServer");
		String Port=props.getProperty("MySQLPort");
		String DB=props.getProperty("MySQLDB");
		String Username=props.getProperty("MySQLUsername");
		String Password=props.getProperty("MySQLPassword");
		Connection con=DriverManager.getConnection("jdbc:mysql://"+Host+":"+Port+"/"+DB+"",Username,Password);
		return con;

	}

	public Connection SQLServerConnect() throws SQLException, IOException{

		Properties props= new Properties();
		FileInputStream fis=new FileInputStream(Path);
		props.load(fis);	String Host=props.getProperty("SQLServer");
		String Port=props.getProperty("SQLPort");
		String DB=props.getProperty("SQLDB");
		String Username=props.getProperty("SQLUsername");
		String Password=props.getProperty("SQLPassword");

		String connectionUrl = "jdbc:sqlserver://"+Host+":"+Port+";databaseName="+DB+";user="+Username+";password="+Password+"";
		Connection con = DriverManager.getConnection(connectionUrl);
		return con;


	}        	

	public String DBserver() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream(Path);
		prop.load(fis);
		DBserver=prop.getProperty("DBserver");
		return DBserver;
	}

	public void getScreenshot(String filename) throws IOException{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(""+rpath+"//src//Results//Screenshots//"+filename+"_Screenshot.png"));
	}

	public String datefun(String bd)
	{
		String DOB=bd;
		String[] Bdate=DOB.split("/");
		String mm=Bdate[0];
		String dd=Bdate[1];
		if(mm.length()==1)
		{
			mm="0"+dd;

		}
		if (dd.length()==1)
		{
			dd="0"+dd;
		}

		String yy = Bdate[2];
		String dateofbirth=""+mm+"/"+dd+"/"+yy+"";
		return dateofbirth;

	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;

	}

}
