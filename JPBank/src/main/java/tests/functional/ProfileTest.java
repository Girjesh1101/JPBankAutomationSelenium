package tests.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest extends TestBase {

	
	@Test(description = "verify profile has all customer details")
	public void verifyProfile() {
		
		String username = "raj.sharma@example.com";
		String password = "password123";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getTitle(), "bank-test-simulator-app" , "Verify title of the login page");
	
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.getAllProfileDetails();
	}
}
