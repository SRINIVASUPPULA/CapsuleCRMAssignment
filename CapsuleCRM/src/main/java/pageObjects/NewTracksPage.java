package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTracksPage {

public WebDriver driver;
	
	By newtrackBtn = By.xpath("//*[text()='Add new Track']");
	By trackname = By.xpath("//input[@id='j_id123:trackDescriptionDecorate:trackDescription']");
	By tracktag = By.xpath("//input[@id='j_id123:trackTagDecorate:trackTag']");
	By taskdesc = By.xpath("//input[@id='j_id123:taskLines:0:taskDescriptionDecorate:taskDescription']");
	By duedays = By.xpath("//input[@id='j_id123:taskLines:0:taskDaysAfterDecorate:taskDaysAfter']");
	By saveBtn = By.xpath("//a[text()='Save']");
	By tracks = By.xpath("//table[@id='taskgroups:searchresults']/tbody/tr");
	
	public NewTracksPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement NewTrack() {
		return driver.findElement(newtrackBtn);
	}
	public WebElement TrackName() {
		return driver.findElement(trackname);
	}
	public WebElement TrackTag() {
		return driver.findElement(tracktag);
	}
	public WebElement TaskDescription() {
		return driver.findElement(taskdesc);
	}
	public WebElement DueDays() {
		return driver.findElement(duedays);
	}
	public WebElement SaveTrack() {
		return driver.findElement(saveBtn);
	}
	public void VerifyTrack(String expected) {
		String actual = "";
		List<WebElement> list = driver.findElements(tracks);
		for(int i=1;i<=list.size();i++) {
			actual = driver.findElement(By.xpath("//table[@id='taskgroups:searchresults']/tbody/tr["+ i +"]/td[1]/a")).getText();
			if(actual.equals(expected)) {
				System.out.println(">> Expected Track Found");
				break;
			}
		}
	}
}
