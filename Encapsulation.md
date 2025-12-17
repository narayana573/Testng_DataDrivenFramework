# **Encapsulation**

* **Definition:** Wrapping up data (variables) and code (methods) into a single unit. Achieved by using access modifiers (primarily `private` for data) and providing public getter and setter methods to control access.
* **Selenium Relevance:**
    * **Page Object Model (POM):** Encapsulation is fundamental to POM. Web elements and their associated actions (methods) within a page are encapsulated within a Page Class. This improves maintainability and reduces code duplication.
    * **Data Handling:** Encapsulation can be used to manage test data securely and control how it's accessed within the test framework.
* **Interview Notes:** Understand the benefits (maintainability, security, reusability, data hiding) and how it's implemented in Java. Be prepared to explain the `private` access modifier and the role of getter/setter methods.


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
