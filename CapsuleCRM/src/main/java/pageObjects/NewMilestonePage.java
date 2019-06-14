package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewMilestonePage {

public WebDriver driver;
	
	By newmileBtn = By.xpath("//*[text()='Add new Milestone']");
	By milename = By.xpath("//input[@class='form-input-text milestone-modal-name']");
	By miledesc = By.xpath("//textarea[@class='form-input-text milestone-modal-description']");
	By prob = By.xpath("//input[@class='form-input-text milestone-modal-probability']");
	By days = By.xpath("//input[@class='form-input-text milestone-modal-days-until-stale']");
	By saveBtn =By.xpath("//button[text()='Save']");
	By milestones = By.xpath("//table[@class='record-list']/tbody/tr/td[1]/button");
	By errormsg = By.xpath("//div[@class='modal-dialog-content']//descendant::div[@class='flash-message-body']");
	By cancel = By.xpath("//div[@class='form-actions']/button[2]");
	
	public NewMilestonePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement NewMile() {
		return driver.findElement(newmileBtn);
	}
	public WebElement MileName() {
		return driver.findElement(milename);
	}
	public WebElement MileDescription() {
		return driver.findElement(miledesc);
	}
	public WebElement Probability() {
		return driver.findElement(prob);
	}
	public WebElement MileDeadline() {
		return driver.findElement(days);
	}
	public WebElement SaveMilestone() {
		return driver.findElement(saveBtn);
	}
	public WebElement Error() {
		return driver.findElement(errormsg);
	}
	public WebElement Cancel() {
		return driver.findElement(cancel);
	}
	public void VerifyMilestone(String expected) {
		String actual = "";
		
		List<WebElement> list = driver.findElements(milestones);
		for(int i=1;i<=list.size();i++) {
			actual = driver.findElement(By.xpath("//table[@class='record-list']/tbody/tr["+ i +"]/td[1]/button")).getText();
			if(actual.equals(expected)) {
				System.out.println(">> Milestone Found");
				break;
			}
			
		}
	}
}
