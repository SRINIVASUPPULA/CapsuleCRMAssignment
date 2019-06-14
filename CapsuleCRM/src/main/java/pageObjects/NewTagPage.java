package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTagPage {

public WebDriver driver;
	
	By addtagBtn = By.xpath("//*[text()='Add new Tag']");
	By tagname = By.xpath("//input[@name='j_id177:tagNameDecorate:tagName']");
	By saveBtn = By.xpath("//input[@value='Save']");
	By tags = By.xpath("//table[@id='j_id125:tags']/tbody/tr");
	By errormsg = By.xpath("//span[@class='fieldErrorMsg']");
	By cancel = By.xpath("//span[@id='j_id177:editTagButtons']/a");
	
	public NewTagPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement AddTag() {
		return driver.findElement(addtagBtn);
	}
	public WebElement TagName() {
		return driver.findElement(tagname);
	}
	public WebElement SaveTag() {
		return driver.findElement(saveBtn);
	}
	public WebElement Error() {
		return driver.findElement(errormsg);
	}
	public WebElement Cancel() {
		return driver.findElement(cancel);
	}
	
	public void VerifyTag(String expected) {
		String actual = "";
		List<WebElement> list = driver.findElements(tags);
		for(int i=1;i<=list.size();i++) {
			actual = driver.findElement(By.xpath("//table[@id='j_id125:tags']/tbody/tr["+ i +"]/td[1]/span/a")).getText();
			if(actual.equals(expected)) {
				System.out.println(">> Expected Tag Found");
				break;
			}
		}
	}		
}
