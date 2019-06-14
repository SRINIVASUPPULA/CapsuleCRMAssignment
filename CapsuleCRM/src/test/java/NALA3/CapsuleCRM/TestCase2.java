package NALA3.CapsuleCRM;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountSettingsPage;
import pageObjects.NewUserPage;
import pageObjects.AppearancePage;
import pageObjects.CRMHomePage;
import pageObjects.CRMLoginPage;
import pageObjects.NewMilestonePage;
import pageObjects.NewTagPage;
import pageObjects.NewTracksPage;
import resources.Base;

public class TestCase2 extends Base {
	CRMHomePage home;
	AccountSettingsPage asp;
	//code successfully pushed to git - correction verification

	// Browser initialization and successful login to CRM Homepage
	@BeforeTest
	public void CRMLogin() throws IOException, InterruptedException {

		driver = initializeDriver();
		OpenURL();
		//driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		CRMLoginPage login = new CRMLoginPage(driver);
		login.UserName().sendKeys(uname);
		login.Password().sendKeys(pwd);
		login.CRMLogin().click();
	}
	// opening Account settings and validating each link
	@Test
	public void AccountSettingsTests() throws InterruptedException {
		home = new CRMHomePage(driver);
		home.profile().click();
		home.settings().click();
		asp = new AccountSettingsPage(driver);

		List<WebElement> panelLinks = asp.leftPanel();
		int size = panelLinks.size();
		for (int i = 0; i < size; i++) {
			panelLinks = asp.leftPanel();
			panelLinks.get(i).click();
			// Printing each link's header
			String linktext = asp.Title().getText();
			System.out.println(linktext);

			if (linktext.equals("Appearance")) {
				// Changing logo image - image path should be changed
				AppearancePage ap = new AppearancePage(driver);
				ap.AddLogo().sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\brahmi.jpg");
				
				try {
					ap.SaveLogo().click();
				if (ap.Error().isDisplayed()) {
					System.out.println(">> Logo not changed: " + ap.Error().getText()); 	}
				} 
				catch(Exception e) {
					System.out.println(">> Logo changed successfully");
				} 
			
			} else if (linktext.equals("Users")) {
				// Adding New User and validating UserName
				NewUserPage anu = new NewUserPage(driver);
				anu.AddUser().click();
				anu.FirstName().sendKeys("Michael");
				anu.LastName().sendKeys("Hawk");
				anu.Email().sendKeys("hawk@technoburst.com");
				anu.UserName().sendKeys("MichaelHawk");
				try {
					anu.Save().click();
					}
				catch(Exception e) {
					if(anu.Error().isDisplayed()) {
						System.out.println(">> "+anu.Error().getText());
						anu.Cancel().click();
					}
				}
				String expected = "Michael Hawk";
				anu.VerifyUser(expected); 
				
			} else if (linktext.equals("Opportunities")) {
				// Adding New Milestone and Validating it
				NewMilestonePage nmp = new NewMilestonePage(driver);
				String expected = "Dev5";
				nmp.NewMile().click();
				nmp.MileName().sendKeys(expected);
				nmp.MileDescription().sendKeys("Needs to complete Dev5 tasks within time");
				nmp.Probability().sendKeys("23");
				nmp.MileDeadline().sendKeys("8");
				try {
				nmp.SaveMilestone().click();
				}
				catch(Exception e) {
					if(nmp.Error().isDisplayed()){
						System.out.println(nmp.Error().getText());
				}
					nmp.Cancel().click();
				}	
				nmp.VerifyMilestone(expected);
			
			} else if (linktext.equals("Tracks")) {
				// Adding New Track and Validating
				NewTracksPage ntp = new NewTracksPage(driver);
				ntp.NewTrack().click();
				String expected = "TrackDev";
				ntp.TrackName().sendKeys(expected);
				ntp.TrackTag().sendKeys("Dev");
				ntp.TaskDescription().sendKeys("New Track created for Dev Task");
				ntp.DueDays().sendKeys("12");
				ntp.SaveTrack().click();
				ntp.VerifyTrack(expected);
				
			} else if (linktext.equals("Tags and DataTags")) {
				// Adding New Tag and validating it ---- Duplicate Tag names are not allowed
				NewTagPage ntp = new NewTagPage(driver);
				ntp.AddTag().click();
				String expected = "QA";
				try {
					ntp.TagName().sendKeys(expected);
				} catch (StaleElementReferenceException e) {
					WebElement elt = ntp.TagName();
					elt.sendKeys("QA");
				}
					try{
					ntp.SaveTag().click();
					}
					catch(Exception e) {
						if(ntp.Error().isDisplayed()) {
							System.out.println(ntp.Error().getText());
						}
						ntp.Cancel().click();
					}
				ntp.VerifyTag(expected);
				
			} else if (linktext.equals("Integrations")) {
				// printing no. of Configure buttons
				System.out.println(
						"No of Configure buttons: " + driver.findElements(By.xpath("//a[text()='Configure']")).size());
			}
		}
	}

	// closing the browser windows
	@AfterTest
	public void tearDown() {
		// TearDown();
	}

}