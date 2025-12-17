
---

# Abstraction in Selenium Framework

## 1. What is Abstraction?

Abstraction is the methodology of **hiding the implementation details** (the complex code) and showing only the essential functionality to the user.

* **Goal:** Focus on *what* an object does, rather than *how* it does it.
* **Achievement:** In Java, it is achieved using **Interfaces** (100% abstraction) and **Abstract Classes** (0-100% abstraction).

## 2. Selenium Implementation Strategy

In a Selenium Automation Framework, abstraction is applied in two major ways:

### A. Interface (The `WebDriver`)

The most common example of abstraction in Selenium is the `WebDriver` interface.

* **Concept:** When we write `WebDriver driver = new ChromeDriver();`, we are using the `WebDriver` interface.
* **Abstraction:** We know `driver.get("url")` will open a URL. We do not know (and do not need to know) the complex internal logic of *how* `ChromeDriver` communicates with the Chrome browser to open that URL. That logic is hidden behind the interface.

### B. Abstract Classes (The `BasePage`)

We often create a generalized `BasePage` or `Page` class that defines the structure for all other page classes.

* **Concept:** A generic page might have methods that *every* page must have (like `getTitle` or `verifyPageLoaded`), but the implementation differs for each page.
* **Abstraction:** We force all child pages (like `LoginPage`, `HomePage`) to implement these abstract methods, ensuring a consistent structure.

## 3. Code Example

### Example 1: Abstraction via Interface (WebDriver)

*We code against the Interface (`WebDriver`), not the implementation (`ChromeDriver`).*

```java
public class BrowserTest {
    public void testGoogle() {
        // ABSTRACTION: 
        // We use the interface 'WebDriver'. 
        // We don't worry about the internal code of ChromeDriver.
        WebDriver driver = new ChromeDriver();
        
        // We use the method name (functionality), hiding the implementation.
        driver.get("https://google.com"); 
    }
}

```

### Example 2: Abstraction via Abstract Class (Page Object Model)

*Here, `BasePage` hides the complexity of the explicit wait and forces a structure.*

**The Abstract Parent Class:**

```java
public abstract class BasePage {
    
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Concrete Method (Reusable logic)
    // Hides the complexity of WebDriverWait from the Test Class
    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Abstract Method (Forced Structure)
    // Every page MUST implement this to verify it is loaded correctly
    public abstract String getPageTitle();
}

```

**The Concrete Child Class:**

```java
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Implementing the abstract method
    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public void doLogin() {
        // Using the abstracted wait method
        waitForElement(By.id("username")); 
        driver.findElement(By.id("username")).sendKeys("admin");
    }
}

```

## 4. Key Benefits in Automation

1. **Reduces Complexity:** Test script writers don't need to know complex wait logic; they just call `waitForElement()`.
2. **Loosely Coupled:** If you want to switch from `ChromeDriver` to `FirefoxDriver`, you only change the initialization line. The rest of the code (`driver.get()`, `driver.findElement()`) remains exactly the same because of the Interface.
3. **Standardization:** Abstract classes force all Page Objects to follow a specific template (e.g., every page *must* have a title verifier).

## 5. Interview Notes (Abstract Class vs. Interface)

| Feature | Abstract Class | Interface |
| --- | --- | --- |
| **Methods** | Can have both abstract (no body) and concrete (with body) methods. | Until Java 7, only abstract. Java 8+ allows `default` and `static` methods. |
| **Inheritance** | A class can extend **only one** abstract class. | A class can implement **multiple** interfaces. |
| **Variables** | Can have final, non-final, static, and non-static variables. | Variables are always `public static final` (constants). |
| **Constructor** | Can have a constructor (used by child class). | Cannot have a constructor. |
| **Selenium Use** | `BaseTest`, `BasePage` (Common setup/teardown). | `WebDriver`, `WebElement`, `JavascriptExecutor`. |

---

This video explains how to [use Abstract classes in Selenium Framework](https://www.youtube.com/watch?v=9ibXbp5t8Kc) to verify page titles and manage driver instances effectively.
