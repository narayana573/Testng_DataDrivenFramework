package org.automation.testing.testcases;

import org.automation.testing.base.DriverInstance;
import org.automation.testing.datagenerator.DataGenerator;
import org.automation.testing.pages.LoginPage;
import org.testng.annotations.Test;

public class TC_002_Register_new_User extends DriverInstance {

    @Test(dataProvider = "Excel", dataProviderClass=DataGenerator.class)
       public void TC_002_Register_new_User(String fname,String lname, String Pnumber) throws  Exception{

        LoginPage login = new LoginPage(driver);
        login.enterFirstName(fname);
        login.enterLastName(lname);
        login.enterMobileNumber(Pnumber);
    }
}
