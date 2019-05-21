package org.automation.testing.datagenerator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class DataGenerator {
    @DataProvider(name = "Excel")
    public static Object[][] testDataGeerator(Method med) throws Exception {

        if (med.getName().equalsIgnoreCase("tc_001_login_functionality"))
        {
            FileInputStream file = new FileInputStream(
                    "/home/surya/IdeaProjects/DataDrivenAutomationTestng2/TestData/testdata.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet loginsheet = workbook.getSheet("Login");
            int numberofData = loginsheet.getPhysicalNumberOfRows();
            Object[][] testData = new Object[numberofData][2];

            for (int i = 0; i < numberofData; i++)
            {
                XSSFRow row = loginsheet.getRow(i);
                XSSFCell username = row.getCell(0);
                XSSFCell password = row.getCell(1);
                testData[i][0] = username.getStringCellValue();
                testData[i][1] = password.getStringCellValue();
            }
            return testData;
        }
        else if (med.getName().equalsIgnoreCase("TC_002_Register_new_User"))
        {
            FileInputStream file = new FileInputStream(
                    "/home/surya/IdeaProjects/DataDrivenAutomationTestng2/TestData/testdata.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet loginsheet = workbook.getSheet("Register");
            int numberofData = loginsheet.getPhysicalNumberOfRows();
            Object[][] testData = new Object[numberofData][3];

            for (int i = 0; i < numberofData; i++)
            {
                XSSFRow row = loginsheet.getRow(i);
                XSSFCell firstname = row.getCell(0);
                XSSFCell lastname = row.getCell(1);
                XSSFCell phoneNumber = row.getCell(1);

                testData[i][0] = firstname.getStringCellValue();
                testData[i][1] = lastname.getStringCellValue();
                testData[i][2] = phoneNumber.getStringCellValue();
            }
            return testData;
        }
        else
            {
            Object[][] testData = new Object[2][3];
            return testData;

        }
    }
}


