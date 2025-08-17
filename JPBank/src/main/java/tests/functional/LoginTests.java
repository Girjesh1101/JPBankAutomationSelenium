package tests.functional;



import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NavigationComponent;
import utils.DataProviderUtils;

public class LoginTests extends TestBase {
	
	

	@Test(description = "Verify successful login with valid credentials")
	public void testSuccessfulLogin() {
		
		
		String username = ConfigReader.getProperty("validusername");
		String password = ConfigReader.getProperty("validpassword");
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
	}
	
	
	@Test(description = "Verify login fail with invalid credentials"  , dataProvider = "invalidLoginData" , dataProviderClass = DataProviderUtils.class)
	public void testInvalidLogin(String username , String password, String message) {
		

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password", "verify error message should match");

	}
	
	@Test(description = "Verify dashboard")
	public void verifyDashboard() {
		
		String username = ConfigReader.getProperty("validusername");
		String password = ConfigReader.getProperty("validpassword");
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.verifiyAccountDetails();
		dashboardPage.recentTransactionVisible();
	}

	@Test(description = "Verify All Negivation")
	public void verifAllNavigation() {
		
		String username = ConfigReader.getProperty("validusername");
		String password = ConfigReader.getProperty("validpassword");
		
		
		LoginPage loginPage = new LoginPage(driver);
		NavigationComponent navPage = new NavigationComponent(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
		navPage.checkAllNav();
	}
	
}
