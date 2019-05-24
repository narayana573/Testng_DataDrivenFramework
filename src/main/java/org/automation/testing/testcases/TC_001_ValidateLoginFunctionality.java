package org.automation.testing.testcases;


import org.automation.testing.base.DriverInstance;
import org.automation.testing.datagenerator.DataGenerator;
import org.automation.testing.pages.LoginPage;
import org.testng.annotations.Test;

public class TC_001_ValidateLoginFunctionality extends DriverInstance {

	@Test(dataProvider = "Excel", dataProviderClass=DataGenerator.class)
	public void tc_001_login_functionality(String uname, String pass) throws Exception {

		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSignin();
		System.out.println("Test Case 1 is Passed Successfully");
	}



}
