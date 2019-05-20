package org.automation.testing.testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.testing.base.DriverInstance;
import org.automation.testing.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidateLoginFunctionality extends DriverInstance {

	@Test(dataProvider = "Excel")
	public void tc_001_login_functionality(String uname, String pass) throws Exception {

		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSignin();
	}

	@DataProvider(name = "Excel")
	public Object[][] testDataGeerator() throws Exception {

		FileInputStream file = new FileInputStream(
				"/home/surya/IdeaProjects/DataDrivenAutomationTestng2/TestData/testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginsheet = workbook.getSheet("Login");
		int numberofData = loginsheet.getPhysicalNumberOfRows();
		Object[][] testData = new Object[numberofData][2];

		for (int i = 0; i < numberofData; i++) {
			XSSFRow row = loginsheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = username.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
		}
		return testData;

	}

}
