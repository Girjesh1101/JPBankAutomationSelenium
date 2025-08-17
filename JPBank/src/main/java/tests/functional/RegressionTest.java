package tests.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.TestBase;
import pages.ApplyLoanPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NavigationComponent;

public class RegressionTest  extends TestBase{

	@Test(priority = 1, groups = "regression")
	public void validLogin() {
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
	}
	
	@Test(groups = "regression")
	public void laonApply() throws InterruptedException {
		
		Faker faker = new Faker();
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		String amount = faker.number().digits(5);
		String months = faker.number().digits(2);
		String income = faker.number().digits(4);
		String pan = "ABCDE1234F";
		String loanType = "home";
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		ApplyLoanPage loanObj = new ApplyLoanPage(driver);
		NavigationComponent navObj = new NavigationComponent(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
		navObj.goToApplyLoan();
		loanObj.applyloanForm(loanType, amount, months, income, pan);
		loanObj.confirmLoanDetails(loanType);
		
		
	}
	
	@Test(priority = 2, groups = "regression" , dependsOnMethods = "validLogin")
	public void checkBalance() {
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		DashboardPage dashboardObj = new DashboardPage(driver);
		String balance = dashboardObj.displayBalance();
		System.out.println(balance);
		Assert.assertTrue(dashboardObj.lblAvailableBalance.isDisplayed(), "Verify Balance Should be visible");
		
	}
}
