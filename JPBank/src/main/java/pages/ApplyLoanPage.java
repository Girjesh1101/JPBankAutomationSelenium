package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyLoanPage {
	
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public ApplyLoanPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "select")
	private WebElement loanTypeSelect;
	
	@FindBy(name = "amount")
	private WebElement loanAmountInput;
	
	@FindBy(id ="tenure")
	private WebElement tenureInput;
	
	@FindBy(id ="income")
	private WebElement incomeInput;
	
	@FindBy(id ="panNumber")
	private WebElement panInput;
	
	@FindBy(id ="loan-continue-button")
	private WebElement continueBtn;
	
	@FindBy(xpath ="// span[@class='font-semibold']")
	List<WebElement> details;
	
	@FindBy(xpath = "//button[text()='Submit Application']")
	private WebElement submitAppButton;
	
	
	public void selectLoanType(String loanType) {
		
		wait.until(ExpectedConditions.visibilityOf(loanTypeSelect));
		Select select = new Select(loanTypeSelect);
		select.selectByValue(loanType.toLowerCase());
		
	}
	
	public void inputLoanAmount(String amount) {
		
		wait.until(ExpectedConditions.visibilityOf(loanAmountInput));
		loanAmountInput.sendKeys(amount);
	}
	
	public void loanTenure(String months) {
		
		wait.until(ExpectedConditions.visibilityOf(tenureInput));
		tenureInput.sendKeys(months);
	}
	
	public void inputAnnualIncome(String income) {
		wait.until(ExpectedConditions.visibilityOf(incomeInput));
		incomeInput.sendKeys(income);
	}
	
	public void inputPAN(String pan) {
		
		wait.until(ExpectedConditions.visibilityOf(panInput));
		panInput.sendKeys(pan);
		
	}
	
	public void continueButton() {
		
		wait.until(ExpectedConditions.visibilityOf(continueBtn));
		continueBtn.click();
	}
	
	public void submitApplication() {
		
		wait.until(ExpectedConditions.visibilityOf(submitAppButton)).click();
	}
	
	public void applyloanForm(String loanType, String amount , String month , String income , String pan) throws InterruptedException {
		
		System.out.println("inside the loan form");
		
		
		Thread.sleep(1000);
		inputLoanAmount(amount);
		Thread.sleep(1000);
		loanTenure(month);
		Thread.sleep(1000);
		inputAnnualIncome(income);
		Thread.sleep(1000);
		inputPAN(pan);
		Thread.sleep(1000);
		selectLoanType(loanType);
		System.out.println("loan type : "+ loanType );
		continueButton();
		
	}
	
	
	public void confirmLoanDetails(String loanT) {
		
		for(int i = 0; i <= details.size(); i++) {
			
			System.out.println(details.get(i).getText());
			
		}
		
//		Home Loan
//		₹41,945.00
//		57 months
//		₹4,225.00
//		ABCDE1234F
//		6.5% - 9%
		// will write code for validation 
		
		submitApplication();
		
	}
	

	
	
	

}
