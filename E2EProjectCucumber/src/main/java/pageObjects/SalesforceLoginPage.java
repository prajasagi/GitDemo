package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesforceLoginPage
{
public WebDriver driver;
	
	By txt_username=By.cssSelector("#username");
	By txt_password=By.cssSelector("#password");
	By btn_login=By.cssSelector("#Login");
	By lnk_forgotPassword = By.cssSelector("#forgot_password_link");
	By txt_forgotUsername = By.xpath("//input[@id='un']");
	By lnk_fpvalidation=By.cssSelector("#sandbox-login");
	By btn_Cancel=By.xpath("//a[contains(text(),'Cancel')]");
	
	
	
	
	public SalesforceLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}



public WebElement forgotPassword()
{
	return driver.findElement(lnk_forgotPassword);
	
	
}

public WebElement getUsername()
{
	return driver.findElement(txt_username);
}


public WebElement getPassword()
{
	return driver.findElement(txt_password);
}

public WebElement Loginbtn()
{
	return driver.findElement(btn_login);
}

public WebElement ForgotUsername()
{
	return driver.findElement(txt_forgotUsername);
}

public WebElement Sandboxlnk()
{
	return driver.findElement(lnk_fpvalidation);
}

public WebElement Cancelbtn()
{
	return driver.findElement(btn_Cancel);
}


}
