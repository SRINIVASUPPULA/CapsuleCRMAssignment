package NALA3.CapsuleCRM;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CRMHomePage;
import pageObjects.CRMLoginPage;
import pageObjects.CasesPage;
import pageObjects.PeopleOrgsPage;
import resources.Base;

public class TestCase1 extends Base {
	PeopleOrgsPage ppl;
	CRMHomePage home;

	@BeforeClass
	public void CRMLogin() throws IOException, InterruptedException {
		//Initializing Webdriver and passing valid login details from properties file
		driver = initializeDriver();
		OpenURL();

		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		CRMLoginPage login = new CRMLoginPage(driver);
		login.UserName().sendKeys(uname);
		login.Password().sendKeys(pwd);
		login.CRMLogin().click();
	}

	//Adding New person's data from Excel file
	@Test(dataProvider = "Add Person", priority = 1)
	public void AddPeople(String title, String fname, String lname, String jobtitle, String organisation, String tag,
			String phone, String email) throws InterruptedException {
		home = new CRMHomePage(driver);
		home.people().click();
		ppl = new PeopleOrgsPage(driver);
		ppl.AddPeopleLink().click();

		Select prsntitle = new Select(ppl.titleDropdown());
		prsntitle.selectByValue(title);
		ppl.FnameTxtbox().sendKeys(fname);
		ppl.LnameTxtbox().sendKeys(lname);
		ppl.jobTxtbox().sendKeys(jobtitle);
		ppl.orgTxtbox().sendKeys(organisation);
		ppl.tagTxtbox().sendKeys(tag);
		ppl.tagBtn().click();
		Thread.sleep(1000);
		ppl.phoneTxtbox().sendKeys(phone);
		ppl.emailTxtbox().sendKeys(email);
		ppl.saveBtn().click();

	}
	@DataProvider(name = "Add Person")
	public Object[][] getData2() throws IOException {
		ExcelData data = new ExcelData();
		Object[][] personDetails = data.getData("Add Person");
		return personDetails;
	}
 
	//Adding New Case details - from excel file
	@Test(dataProvider = "Add Case", priority = 2)
	public void AddCase(String search, String name, String desc, String tag) throws InterruptedException {
		home = new CRMHomePage(driver);
		home.cases().click();
		CasesPage cp = new CasesPage(driver);
		cp.AddCaseLink().click();
		cp.search().sendKeys(search);
		// Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@class='ac_input ac_loading']")));
		cp.search().sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.TAB));
		cp.name().sendKeys(name);
		cp.description().sendKeys(desc);
		cp.selectTag().sendKeys(tag);
		cp.addTag().click();
		cp.save().click();
		if (driver.getCurrentUrl().contains("/cases")) {
			String link = search + ", " + name;
			driver.findElement(By.linkText(link)).click();
			validatingCase(search);
		} else {
			validatingCase(search);
		}
	}

	@DataProvider(name = "Add Case")
	public Object[][] getData3() throws IOException {
		ExcelData data = new ExcelData();
		Object[][] caseDetails = data.getData("Add Case");
		return caseDetails;
	}

	//closing the browser windows
	@AfterClass
	public void tearDown() {
		TearDown();
	}
	
	//validating the case status
	public void validatingCase(String search) {
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[@class='entity-details-subtitle']//*[@class='ember-view']")).getText(),
				search);
		Assert.assertEquals(driver.findElement(By.className("kase-summary-status-open")).getText(), "Open");
	}

}