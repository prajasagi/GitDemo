package NF_stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.NetflixLoginPage;
import resources.ReusableFunctions;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class Netflix_stepDefinition extends ReusableFunctions {
public WebDriver driver;
	@Given("^Initialize the browser with Chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {

		driver =initializeDriver();

	}

	@When("^Validate Netflix login with username (.+) password (.+) and (.+) validations$")
	public void validate_netflix_login_with_username_password_and_validations(String username, String password, String text) throws Throwable {

		driver.get("https://www.netflix.com/login");
		driver.manage().window().maximize();
		NetflixLoginPage l=new NetflixLoginPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(username);
		l.getUsername().sendKeys(username); 
		l.getPassword().sendKeys(password);
		l.Loginbtn().click();		
		//driver.close();
		driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/div/div[2]/a")).click();
		l.ForgotUsername().clear();
		l.ForgotUsername().sendKeys(text);
		if(l.ForgotUsername().isEnabled())
		{
			System.out.println("The reset Password functionality got validated successfully");
		}
		else
		{
			System.out.println("The reset Password functionality got failed");
		}
		driver.close();

	}



	@Then("^Close all applications$")
	public void validate_results() throws Throwable
	{
		driver.quit();
		System.out.println("All browser closed");
	}

}