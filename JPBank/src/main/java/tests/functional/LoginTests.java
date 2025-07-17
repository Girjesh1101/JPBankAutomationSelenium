package tests.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginTests extends TestBase{
	
	@Test(description = "Verify successful login with valid credentials")
	public void testSuccessfulLogin() {
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	}
	
	@Test(description = "Verify login fail with invalid credentials")
	public void testInvalidLogin() {
		
		String username = "raj.sharma@example.com";
		String password = "password";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password", "verify error message should match");

	}

}
