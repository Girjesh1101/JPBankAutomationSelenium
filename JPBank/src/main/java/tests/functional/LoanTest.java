package tests.functional;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.TestBase;
import pages.ApplyLoanPage;
import pages.NavigationComponent;

public class LoanTest extends TestBase{
	
	@Test
	public void applyloanSuccessfully() throws InterruptedException {
		
		Faker faker = new Faker();
		
		String amount = faker.number().digits(5);
		String months = faker.number().digits(2);
		String income = faker.number().digits(4);
		String pan = "ABCDE1234F";
		String loanType = "home";
		
		
		ApplyLoanPage applyLoanPage = new ApplyLoanPage(driver);
		NavigationComponent navObj = new NavigationComponent(driver);
		navObj.goToApplyLoan();
		
		applyLoanPage.applyloanForm(loanType, amount, months, income, pan);
		applyLoanPage.confirmLoanDetails(loanType);
		
	}

}
