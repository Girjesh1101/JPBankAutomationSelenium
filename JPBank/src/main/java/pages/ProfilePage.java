package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class ProfilePage {
	
	private WebDriver driver;
	
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='space-y-6']/div/div[2]/div/div/div")
	List<WebElement> profileDetails;
	
	public void getAllProfileDetails() {
		
		int count = profileDetails.size();
		
		for(int i = 0; i< count-1 ; i++) {
			
//			System.out.println("Profile Details : "+ wait.until(ExpectedConditions.visibilityOf(profileDetails)).get(i).getText());
			System.out.println("Profile Details : "+ profileDetails.get(i).getText());
		
		}
	}

}
