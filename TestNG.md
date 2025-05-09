# TestNG Concepts for Selenium Interviews with Examples

This document outlines key TestNG concepts frequently discussed in Selenium interviews, along with their relevance and important points for preparation, now with illustrative examples.

## Core Annotations

* **`@Test`**: Marks a method as a test case.
    ```java
    import org.testng.annotations.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;

    public class LoginTest {

        @Test(priority = 1, description = "Verify successful login")
        public void testSuccessfulLogin() {
            WebDriver driver = new ChromeDriver();
            driver.get("[https://example.com/login](https://example.com/login)");
            driver.findElement(By.id("username")).sendKeys("testuser");
            driver.findElement(By.id("password")).sendKeys("password");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed");
            driver.quit();
        }

        @Test(priority = 2, enabled = false, description = "Verify login with invalid credentials")
        public void testInvalidLogin() {
            // Test logic for invalid login
            Assert.fail("Test not yet implemented");
        }
    }
    ```
    * **Selenium Relevance:** Contains the core automation steps using Selenium WebDriver.
    * **Interview Notes:** Pay attention to `priority`, `description`, and `enabled` attributes.

* **`@BeforeSuite`**: Runs once before all tests in the suite.
    ```java
    import org.testng.annotations.BeforeSuite;

    public class SuiteSetup {

        @BeforeSuite
        public void setupSuite() {
            System.out.println("Setting up the entire test suite...");
            // Initialize reporting configurations, database connections, etc.
        }
    }
    ```
    * **Selenium Relevance:** High-level setup before any browser instance is created for the suite.
    * **Interview Notes:** Runs only once at the very beginning.

* **`@AfterSuite`**: Runs once after all tests in the suite.
    ```java
    import org.testng.annotations.AfterSuite;

    public class SuiteTeardown {

        @AfterSuite
        public void teardownSuite() {
            System.out.println("Tearing down the entire test suite...");
            // Close database connections, finalize reports, etc.
        }
    }
    ```
    * **Selenium Relevance:** High-level cleanup after all tests have finished.
    * **Interview Notes:** Runs only once at the very end.

* **`@BeforeTest`**: Runs before the first `@Test` method within a `<test>` tag in `testng.xml`.
    ```java
    import org.testng.annotations.BeforeTest;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;

    public class TestSetup {
        protected WebDriver driver;

        @BeforeTest
        public void setupTest() {
            System.out.println("Setting up for a specific <test> in testng.xml...");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    ```
    * **Selenium Relevance:** Setting up a specific browser instance for a group of tests defined in a `<test>` tag.
    * **Interview Notes:** Scope is within the `<test>` tag.

* **`@AfterTest`**: Runs after all `@Test` methods within a `<test>` tag have finished.
    ```java
    import org.testng.annotations.AfterTest;
    import org.openqa.selenium.WebDriver;

    public class TestTeardown {
        protected WebDriver driver; // Assuming driver is initialized in @BeforeTest

        @AfterTest
        public void teardownTest() {
            System.out.println("Tearing down after a specific <test> in testng.xml...");
            if (driver != null) {
                driver.quit();
            }
        }
    }
    ```
    * **Selenium Relevance:** Cleaning up the browser instance after a group of tests.
    * **Interview Notes:** Scope is within the `<test>` tag.

* **`@BeforeGroups`**: Runs once before the first test method belonging to the specified group(s).
    ```java
    import org.testng.annotations.BeforeGroups;
    import org.testng.annotations.Test;

    public class GroupSetup {

        @BeforeGroups("regression")
        public void setupRegression() {
            System.out.println("Setting up for regression tests...");
            // Initialize data or configurations specific to regression tests
        }

        @Test(groups = "smoke")
        public void smokeTest1() {
            System.out.println("Running smoke test 1");
        }

        @Test(groups = "regression")
        public void regressionTest1() {
            System.out.println("Running regression test 1");
        }

        @Test(groups = {"regression", "sanity"})
        public void regressionSanityTest() {
            System.out.println("Running regression and sanity test");
        }
    }
    ```
    * **Selenium Relevance:** Setting up conditions for specific test categories.
    * **Interview Notes:** Runs once per group before any test in that group within the class.

* **`@AfterGroups`**: Runs once after all test methods belonging to the specified group(s).
    ```java
    import org.testng.annotations.AfterGroups;

    public class GroupTeardown {

        @AfterGroups("regression")
        public void teardownRegression() {
            System.out.println("Tearing down after regression tests...");
            // Clean up resources used by regression tests
        }
    }
    ```
    * **Selenium Relevance:** Cleaning up resources after specific test categories.
    * **Interview Notes:** Runs once per group after all tests in that group within the class.

* **`@BeforeClass`**: Runs once before the first `@Test` method in the current class.
    ```java
    import org.testng.annotations.BeforeClass;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;

    public class HomePageTest {
        protected WebDriver driver;

        @BeforeClass
        public void setupClass() {
            System.out.println("Setting up WebDriver for HomePageTest class...");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("[https://example.com](https://example.com)");
        }

        @Test
        public void verifyHomePageTitle() {
            Assert.assertEquals(driver.getTitle(), "Example Domain");
        }

        // More test methods in this class
    }
    ```
    * **Selenium Relevance:** Initializing WebDriver or performing setup common to all tests within a Page Object or test class.
    * **Interview Notes:** Runs once per class.

* **`@AfterClass`**: Runs once after all `@Test` methods in the current class have finished.
    ```java
    import org.testng.annotations.AfterClass;
    import org.openqa.selenium.WebDriver;

    public class HomePageTestTeardown {
        protected WebDriver driver; // Assuming driver is initialized in @BeforeClass

        @AfterClass
        public void teardownClass() {
            System.out.println("Tearing down WebDriver for HomePageTest class...");
            if (driver != null) {
                driver.quit();
            }
        }
    }
    ```
    * **Selenium Relevance:** Closing WebDriver or performing cleanup common to all tests in a class.
    * **Interview Notes:** Runs once per class.

* **`@BeforeMethod`**: Runs before each `@Test` method.
    ```java
    import org.testng.annotations.BeforeMethod;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;

    public class ProductPageTest {
        protected WebDriver driver;

        @BeforeMethod
        public void navigateToProductPage() {
            System.out.println("Navigating to product page before each test...");
            driver = new ChromeDriver();
            driver.get("[https://example.com/products/1](https://example.com/products/1)");
        }

        @Test
        public void verifyProductName() {
            // Test logic to verify product name
            Assert.assertTrue(driver.findElement(By.id("product-name")).getText().contains("Product 1"));
        }

        @AfterMethod
        public void closeBrowser() {
            System.out.println("Closing browser after each test...");
            if (driver != null) {
                driver.quit();
            }
        }
    }
    ```
    * **Selenium Relevance:** Performing actions before each individual test, like navigating to a specific page.
    * **Interview Notes:** Runs before every `@Test`.

* **`@AfterMethod`**: Runs after each `@Test` method.
    ```java
    import org.testng.annotations.AfterMethod;
    import org.openqa.selenium.WebDriver;

    public class ProductPageTestTeardown {
        protected WebDriver driver; // Assuming driver is initialized in @BeforeMethod

        @AfterMethod
        public void recordTestResult() {
            System.out.println("Recording test result after each test...");
            // Logic to log test status or take screenshots on failure
        }
    }
    ```
    * **Selenium Relevance:** Performing actions after each individual test, like logging or taking screenshots.
    * **Interview Notes:** Runs after every `@Test`.

## Key TestNG Features with Examples

* **Test Grouping**: Categorizing and running specific tests.
    ```xml
    <!DOCTYPE suite SYSTEM "[https://testng.org/testng-1.0.dtd](https://testng.org/testng-1.0.dtd)" >
    <suite name="MyTestSuite">
        <test name="SmokeTests">
            <groups>
                <run>
                    <include name="smoke"/>
                </run>
            </groups>
            <classes>
                <class name="com.example.GroupSetup"/>
            </classes>
        </test>
        <test name="RegressionTests">
            <groups>
                <run>
                    <include name="regression"/>
                </run>
            </groups>
            <classes>
                <class name="com.example.GroupSetup"/>
            </classes>
        </test>
    </suite>
    ```
    ```java
    // (Refer to the @BeforeGroups and @Test examples above for group definition)
    ```
    * **Selenium Relevance:** Running specific sets of tests like smoke tests or full regression suites.
    * **Interview Notes:** Understand `<groups>`, `<run>`, and `<include>` tags in `testng.xml`.

* **Parameterization (`@Parameters`)**: Passing values from `testng.xml`.
    ```xml
    <!DOCTYPE suite SYSTEM "[https://testng.org/testng-1.0.dtd](https://testng.org/testng-1.0.dtd)" >
    <suite name="ParameterizationSuite">
        <test name="LoginTestWithParameters">
            <parameter name="username" value="testuser"/>
            <parameter name="password" value="securepassword"/>
            <classes>
                <class name="com.example.LoginTestWithParameters"/>
            </classes>
        </test>
    </suite>
    ```
    ```java
    import org.testng.annotations.Parameters;
    import org.testng.annotations.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;

    public class LoginTestWithParameters {

        @Parameters({"username", "password"})
        @Test
        public void testLogin(String username, String password) {
            WebDriver driver = new ChromeDriver();
            driver.get("[https://example.com/login](https://example.com/login)");
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed with: " + username + " / " + password);
            driver.quit();
        }
    }
    ```
    * **Selenium Relevance:** Running the same test with different user credentials or configurations.
    * **Interview Notes:** Understand `@Parameters` annotation and the `<parameter>` tag in `testng.xml`.

* **Parameterization (`@DataProvider`)**: Providing data from a method.
    ```java
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;

    public class LoginTestWithDataProvider {

        @DataProvider(name = "loginData")
        public Object[][] provideLoginData() {
            return new Object[][]{
                    {"user1", "pass1", "Dashboard"},
                    {"invalidUser", "wrongPass", "Login Failed"},
                    {"user2", "pass2", "User Profile"}
            };
        }

        @Test(dataProvider = "loginData")
        public void testLogin(String username, String password, String expectedTitle) {
            WebDriver driver = new ChromeDriver();
            driver.get("[https://example.com/login](https://example.com/login)");
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Login with " + username + " failed. Expected: " + expectedTitle + ", Actual: " + driver.getTitle());
            driver.quit();
        }
    }
    ```
    * **Selenium Relevance:** Implementing data-driven testing with multiple sets of test data.
    * **Interview Notes:** Understand `@DataProvider` annotation and how to link it to `@Test` using `dataProvider` attribute.

* **Dependency Testing**: Making a test dependent on others.
    ```java
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class DependencyTest {

        @Test(priority = 1)
        public void startApp() {
            Assert.assertTrue(true, "App started successfully");
            System.out.println("App started");
        }

        @Test(priority = 2, dependsOnMethods = "startApp")
        public void login() {
            Assert.assertTrue(true, "Logged in successfully");
            System.out.println("Logged in");
        }

        @Test(priority = 3, dependsOnMethods = {"startApp", "login"})
        public void navigateToHomePage() {
            Assert.assertTrue(true, "Navigated to home page");
            System.out.println("Navigated to home page");
        }

        @Test(priority = 4, dependsOnMethods = "navigateToHomePage", alwaysRun = true)
        public void logout() {
            Assert.assertTrue(true, "Logged out successfully");
            System.out.println("Logged out");
        }
    }
    ```
    * **Selenium Relevance:** Ensuring critical flows are tested before dependent functionalities. Use with caution; independent tests are generally preferred.
    * **Interview Notes:** Understand `dependsOnMethods` and `alwaysRun` attributes.

* **Parallel Execution**: Running tests concurrently.
    ```xml
    <!DOCTYPE suite SYSTEM "[https://testng.org/testng-1.0.dtd](https://testng.org/testng-1.0.dtd)" >
    <suite name="ParallelTestSuite" parallel="tests" thread-count="2">
        <test name="LoginTest">
            <classes>
                <class name="com.example.LoginTest"/>
            </classes>
        </test>
        <test name="RegistrationTest">
            <classes>
                <class name="com.example.RegistrationTest"/>
            </classes>
        </test>
    </suite>
    ```
    * **Selenium Relevance:** Reducing test execution time by running tests in parallel across different browser instances or threads.
    * **Interview Notes:** Understand `parallel` (methods, classes, tests, suites) and `thread-count` attributes in `testng.xml`.

* **Listeners**: Customizing TestNG behavior.
    ```java
    import org.testng.ITestListener;
    import org.testng.ITestResult;

    public class CustomTestListener implements ITestListener {

        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Test started: " + result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("Test failed: " + result.getName());
            // Take screenshot here
        }

        // Implement other methods as needed (onTestSkipped, onFinish, etc.)
    }
    ```
    ```xml
    <!DOCTYPE suite SYSTEM "[https://testng.org/testng-1.0.dtd](https://testng.org/testng-1.0.dtd)" >
    <suite name="ListenerSuite">
        <listeners>
            <listener class-name="com.example.CustomTestListener"/>
        </listeners>
        <test name="MyTests">
            <classes>
                <class name="com.example.LoginTest"/>
                <class name="com.example.RegistrationTest"/>
            </classes>
        </test>
    </suite>
    ```
    * **Selenium Relevance:** Implementing custom reporting, logging, and screenshot capture.
    * **Interview Notes:** Understand `ITestListener` interface and how to register listeners in `testng.xml`.

* **Reporters**: Generating test reports (often used with listeners).
    ```java
    // (Refer to the CustomTestListener example above for basic reporting within a listener)

    // For more advanced reporting,
