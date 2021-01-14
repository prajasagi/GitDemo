package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NetflixLoginPage
{
	public WebDriver driver;

	By txt_username=By.name("userLoginId");
	By txt_password=By.name("password");
	//By txt_forgotpassword=By.name("email");
	By txt_forgotpassword=By.name("forgot_password_input");
	By btn_login=By.xpath("//button[contains(text(),'Sign In')]");
	By lnk_resetPassword = By.xpath("//a[contains(text(),'reset your password.')]");
	By lnk_validate = By.xpath("//input[@id='forgot_password_input']");
	




	public NetflixLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;

	}



	public WebElement Password()
	{
		return driver.findElement(lnk_resetPassword);
	//	return new ForgotPassword(driver);

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
		return driver.findElement(txt_forgotpassword);
	}

	

}