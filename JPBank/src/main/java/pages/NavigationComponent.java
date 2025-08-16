package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationComponent {

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public NavigationComponent(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='/dashboard']")
	private WebElement dashboardBtn;
	
	@FindBy(css="a[href='/transfer']")
	private WebElement tranferBtn;
	
//	@FindBy(css= "li a[href='/transactions']")
	private WebElement transactionBtn;
	
	@FindBy(css ="li a[href='/loan']")
	private WebElement applyLoanBtn;
	
	@FindBy(css ="li a[href='/loan-status']")
	private WebElement loanStatusBtn;
	
	@FindBy(css ="li a[href='/profile']")
	private WebElement profileBtn;
	
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logoutBtn;
	
	
	public void goToDashboard() {
		
		 wait.until(ExpectedConditions.visibilityOf(dashboardBtn)).click();
		System.out.println("Dashboard");
	}
	
	public void goToMoneyTransfer() {
		
		 wait.until(ExpectedConditions.visibilityOf( tranferBtn)).click();
		System.out.println("tranfer");
	}
	
	public void goToApplyLoan() {
		
		 wait.until(ExpectedConditions.visibilityOf(applyLoanBtn)).click();
		System.out.println("applyLoan");
	}
	
	public void goToLoanStatus() {
		 wait.until(ExpectedConditions.visibilityOf(loanStatusBtn)).click();
		System.out.println("loan status");
	}
	
	public void gotoProfile() {
		wait.until(ExpectedConditions.visibilityOf(profileBtn)).click();
		System.out.println("profile");
	}
	
	public void logout() {
		 wait.until(ExpectedConditions.visibilityOf(logoutBtn)).click();
		System.out.println("logout");
	}
	
	public void checkAllNav() {
		
		gotoProfile();
		goToLoanStatus();
		goToApplyLoan();
		goToMoneyTransfer();
		goToDashboard();
		logout();
	}
	
}
