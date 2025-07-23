package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@FindBy(id="email")
	private WebElement usernameInput;
	
	@FindBy(id ="password")
	private WebElement passwordInput;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(css = "div[role=\"alert\"]")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		System.out.println("Initialzing loginPage with driver "+driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {

		wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
	}
	
	public void clickLogin() {
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
	}
	
	public String getErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
	}
	
	public String getTitle() {
		
		return driver.getTitle();
	}
	
	public void login(String username , String password) {
		
		System.out.println("userfiled"+usernameInput);
		
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}
