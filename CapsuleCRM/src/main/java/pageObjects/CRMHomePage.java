package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRMHomePage {
	public WebDriver driver;
	
	By peopleBtn = By.xpath("//a[@href='/parties']");
	By casesBtn = By.xpath("//a[@href='/cases']");
	By profileBtn = By.xpath("//div[@class='nav-bar-account-details']");
	By settingsBtn	= By.xpath("//a[@href='/settings']");
	
	public CRMHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement people() {
		return driver.findElement(peopleBtn);
	}
	public WebElement cases() {
		return driver.findElement(casesBtn);
	}
	public WebElement profile() {
		return driver.findElement(profileBtn);
	}
	public WebElement settings() {
		return driver.findElement(settingsBtn);
	}
	
	
	
	
	
}
