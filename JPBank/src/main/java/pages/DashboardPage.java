package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	//Page Elements
	
	@FindBy(css = "header div a")
	private WebElement bankName;
	
	@FindBy()
	private WebElement nameLbl;
	
	@FindBy()
	private WebElement accountBalanceLbl;
	
	@
	

}
