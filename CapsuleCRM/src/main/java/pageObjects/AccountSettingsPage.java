package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSettingsPage {

	public WebDriver driver;

	By leftpanel = By.xpath("//ul[@class='nav-panel']/li | //ul[@class='settings-nav']/li");
	By header = By.xpath("//header[@class='page-box-header'] | //*[@class='settings-page-header']");

	public AccountSettingsPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> leftPanel() {
		return driver.findElements(leftpanel);
	}

	public WebElement Title() {
		return driver.findElement(header);
	}

}
