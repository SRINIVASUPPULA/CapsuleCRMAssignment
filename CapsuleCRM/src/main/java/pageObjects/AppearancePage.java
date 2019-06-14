package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppearancePage {

	public WebDriver driver;
	
	By logo = By.xpath("//input[@id='appearance:uploadDecorate:logoImage']");
	By saveBtn = By.xpath("//a[text()='Save']");
	By errormsg = By.xpath("//ul[@class='errorMsg']");
	
	public AppearancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement AddLogo() {
		return driver.findElement(logo);
	}
	
	public WebElement SaveLogo() {
		return driver.findElement(saveBtn);
	}
	
	public WebElement Error() {
		return driver.findElement(errormsg);
	}
	
}
