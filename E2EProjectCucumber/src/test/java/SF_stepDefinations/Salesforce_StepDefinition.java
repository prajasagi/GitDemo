package SF_stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.SalesforceLoginPage;
import resources.Read_InputFile;
import resources.ReusableFunctions;
import resources.WriteResultFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class Salesforce_StepDefinition extends ReusableFunctions{
	public WebDriver driver;
	public Read_InputFile rf=new Read_InputFile();
	public WriteResultFiles wf= new WriteResultFiles();


	@Given("^Initialize the browser with Chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver =initializeDriver();
	}

	@When("^Validate Salesforce login with all validations$")
	public void validate_salesforce_login_with_all_validations() throws IOException 
	{
		StringBuilder ref=wf.WriteResultsFile();
		PrintWriter pw=wf.writer();

		String rpath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Inputfile.csv";

		int rfile=Read_InputFile.getRowcount(rpath);
		System.out.println("rowcount "+rfile);
		for(int i=1;i<rfile;i++)
		{

			String url=URL();
			driver.get(url);
			driver.manage().window().maximize();
			SalesforceLoginPage l=new SalesforceLoginPage(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String tc=rf.getValue(rpath, i+1, 1);
			System.out.println("tstcase :"+tc);	   
			String un=rf.getValue(rpath, i+1, 2);
			System.out.println("username :"+un);
			String pwd=rf.getValue(rpath, i+1, 3);
			System.out.println("password :"+pwd);
			l.getUsername().sendKeys(un);
			l.getPassword().sendKeys(pwd);


			l.Loginbtn().click();
			l.forgotPassword().click();
			l.ForgotUsername().sendKeys("xxx");
			if(l.Sandboxlnk().isDisplayed())
			{	
				l.Cancelbtn().click();
				ref.append(i);
				ref.append(',');
				ref.append(un);
				ref.append(',');
				ref.append(pwd);
				ref.append(',');
				ref.append("Passed");
				ref.append('\n');
			}
			else
			{
				ref.append(i);
				ref.append(',');
				ref.append(un);
				ref.append(',');
				ref.append(pwd);
				ref.append(',');
				ref.append("Failled");
				ref.append('\n');
			}
			

		}

		driver.close();


		pw.write(ref.toString());
		pw.flush();
		pw.close();

	}



	@Then("^validate results$")
	public void validate_results() throws Throwable
	{
		System.out.println("file:///C://Users//paone//eclipse-workspace//E2EProject//E2EProject//reports//xlresults.csv");

	}

}