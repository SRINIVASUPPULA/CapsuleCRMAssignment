package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRMLoginPage{

	public WebDriver driver;
	
	By unameTxtbox = By.id("login:usernameDecorate:username");
	By pwdTxtbox = By.id("login:passwordDecorate:password");
	By loginBtn = By.id("login:login");
	
	public CRMLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement UserName() {
		return driver.findElement(unameTxtbox);
	}
	public WebElement Password() {
		return driver.findElement(pwdTxtbox);
	}
	public WebElement CRMLogin() {
		return driver.findElement(loginBtn);
	}
	
}
