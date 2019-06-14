package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NALA3.CapsuleCRM.ExcelData;

public class PeopleOrgsPage extends ExcelData {

public WebDriver driver;
	
	By addPersonBtn = By.xpath("//a[text()='Add Person']");
	By title = By.name("party:j_id108:j_id116");
	By fname = By.name("party:fnDecorate:fn");
	By lname = By.name("party:lnDecorate:ln");
	By jobTitle = By.name("party:roleDecorate:jobTitle");
	By organisation = By.name("party:orgDecorate:org");
	By tag = By.name("party:tagsDecorate:tagComboBox");
	By addTag = By.name("party:tagsDecorate:j_id187");
	By phone = By.name("party:j_id325:0:phnDecorate:number");
	By email = By.name("party:j_id342:0:emlDecorate:nmbr");
	By save = By.name("party:save");
	
	
	public PeopleOrgsPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement AddPeopleLink() {
		return driver.findElement(addPersonBtn);
	}
	public WebElement titleDropdown() {
		return driver.findElement(title);
	}
	public WebElement FnameTxtbox() {
		return driver.findElement(fname);
	}
	public WebElement LnameTxtbox() {
		return driver.findElement(lname);
	}
	public WebElement jobTxtbox() {
		return driver.findElement(jobTitle);
	}
	public WebElement orgTxtbox() {
		return driver.findElement(organisation);
	}
	public WebElement tagTxtbox() {
		return driver.findElement(tag);
	}
	public WebElement tagBtn() {
		return driver.findElement(addTag);
	}
	public WebElement phoneTxtbox() {
		return driver.findElement(phone);
	}
	public WebElement emailTxtbox() {
		return driver.findElement(email);
	}
	public WebElement saveBtn() {
		return driver.findElement(save);
	}
	
	
}
