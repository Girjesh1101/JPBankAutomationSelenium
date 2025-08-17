package tests.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.TestBase;
import pages.LoginPage;
import pages.MoneyTransferPage;
import pages.NavigationComponent;

public class MoneyTransferTest extends TestBase{
	
	Faker faker ;

	@Test(description = "UPI Transfer")
	public void moneyTransferSuccessfullyByUPI() throws InterruptedException {
		
		faker = new Faker();
		
		String upiId = faker.name().username()+"@upi";
		String amount = faker.number().digits(4);
		String des = "Testing";
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
		
		String[] verify = {"blank",upiId,amount , des};
		
		NavigationComponent navObj = new NavigationComponent(driver);
		MoneyTransferPage transObj = new MoneyTransferPage(driver);
		navObj.goToMoneyTransfer();
		transObj.upiDetails(upiId, amount, des);
		Thread.sleep(2000);
		transObj.verificationUPI(verify);
		transObj.confirmTransfer();
		
		Thread.sleep(30000);
		
	}
	
	@Test(description = "Account Transfer")
	public void accountTransfer() throws InterruptedException {
		
		faker = new Faker();
		String accNo = faker.number().digits(12);
		String ifsc = "SBIN000"+faker.number().digits(4);
		String name = faker.name().firstName();
		String amount = faker.number().digits(4);
		String des = "Testing";
		String type = "IMPS";
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
		
		String verify[] = {"blank",accNo,ifsc ,name ,amount ,des , type};
		
		NavigationComponent navObj = new NavigationComponent(driver);
		MoneyTransferPage transObj = new MoneyTransferPage(driver);
		navObj.goToMoneyTransfer();
		transObj.accountTransfer(accNo, ifsc, name, type, amount, des);
		Thread.sleep(2000);
		transObj.verificationUPI(verify);
		transObj.confirmTransfer();
		Thread.sleep(30000);
	}
	
	@Test(description = "Account Transfer")
	public void selectTransferByUser() throws InterruptedException {
		
		faker = new Faker();
		String upiId = faker.name().username()+"@upi";
		String accNo = faker.number().digits(12);
		String ifsc = "SBIN000"+faker.number().digits(4);
		String name = faker.name().firstName();
		String amount = faker.number().digits(4);
		String des = "Testing";
		String type = "IMPS";
		String TransferWay = "account transfer";
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
		
		
		NavigationComponent navObj = new NavigationComponent(driver);
		MoneyTransferPage transObj = new MoneyTransferPage(driver);
		navObj.goToMoneyTransfer();
		transObj.TransferMoney(TransferWay, upiId, amount, des, accNo, ifsc, name, type);
		
		Thread.sleep(30000);
	}
	
}
