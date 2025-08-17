package base;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class TestBase {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	String url = ConfigReader.getProperty("url");
	
	public TestBase(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public TestBase() {
		// TODO Auto-generated constructor stub
	}


	@BeforeMethod
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		
		System.out.println("inside BeforeMethod");
		System.out.println("Setting up test for browser: "+browser);
		
		switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
				
//				Note : you cannot directly use safari
//				Open Safari → Preferences → Advanced → Enable "Show Develop menu"
//				Then Develop → Allow Remote Automation.
				
				
		default:
			throw new IllegalArgumentException("Unspported browser: "+browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(url);
		
	}
	
	@AfterMethod
	public void tesrDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	
}
