package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NALA3.CapsuleCRM.ExcelData;

public class CasesPage extends ExcelData{
	public WebDriver driver;
	
	By addCase = By.xpath("//a[text()='Add Case']");
	
	By searchTxtbox = By.id("partySearch");
	By nameTxtbox = By.id("caseNameDecorate:name");
	By descTxtArea = By.id("caseDescriptionDecorate:description");
	By tagCombobox = By.id("tagsDecorate:tagComboBox");
	By addTagBtn = By.id("tagsDecorate:j_id191");
	By saveBtn = By.id("save");
	
	public CasesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement AddCaseLink() {
		return driver.findElement(addCase);
	}
	public WebElement search() {
		return driver.findElement(searchTxtbox);
	}
	public WebElement name() {
		return driver.findElement(nameTxtbox);
	}
	public WebElement description() {
		return driver.findElement(descTxtArea);
	}
	public WebElement selectTag() {
		return driver.findElement(tagCombobox);
	}
	public WebElement addTag(){
		return driver.findElement(addTagBtn);
	}
	public WebElement save() {
		return driver.findElement(saveBtn);
	}
}
 