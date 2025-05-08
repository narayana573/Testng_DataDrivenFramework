## Value Labs

## 2. Command to Create/Initialize the WebDriver

WebDriver driver = new ChromeDriver();

## 3. What is WebDriver?

WebDriver is an interface in Selenium that allows you to automate and control web browsers through programming. It provides a unified interface for interacting with different browsers.

## 4. What is ChromeDriver?

ChromeDriver is a class provided by Selenium to run automation scripts on Google Chrome. It implements the WebDriver interface and serves as a bridge between Selenium commands and the Chrome browser.

## 5. Difference Between:

```java
WebDriver driver = new WebDriver(); // ❌ Invalid - Cannot instantiate an interface.
WebDriver driver = new ChromeDriver(); // ✅ Valid - ChromeDriver implements WebDriver.
```

* `WebDriver` is an interface and cannot be instantiated directly.
* `ChromeDriver` is a concrete class that implements `WebDriver`.

## 6. What is an Interface?

An interface is a reference type in Java, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields or constructors. They are used to achieve abstraction and multiple inheritance.

## 7. What is an Abstract Class?

An abstract class is a class that cannot be instantiated. It can have both abstract methods (without body) and concrete methods (with implementation). It is used to define a common template for its subclasses.

## 8. How Can We Use Interfaces in Other Classes?

We use the `implements` keyword to implement an interface in a class.

```java
interface Vehicle {
    void start();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }
}
```

## 9. How Are You Using Encapsulation in Your Project?

We implement encapsulation by:

* Declaring class variables as `private`.
* Providing public `getter` and `setter` methods to access and modify them.

This protects the internal state of the object and maintains control over the data.

```java
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## 10. Default Methods of Selenium & Method Overloading Example

**Common WebDriver Methods:**

* `get(String url)`
* `findElement(By by)`
* `quit()`
* `close()`
* `navigate().to(String url)`

**Method Overloading Example:**

```java
public void clickButton(int id) { }
public void clickButton(String name) { }
```

Same method name, different parameter lists.

## 11. Program to Remove Vowels from a String

```java
public class RemoveVowels {
    public static void main(String[] args) {
        String input = "Hello World";
        String result = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println(result);  // Output: Hll Wrld
    }
}
```

## 12. Difference Between Thread Count and Thread Pool Size in Selenium

* **Thread Count**: Number of concurrent threads to run tests.
* **Thread Pool Size**: Maximum number of threads maintained in the pool to run test methods.

Both are used in parallel execution with TestNG.

## 13. What is Thread Count?

Thread count is a parameter in TestNG that defines how many test threads should be run in parallel during test execution.

```xml
<suite name="Suite" parallel="tests" thread-count="3">
```

## 14. What is Invocation Count?

Invocation count in TestNG is used to specify how many times a test method should be executed.

```java
@Test(invocationCount = 3)
public void testMethod() {
    System.out.println("This test will run 3 times.");
}
```



### Global Logic




### 1. How do you automate multiple tabs in Selenium?

To automate multiple tabs:

```java
// Open new tab using JavaScript
((JavascriptExecutor) driver).executeScript("window.open()");

// Get window handles
ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

// Switch to the new tab
driver.switchTo().window(tabs.get(1));
```

### 2. What is the predefined method for switching tabs in Selenium?

Use:

```java
driver.switchTo().window(windowHandle);
```

This method is used to switch between multiple windows or tabs.

### 3. How many types of locators?

Selenium supports **8 types** of locators:

1. ID
2. Name
3. Class Name
4. Tag Name
5. Link Text
6. Partial Link Text
7. CSS Selector
8. XPath

### 4. How do you redirect one URL to another URL in Selenium?

You can redirect using:

```java
driver.navigate().to("https://new-url.com");
```

Or:

```java
driver.get("https://new-url.com");
```

### 5. Write the XPath for Flipkart Search mobile in search box and find the no of records text containing "SAMSUNG Galaxy"

```xpath
//div[contains(text(), 'SAMSUNG Galaxy')]
```

(Refine it further using DOM structure if needed.)

### 6. How to re-run the failed test cases in a testing mechanism?

Using **TestNG**:

1. Run tests with a listener like `ITestListener` or use `testng-failed.xml`.
2. Command:

```bash
java -cp "<your-classpath>" org.testng.TestNG test-output/testng-failed.xml
```

### 7. Java Program to count the word "test" in a string

```java
public class TestCounter {
    public static void main(String[] args) {
        String input = "test testing";
        String wordToFind = "test";

        int count = 0;
        for (int i = 0; i <= input.length() - wordToFind.length(); i++) {
            if (input.substring(i, i + wordToFind.length()).equals(wordToFind)) {
                count++;
            }
        }

        System.out.println("The word '" + wordToFind + "' appears " + count + " time(s).");
    }
}
```

**Output:**

```
The word 'test' appears 2 time(s).
```

---

End of Q\&A

