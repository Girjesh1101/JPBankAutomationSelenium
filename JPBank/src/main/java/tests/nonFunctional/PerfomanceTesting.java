package tests.nonFunctional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PerfomanceTesting{

	
	@Test(groups = "nonfunctional")
	public void pageLoadTimeSet() {
		
		String url = ConfigReader.getProperty("url");
		
		long startTime = System.currentTimeMillis();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		long finishTime = System.currentTimeMillis();
		long totalTime = finishTime - startTime;
		System.out.println("Page Load Time : "+totalTime+"ms");
		Assert.assertTrue(totalTime < 3000 , "page should load under 3 seconds");
		
	}
}
