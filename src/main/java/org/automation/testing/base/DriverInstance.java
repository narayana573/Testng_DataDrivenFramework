package org.automation.testing.base;

import org.automation.testing.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
	public WebDriver driver;

	@BeforeMethod
	public void initiateDriverInstance() throws Exception {
		if (Utility.fetchProperityValue("browserName", "config.properties").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
			driver = new ChromeDriver();
		} else if (Utility.fetchProperityValue("browserName", "config.properties").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver");
			driver = new FirefoxDriver();
		} else if (Utility.fetchProperityValue("browserName", "config.properties").equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors","'--disable-dev-shm-usage'");
			driver = new ChromeDriver(options);
		}
		driver.get(Utility.fetchProperityValue("applicationURL", "config.properties"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeDriverInstance() {
		driver.quit();
	}

}