# Polymorphism in Selenium Framework

## 1. What is Polymorphism?

Polymorphism (from Greek "Poly" = many, "Morph" = forms) is the ability of an object or method to take on multiple forms. In Java, this allows us to perform a single action in different ways.

It is classified into two types:

1. **Compile-time Polymorphism** (Method Overloading)
2. **Run-time Polymorphism** (Method Overriding)

## 2. Types & Selenium Implementation

### A. Method Overloading (Compile-time)

**Definition:** Having multiple methods in the same class with the **same name** but **different parameters** (different count, type, or order).

**Selenium Relevance:**
We often use overloading in **Utility Classes** or **Wrapper Methods** to provide flexibility in how we interact with elements.

**Code Example (Helper Class):**
*The `clickElement` method works whether we pass a Locator (By) or a raw String.*

```java
public class ElementUtils {

    WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Form 1: Click using a 'By' locator
    public void clickElement(By locator) {
        driver.findElement(locator).click();
        System.out.println("Clicked using Locator: " + locator);
    }

    // Form 2: Click using a String selector (Overloaded)
    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("Clicked using XPath String: " + xpath);
    }
    
    // Form 3: Click using a specific WebElement (Overloaded)
    public void clickElement(WebElement element) {
        element.click();
        System.out.println("Clicked specific WebElement");
    }
}

```

---

### B. Method Overriding (Run-time)

**Definition:** When a Child class provides a specific implementation for a method that is already defined in its Parent class (or Interface). The method signature (name + parameters) must be **exactly the same**.

**Selenium Relevance (The WebDriver Interface):**
This is the most critical concept in Selenium. The `WebDriver` is an **Interface** that defines methods like `get()`, `click()`, and `findElement()`. Browser-specific classes (`ChromeDriver`, `FirefoxDriver`, `EdgeDriver`) **override** these methods to interact with their specific browsers.

**Code Example:**
*This is Dynamic Binding. Java decides at runtime which browser's logic to execute.*

```java
public class BrowserTest {

    public void launchBrowser(String browserName) {
        
        // WebDriver is the Parent Interface
        WebDriver driver = null; 

        if (browserName.equals("chrome")) {
            // Child class (ChromeDriver) overrides WebDriver methods
            driver = new ChromeDriver(); 
        } else if (browserName.equals("firefox")) {
            // Child class (FirefoxDriver) overrides WebDriver methods
            driver = new FirefoxDriver();
        }

        // POLYMORPHISM IN ACTION:
        // We call .get(), but the specific implementation depends on 
        // which object (Chrome or Firefox) was assigned to 'driver' at runtime.
        driver.get("https://www.google.com"); 
    }
}

```

## 3. Comparison Table (Interview Cheat Sheet)

| Feature | Method Overloading | Method Overriding |
| --- | --- | --- |
| **Type** | Compile-time Polymorphism (Static Binding) | Run-time Polymorphism (Dynamic Binding) |
| **Location** | Happens within the **same class**. | Happens between **Parent and Child classes**. |
| **Signature** | Name is same, **parameters must differ**. | Name and parameters must be **identical**. |
| **Return Type** | Can be different. | Must be same (or covariant). |
| **Selenium Ex** | `frame(int index)` vs `frame(String name)` | `ChromeDriver` logic vs `FirefoxDriver` logic |

## 4. Why is this useful in Automation?

1. **Cross-Browser Testing:** You can write your test scripts using the `WebDriver` reference. You don't need to change your test logic to run on Chrome, Firefox, or Edge; you just swap the driver object (Overriding).
2. **Flexible Utilities:** You can create robust utility functions that accept different inputs (String, By, WebElement) to make writing tests easier (Overloading).
