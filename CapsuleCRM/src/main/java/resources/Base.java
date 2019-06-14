package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Testing\\cnu programs\\CapsuleCRM\\src\\main\\java\\resources\\initialData.properties");
		prop.load(fis);
		
		//Browser Setup
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Testing\\software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "D:\\Testing\\software\\IEDriverServer.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Driver Intialization Failed");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	//Opening url
	public void OpenURL() {
		String loginurl = prop.getProperty("url");
		driver.get(loginurl);
	}
	//closing browser
	public void TearDown() {
		driver.quit();
	}

	
}
