package pages;

import java.lang.module.FindException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MoneyTransferPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public MoneyTransferPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "upiId")
	private WebElement uipIdInput;
	
	@FindBy(id =  "amount")
	private WebElement amountInput;
	
	@FindBy(id ="description")
	private WebElement descInput;
	
//	@FindBy(xpath = "//button[@id='radix-:r32:-trigger-upi']")
	@FindBy(xpath ="//button[text()='UPI Transfer']")
	private WebElement upiBtn;
	
//	@FindBy(xpath = "//button[@id='radix-:r32:-trigger-account']")
	@FindBy(xpath = "//button[text()='Account Transfer']")
	private WebElement accountTransfer;
	
	@FindBy(id = "accountNumber")
	private WebElement accountNoInput;
	
	@FindBy(id = "ifscCode")
	private WebElement ifscInput;
	
	@FindBy(name ="name")
	private WebElement recipientNameInput;
	
	@FindBy(xpath = "//div[@class='space-y-2']/select")
	private WebElement transferType;
	
	@FindBy(id = "upi-continue-button")
	private WebElement upiContinue;
	
	@FindBy(id = "account-continue-button")
	private WebElement accountContinue;
	
	public void upi() {
		wait.until(ExpectedConditions.visibilityOf(upiBtn));
		upiBtn.click();
	}
	
	public void accountTransferButton() {
		wait.until(ExpectedConditions.visibilityOf(accountTransfer));
		accountTransfer.click();
	}
	
	
	public void enterUPI(String upi) {
		
		wait.until(ExpectedConditions.visibilityOf(uipIdInput));
		uipIdInput.sendKeys(upi);
	}
	
	public void enterAmount(String amount) {
		
		wait.until(ExpectedConditions.visibilityOf(amountInput));
		amountInput.sendKeys(amount);
	}
	
	public void enterDescription(String desc) {
		wait.until(ExpectedConditions.visibilityOf(descInput));
		descInput.sendKeys(desc);
		
	}
	
	public void upiContinue() {
		
		wait.until(ExpectedConditions.visibilityOf(upiContinue));
		upiContinue.click();
	}
	
	public void accountContinue() {
		
		wait.until(ExpectedConditions.visibilityOf(accountContinue));
		accountContinue.click();
	}
	
	public void accountNumber(String accNo) {
		wait.until(ExpectedConditions.visibilityOf(accountNoInput));
		accountNoInput.sendKeys(accNo);
	}
	
	public void ifscCode(String ifsc) {
		wait.until(ExpectedConditions.visibilityOf(ifscInput));
		ifscInput.sendKeys(ifsc);
	}
	
	public void recipientName(String name) {
		wait.until(ExpectedConditions.visibilityOf(recipientNameInput));
		recipientNameInput.sendKeys(name);
	}
	public void selectTransferType(String type) {
		
		wait.until(ExpectedConditions.visibilityOf(transferType));
		Select select = new Select(transferType);
		select.selectByValue(type.toUpperCase());
	}
	
	
	public void upiDetails(String upiID , String amount , String des) {
		
		upi();
		enterUPI(upiID);
		enterAmount(amount);
		enterDescription(des);
		upiContinue();
	}
	
	public void accountTransfer(String accNo , String ifsc , String name , String type , String amount ,String desc) {
		
		accountTransferButton();
		accountNumber(accNo);
		ifscCode(ifsc);
		recipientName(name);
		selectTransferType(type);
		enterAmount(amount);
		enterDescription(desc);
		accountContinue();
	}
	
	public void TransferMoney(String way , String upiID , String amount , String des , String accNo , String ifsc , String name , String type ) {
		
		if(way.equalsIgnoreCase("upi")) {
			System.out.println("UPI Transfer");
			upiDetails(upiID, amount, des);
			
		}else if(way.equalsIgnoreCase("account transfer")) {
			System.out.println("Account Transfer");
			accountTransfer(accNo,ifsc, name , type , amount , des);
		}else {
			
			System.out.println("you can either transfer money by UPI and Account Transfer");
		}
		
	}
	
	@FindBy(xpath = "//span[@class='font-semibold']")
	private List< WebElement > details;
	
	@FindBy(xpath ="//button[text()='Confirm Transfer']")
	private WebElement confirmTransferBtn;
	
	public void confirmTransfer() {
		
		wait.until(ExpectedConditions.visibilityOf(confirmTransferBtn));
		confirmTransferBtn.click();
	}
	
	public void verificationUPI(String []str) {
		
		
		for(int i = 1 ; i<= details.size(); i++) {
			
			String contain = details.get(i).getText();
			System.out.println(contain);
			System.out.println("Str : "+str[i]);
			
			Assert.assertEquals(contain, str[i]);
		}
		
		// need to to remove rupee special case and .00 and will do it 
		
	}
	
	
	
	
	

}
