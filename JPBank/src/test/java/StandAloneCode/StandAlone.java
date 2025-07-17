package StandAloneCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) {
		
		String url = "https://jpgormanbank.lovable.app/login";
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
		
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println("title:"+ title);
		
		Assert.assertEquals(title, "bank-test-simulator-app", "verify title of home page");
		
		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys(username);
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		
		WebElement signBtn = driver.findElement(By.id("login-button"));
		signBtn.click();
		
		
		
		Thread.sleep(30000);
		
		
		
		} catch (Exception e) {
			System.out.println("error:"+e.getMessage());
		}
		
		driver.close();
		
	}
}
