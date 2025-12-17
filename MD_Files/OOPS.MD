# Core Java Concepts for Selenium Interviews

This document outlines key Core Java concepts frequently discussed in Selenium interviews, along with their relevance and important points for preparation.
## OOPS Concepts

**Encapsulation**

# Encapsulation in Selenium Framework

## 1. What is Encapsulation?
In Object-Oriented Programming (OOP), encapsulation is the mechanism of wrapping data (variables) and code acting on the data (methods) together as a single unit. It involves **hiding** the implementation details from the outside world.

In the context of **Selenium Automation**, encapsulation is achieved using the **Page Object Model (POM)** design pattern.

## 2. Core Concept in Selenium
* **Data (Private):** WebElements and Locators (By, XPath, CSS) are treated as private data members. They should not be accessible directly by the Test Scripts.
* **Methods (Public):** Public methods are created to perform actions on those WebElements (e.g., `clickLogin()`, `enterUsername()`).

### The Rule
> The Test Class should never know **"How"** a specific action is performed (i.e., which locator is used); it should only know **"What"** action to perform.

---

## 3. Implementation Strategy

To achieve encapsulation in your Selenium framework, follow these steps:

1.  **Declare WebElements as `private`:** This prevents test scripts from directly accessing elements like `driver.findElement(By.id("..."))`.
2.  **Create `public` Action Methods:** These serve as the interface. If a locator changes, you only update the Page Class, not the Test Class.
3.  **Initialize Elements:** Use a constructor to initialize the driver and elements.

---

## 4. Code Example (Java)

### A. The Page Class (Encapsulated)
*This class hides the locators.*

```java
public class LoginPage {
    
    WebDriver driver;

    // 1. Private Data Members (Hiding the locators)
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-btn");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 2. Public Methods (Exposing the functionality)
    
    // Action to enter username
    public void enterUsername(String user) {
        driver.findElement(usernameField).sendKeys(user);
    }

    // Action to enter password
    public void enterPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    // Action to click login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    // Wrapper method for full login (High-level encapsulation)
    public void loginToApplication(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}

#

# Inheritance in Selenium Framework

## 1. What is Inheritance?

Inheritance is an OOP concept where one class (Child/Subclass) acquires the properties and behaviors (methods and fields) of another class (Parent/Superclass). It is achieved using the `extends` keyword in Java.

* **Relationship:** Represents an **"IS-A"** relationship.
* **Goal:** The primary goal is **Code Reusability** and establishing a hierarchy.

## 2. Selenium Implementation Strategy

In a Selenium framework, inheritance is most commonly used to separate **common configuration code** from **specific test logic**.

### A. The Base Class (Parent)

We create a `BaseTest` class that contains logic applicable to *all* test cases:

* Initializing the `WebDriver` (Chrome, Firefox, etc.).
* Implicit/Explicit waits.
* Reading configuration files (properties).
* Closing the browser (`tearDown`).

### B. The Test Class (Child)

Test classes (e.g., `LoginTest`, `CartTest`) extend the `BaseTest`. They automatically get access to the `driver` instance and setup methods without rewriting code.

## 3. Code Example

### Parent Class: `BaseTest.java`

*Contains the setup and teardown logic.*

```java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    // Protected so child classes can access it directly
    protected WebDriver driver; 

    @BeforeMethod
    public void setup() {
        // Common initialization logic
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Common cleanup logic
        if (driver != null) {
            driver.quit();
        }
    }
}

```

### Child Class: `LoginTest.java`

*Extends `BaseTest` to reuse the driver and setup logic.*

```java
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

// INHERITANCE: extends keyword used here
public class LoginTest extends BaseTest {

    @Test
    public void verifyTitle() {
        // 'driver' is not declared here; it is inherited from BaseTest
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        
        Assert.assertEquals(title, "Swag Labs");
    }
}

```

## 4. Key Benefits in Automation

1. **Code Reusability:** You write the browser initialization code (`new ChromeDriver()`) only once in `BaseTest` rather than in every single test case.
2. **Maintainability:** If you need to change the browser from Chrome to Edge, you only change it in the `BaseTest` class. All child classes update automatically.
3. **Cleaner Test Scripts:** Test classes remain focused on validation logic rather than infrastructure setup.

## 5. Interview Notes

* **Supported Types:** Java supports Single, Multilevel, and Hierarchical inheritance.
* **Unsupported Type:** Java **does not** support Multiple Inheritance (one child extending two parents) to avoid the "Diamond Problem" (ambiguity if two parents have the same method).
* **Keywords:**
* `extends`: To inherit from a class.
* `super`: To access parent class methods or constructors.
* `protected`: The access modifier often used for the `WebDriver` variable in the Base class so child classes can see it, but the outside world cannot.



---


