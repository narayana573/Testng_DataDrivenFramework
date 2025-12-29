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
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleTabs {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "./path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");

        // 1. Store the Parent Window Handle (Current ID)
        String parentWindowID = driver.getWindowHandle();
        System.out.println("Parent ID: " + parentWindowID);

        // 2. Click button to open a new tab
        driver.findElement(By.id("tabButton")).click();

        // 3. Get ALL Window Handles (Returns a Set of Strings)
        Set<String> allWindowIDs = driver.getWindowHandles();

        // 4. Iterate through the IDs
        for (String windowID : allWindowIDs) {
            
            // If the ID is NOT the parent, it is the new child tab
            if (!windowID.equals(parentWindowID)) {
                
                // Switch Selenium's focus to the new tab
                driver.switchTo().window(windowID);
                
                System.out.println("Switched to Child Tab ID: " + windowID);
                
                // Perform actions in the new tab
                System.out.println("Child Tab Title: " + driver.getTitle());
                
                // Close the child tab (Ensure you don't use quit() here!)
                driver.close(); 
            }
        }

        // 5. Switch control BACK to the Parent Tab
        driver.switchTo().window(parentWindowID);
        
        System.out.println("Back to Parent: " + driver.getTitle());
        driver.quit();
    }
}
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

Combine With RetryAnalyzer (Best Practice)
To rerun failed tests automatically during the same run, combine this with a custom RetryAnalyzer (as we discussed earlier). This way:

RetryAnalyzer → retries during the run

testng-failed.xml → lets you re-run final failed tests manually
```

### 7. Java Program to count the word "test" in a string

```java

class Main {
    public static void main(String[] args) {
        String input = "test the system, this test is a simple test.";
        String target = "test";
        
        // Clean the string: remove punctuation and convert to lowercase
        String[] words = input.toLowerCase().split("\\W+");
        
        int count = 0;
        for (String w : words) {
            if (w.equals(target)) {
                count++;
            }
        }
        
        System.out.println("Occurrence of '" + target + "': " + count);
    
    }
}
```

**Output:**

```
The word 'test' appears 3 time(s).
```

---



## Lloyds Bank

# Interview Questions and Answers for Selenium (String, Collections, Multithreading, POM, Postman, Git)

## StringBuilder vs. StringBuffer

* **Mutability:** Both `StringBuilder` and `StringBuffer` are mutable classes in Java, meaning their content can be changed without creating a new object. This is in contrast to the `String` class, which is immutable.

* **Synchronization:**
    * `StringBuffer` is synchronized, making it thread-safe. Multiple threads can safely access and modify a `StringBuffer` instance. This synchronization comes with a performance overhead.
    * `StringBuilder` is not synchronized, making it non-thread-safe. It's faster than `StringBuffer` when used in a single-threaded environment.

* **Performance:** `StringBuilder` generally offers better performance than `StringBuffer` because it avoids the overhead of synchronization.

**Selenium Usage:**

In Selenium, you might use `StringBuilder` or `StringBuffer` when you need to dynamically build strings, such as constructing complex locators, generating test data, or formatting log messages. Since Selenium test scripts are often executed in a single thread per test, `StringBuilder` is generally preferred for its performance advantage unless you explicitly have a scenario involving multiple threads manipulating the same string builder instance.

## Collection Framework (List, LinkedList, HashMap)

The Java Collection Framework provides interfaces and classes for storing and manipulating groups of objects.

* **List:** An ordered collection (sequence) that allows duplicate elements. Elements can be accessed by their index (position).
    * **ArrayList:** Implemented as a dynamic array. Provides fast random access (getting elements by index) but can be slower for insertions and deletions in the middle of the list.
    * **LinkedList:** Implemented as a doubly-linked list. Provides efficient insertions and deletions at any position but slower random access (requires traversing the list).

* **HashMap:** A map-based collection that stores key-value pairs. It provides very fast average-case performance for insertion, deletion, and retrieval of elements based on the key. Keys must be unique, but values can be duplicated. The order of elements is not guaranteed.

**Selenium Usage:**

* **List/ArrayList:** Commonly used to store multiple `WebElement` objects found by methods like `findElements()`. This allows you to iterate through a set of elements (e.g., all links on a page, all rows in a table).
* **LinkedList:** Might be used in specific scenarios where frequent insertions or deletions of `WebElement` objects are required, although `ArrayList` is generally sufficient for most Selenium tasks.
* **HashMap:** Can be useful for storing and retrieving test data based on a key (e.g., mapping test case names to sets of input values). You might also use it to store and access properties of web elements (e.g., mapping element names to their locators).

## Multiple Threading

Multiple threading (or multithreading) is a concurrency mechanism that allows multiple parts of a program to run concurrently. Each part of the program that runs concurrently is called a thread. This can improve the performance and responsiveness of applications, especially those that involve I/O operations or tasks that can be executed in parallel.

**How to make a class multithreaded in Java (Interview Point of View):**

There are two primary ways to make a class's instances runnable as threads in Java:

1.  **Implementing the `Runnable` interface:**
    * Your class needs to implement the `Runnable` interface, which contains a single method: `public void run()`.
    * You put the code that you want to execute in a separate thread within the `run()` method.
    * To start the thread, you create an instance of your `Runnable` class and pass it to the constructor of a `Thread` object. Then, you call the `start()` method of the `Thread` object.

    ```java
    class MyRunnableTask implements Runnable {
        private String taskName;

        public MyRunnableTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskName + " is running in thread: " + Thread.currentThread().getName());
            // Your task logic here
        }

        public static void main(String[] args) {
            MyRunnableTask task1 = new MyRunnableTask("One");
            MyRunnableTask task2 = new MyRunnableTask("Two");

            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);

            thread1.start();
            thread2.start();
        }
    }
    ```

2.  **Extending the `Thread` class:**
    * Your class needs to extend the `Thread` class.
    * You override the `public void run()` method of the `Thread` class with the code you want to execute in a separate thread.
    * To start the thread, you create an instance of your class (which is now a `Thread` subclass) and call its `start()` method.

    ```java
    class MyThreadTask extends Thread {
        private String taskName;

        public MyThreadTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskName + " is running in thread: " + Thread.currentThread().getName());
            // Your task logic here
        }

        public static void main(String[] args) {
            MyThreadTask thread1 = new MyThreadTask("Alpha");
            MyThreadTask thread2 = new MyThreadTask("Beta");

            thread1.start();
            thread2.start();
        }
    }
    ```

**Selenium Usage:**

Multithreading can be used in Selenium to:

* **Parallel Test Execution:** Run multiple test cases or test suites concurrently across different browsers or with different data sets to reduce overall test execution time. Frameworks like TestNG have built-in support for parallel execution.
* **Handling Asynchronous Operations:** While Selenium commands are generally synchronous, in complex scenarios involving asynchronous JavaScript calls or background processes on the web page, you might use threading to handle waiting or polling mechanisms in a non-blocking way.
* **Reporting and Logging:** You could potentially use separate threads for logging or generating reports without blocking the main test execution flow.

## Explain Page Object Model (POM)

The Page Object Model (POM) is a design pattern widely used in test automation, especially with Selenium. It aims to create an object repository for web UI elements. Under this model, each web page of the application is represented as a class (the Page Object). This class contains:

* **Web Elements (Locators):** All the UI elements on the page are defined as variables using Selenium locators (e.g., `By.id`, `By.xpath`, `By.cssSelector`).
* **Page Methods (Actions):** Methods are created within the Page Object class to represent the actions that can be performed on the corresponding web page (e.g., `enterUsername()`, `enterPassword()`, `clickLoginButton()`). These methods typically interact with the web elements defined in the same class.

**Benefits of POM:**

* **Improved Code Reusability:** Page elements and actions are defined once, and can be reused across multiple test cases.
* **Enhanced Maintainability:** If the UI of the application changes, you only need to update the locators in the corresponding Page Object class, rather than modifying every test case that uses those elements.
* **Increased Readability:** Test cases become cleaner and easier to understand as they interact with the application through well-defined page methods.
* **Better Organization:** POM promotes a structured and organized way to manage test code, making it easier for teams to collaborate.

**Selenium Usage:**

In Selenium, you implement POM by creating a separate class for each web page you interact with in your tests. Within these classes, you use Selenium's `WebDriver` instance to locate and interact with the web elements. Test classes then instantiate these Page Object classes and call their methods to perform actions on the UI.

```java
// LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtnElement = driver.findElement(loginButton);
        loginBtnElement.click();
    }

    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }
}

// LoginTest.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("your_login_page_url");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("testuser", "password123");
        // Assertions on the homePage
        driver.quit();
    }
}

// HomePage.java (example)
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By welcomeMessage = By.id("welcome");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        WebElement welcomeElement = driver.findElement(welcomeMessage);
        return welcomeElement.getText();
    }
}


Here's a simple .md (Markdown) file that lists commonly used Git commands for a Selenium project. This file is useful as a quick reference for version control while working on automation projects.


---

Filename: git-commands-for-selenium.md

# Git Commands for Selenium Projects

## 1. Git Setup
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

2. Create or Clone Repository

# Create new repo
git init

# Clone existing repo
git clone https://github.com/yourusername/your-selenium-project.git

3. Basic Workflow

# Check current status
git status

# Add all changes
git add .

# Add specific file
git add path/to/your/file.java

# Commit changes with message
git commit -m "Add new Selenium test cases"

# Push changes to remote
git push origin main

4. Branching

# Create new branch
git branch feature/test-login

# Switch to the branch
git checkout feature/test-login

# Create and switch to new branch
git checkout -b feature/test-login

# Push new branch to remote
git push origin feature/test-login

5. Merge

# Switch to main branch
git checkout main

# Merge feature branch into main
git merge feature/test-login

6. Pull Latest Changes

git pull origin main

7. View History

git log

8. Discard Changes

# Discard unstaged changes
git checkout -- filename.java

# Reset staged files
git reset

9. Remove File from Git

# Delete file from repo
git rm filename.java
git commit -m "Remove old test file"


---

Tip: Always pull the latest code before starting new work to avoid merge conflicts.

---

```markdown
# innovasolutions

## 1. XPath for input tag from label
```
 <label for="email">E-mail</label>
 <input type="text" name="email" id="email">
```
**Answer:**

Here's the recommended XPath:

```xpath
//label[text()='E-mail']/following-sibling::input
```

## 2. Java program for the string "a2b3cd4ef5"

**Concept:** String manipulation, character iteration, conditional logic, and building a new string efficiently.

**Answer:**

The requirement is to expand the characters in the string based on the digit that follows them. If a character is followed by a digit, it's repeated that many times; otherwise, it appears once.

Here's a Java program to implement this logic:

```java
public class StringExpander {

    public static void main(String[] args) {
        String str = "a2b3cd4ef5";
        String expandedString = expandString(str);
        System.out.println("Original String: " + str);
        System.out.println("Expanded String: " + expandedString);
        // Expected Output: aabbbcdcdcdefefefefef
    }

    /**
     * Expands a string based on digits following characters.
     * A character followed by a digit 'n' is repeated n times.
     * A character not followed by a digit appears once.
     *
     * @param str The input string.
     * @return The expanded string.
     */
   public class StringPatternExpander {
    public static void main(String[] args) {
        String str = "a2b3cd4ef5";
        StringBuilder result = new StringBuilder();  // Final result
        int i = 0;

        while (i < str.length()) {
            StringBuilder letters = new StringBuilder();

            // Collect letters (until a digit or end of string)
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                letters.append(str.charAt(i));
                i++;
            }

            // If a digit follows, repeat the collected letters
            if (i < str.length() && Character.isDigit(str.charAt(i))) {
                int count = str.charAt(i) - '0';  // Convert char digit to int
                for (int j = 0; j < count; j++) {
                    result.append(letters);
                }
                i++; // Move past the digit
            } else {
                // No digit: just add the collected letters once
                result.append(letters);
            }
        }

        // Output the expanded string
        System.out.println(result.toString());  // Output: aabbbcdcdcdefefefefef
    }
}

```
End of Q\&A

