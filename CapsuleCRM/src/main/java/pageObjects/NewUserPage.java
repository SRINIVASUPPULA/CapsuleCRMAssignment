package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage {
	public WebDriver driver;
	
	By newuserBtn = By.xpath("//a[text()='Add new User']");
	By fnameTxtbox = By.xpath("//input[@id='register:firstnameDecorate:firstName']");
	By lnametxtbox = By.xpath("//input[@id='register:lastNameDecorate:lastName']");
	By emailTxtbox = By.xpath("//input[@id='register:emailDecorate:email']");
	By unameTxtbox = By.xpath("//input[@id='register:usernameDecorate:username']");
	By saveBtn = By.xpath("//input[@id='register:save']");	
	By users = By.xpath("//table[@id='j_id128:users']/tbody/tr");
	By errormsg = By.xpath("//span[@class='fieldErrorMsg']");
	By cancel = By.xpath("//a[id='register:cancel']");
	
	
	public NewUserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement AddUser() {
		return driver.findElement(newuserBtn);
	}
	public WebElement FirstName() {
		return driver.findElement(fnameTxtbox);
	}
	public WebElement LastName() {
		return driver.findElement(lnametxtbox);
	}
	public WebElement Email() {
		return driver.findElement(emailTxtbox);
	}
	public WebElement UserName() {
		return driver.findElement(unameTxtbox);
	}
	public WebElement Save() {
		return driver.findElement(saveBtn);
	}
	public WebElement Error() {
		return driver.findElement(errormsg);
	}
	public WebElement Cancel() {
		return driver.findElement(cancel);
	}
	public void VerifyUser(String expected) {
		String actual = "";
	List<WebElement> list = driver.findElements(users);
	for(int i=1;i<=list.size();i++) {
		actual = driver.findElement(By.xpath("//table[@id='j_id128:users']/tbody/tr["+ i +"]/td[1]/a")).getText();
		if(actual.equals(expected)) {
			System.out.println(">> User Found");
			break;
		}
	}
}
}
