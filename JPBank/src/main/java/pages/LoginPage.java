package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="username")
	private WebElement usernameInput;
	
	@FindBy(id ="password")
	private WebElement passwordInput;
	
	@FindBy(id="loginbutton")
	private WebElement loginButton;
	
	@FindBy(css = "div[role=\"alert\"]")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		super();
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
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}
