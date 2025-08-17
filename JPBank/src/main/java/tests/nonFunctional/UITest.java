package tests.nonFunctional;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class UITest extends TestBase{

	
	@Test(groups = "nonfunctional")
	public void uiTest() {
		
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed(), "verify username should be visble");
		Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(),"verify password should be visible");
		Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(), "verify login button should be visible");
	}
}
