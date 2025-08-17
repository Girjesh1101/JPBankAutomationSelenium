package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		PageFactory.initElements(driver, this);
	}
	
	//Page Elements
	
	@FindBy(css = "header div a")
	private WebElement bankName;
	
	@FindBy(css = "p[class='font-semibold']")
	private List< WebElement > accountItem;
	
	@FindBy(css = "p[class=\"text-2xl font-bold text-bank-primary\"]")
	private WebElement accountBalanceLbl;
	
	@FindBy(xpath = "//h3[text()='Recent Transactions']")
	private WebElement recentTransaction;
	
	@FindBy(xpath = "(//div[@class='space-y-4'])[2]/div[1]/p[2]")
	public WebElement lblAvailableBalance;
	
	public int getAccountCount() {
		
		System.out.println("Size:"+accountItem.size());
		return accountItem.size();
	}
	
	public String getAccountHolderName(int idx) {
		
		return accountItem.get(idx).getText();
	}
	
	public String getAccountNumber(int idx) {
		
		return accountItem.get(idx).getText(); 
	}
	
	public String getIFSCCode(int idx) {
		return accountItem.get(idx).getText();
	}
	
	public String getUPI(int idx) {
		return accountItem.get(idx).getText();
	}
	
	
	public String displayBalance() {
		
		wait.until(ExpectedConditions.visibilityOf(lblAvailableBalance));
		System.out.println(lblAvailableBalance.getText());
		
		return lblAvailableBalance.getText();
	}
	
	public void verifiyAccountDetails() {
		
		int totalItem = getAccountCount();
	
		for(int i = 0 ; i < totalItem ; i++) {
			
			switch (i) {
			case 0:
//				getAccountHolderName(i);
				System.out.println("Name: "+getAccountHolderName(0));
				break;
			case 1:
//				getAccountNumber(2);
				System.out.println("Account Number: "+getAccountNumber(1));
				break;
			case 2:
//				getIFSCCode(3);
				System.out.println("IFSC: "+getIFSCCode(2));
				break;
			case 3: 
//				getUPI(4);
				System.out.println("UPI: "+getUPI(3));
				break;
			default:
				System.out.println("Not found ");
				break;
			}
		}
	
	}
	
	public void recentTransactionVisible() {
		
		System.out.println("Recent  Transaction :"+wait.until(ExpectedConditions.visibilityOf(recentTransaction)).getText());
		System.out.println("Recent  Transaction :"+recentTransaction.isDisplayed());
		
	}

}
