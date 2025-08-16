package tests.functional;

import org.testng.annotations.Test;

import base.TestBase;
import pages.ProfilePage;

public class ProfileTest extends TestBase {

	
	@Test(description = "verify profile has all customer details")
	public void verifyProfile() {
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.getAllProfileDetails();
	}
}
