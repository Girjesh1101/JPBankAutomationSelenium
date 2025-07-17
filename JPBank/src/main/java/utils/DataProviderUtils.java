package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name ="invalidLoginData")
	public static Object[][] getInvalidLoginData(){
		
		return new Object[][] {
			{"", "password123", "Username is required"},
            {"testuser", "", "Password is required"},
            {"invalid", "credentials", "Invalid username or password"},
            {"admin", "wrongpass", "Invalid username or password"}
		};
	}
	
//	@DataProvider(name = "accountData")
//	public static Object[][] getAccountData(){
//		return ExcelReader.getTestData("AccountTestData");
//	}
}
