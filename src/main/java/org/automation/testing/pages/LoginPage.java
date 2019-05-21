package org.automation.testing.pages;

import org.automation.testing.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String uname) throws Exception {
		driver.findElement(By.id(Utility.fetchProperityValue("login_username_id", "Elements.properties")))
				.sendKeys(uname);
	}

	public void enterPassword(String pass) throws Exception {
		driver.findElement(By.id(Utility.fetchProperityValue("login_password_id", "Elements.properties")))
				.sendKeys(pass);
	}

	public void clickSignin() throws Exception {

		driver.findElement(By.xpath(Utility.fetchProperityValue("login_sigin_xpath", "Elements.properties"))).click();
	}

	public void enterFirstName(String firstname) throws Exception {
		driver.findElement(By.name(Utility.fetchProperityValue("login_firstname_name", "Elements.properties")))
				.sendKeys(firstname);
	}

	public void enterLastName(String lastname) throws Exception {
		driver.findElement(By.name(Utility.fetchProperityValue("login_lastname_name", "Elements.properties")))
				.sendKeys(lastname);
	}

	public void enterMobileNumber(String mobilenumber) throws Exception {
		driver.findElement(By.xpath(Utility.fetchProperityValue("login_mobilenumber_xpath", "Elements.properties")))
				.sendKeys(mobilenumber);
	}

}
