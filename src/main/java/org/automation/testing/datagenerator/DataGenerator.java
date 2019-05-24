package org.automation.testing.datagenerator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class DataGenerator {
    @DataProvider(name = "Excel")
    public static Object[][] testDataGenerator(Method met) throws IOException
        //Passing data as static
    /*{
        Object[][] data = {{"Uname1","pass1"},{"Uname2","pass2"},{"Uname3","pass3"}};
        return data;
    }*/

    //Passing data from excel
    {
        if (met.getName().equalsIgnoreCase("tc_001_login_functionality")) {
            FileInputStream file = new FileInputStream("./TestData/testdata.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet st = wb.getSheet("Login");
            int numberOfData = st.getPhysicalNumberOfRows();
            Object[][] testData = new Object[numberOfData][st.getRow(0).getPhysicalNumberOfCells()];

            for (int i = 0; i < numberOfData; i++) {
                XSSFRow row1 = st.getRow(i);
                int column = row1.getPhysicalNumberOfCells();
                for (int j = 0; j < column; j++) {
                    XSSFCell column1 = row1.getCell(j);
                    testData[i][j] = column1.getStringCellValue();
                }
            /*XSSFCell userName = row1.getCell(0);
            XSSFCell passWord = row1.getCell(1);
            testData [i][0]= userName.getStringCellValue();
            testData [i][1]= passWord.getStringCellValue();*/
            }
            return testData;
        } else if (met.getName().equalsIgnoreCase("TC_002_Register_new_User")) {
            FileInputStream file = new FileInputStream("./TestData/testdata.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet st = wb.getSheet("Register");
            int numberOfData = st.getPhysicalNumberOfRows();
            Object[][] testData = new Object[numberOfData][st.getRow(0).getPhysicalNumberOfCells()];

            for (int i = 0; i < numberOfData; i++) {
                XSSFRow row1 = st.getRow(i);
                int column = row1.getPhysicalNumberOfCells();
                for (int j = 0; j < column; j++) {
                    XSSFCell column1 = row1.getCell(j);
                    testData[i][j] = column1.getStringCellValue();
                }
            }
            return testData;
        }
        else
        {
            Object [][] testData= new Object[2][3];
            return testData;
        }
    }

}


