
```markdown
## Value Labs

## 2. Command to Create/Initialize the WebDriver

```java
WebDriver driver = new ChromeDriver();
```

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
    @Override // Good practice to use @Override annotation
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
* `Maps().to(String url)`

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

* **Thread Count**: Number of concurrent threads to run tests (often specified at the suite or test level in TestNG).
* **Thread Pool Size**: Maximum number of threads maintained in the pool to run test methods (often related to the executor service managing threads).

Both are used in parallel execution with TestNG.

## 13. What is Thread Count?

Thread count is a parameter in TestNG that defines how many test threads should be run in parallel during test execution within a suite or a test.

```xml
<suite name="Suite" parallel="tests" thread-count="3">
```

## 14. What is Invocation Count?

Invocation count in TestNG is used to specify how many times a particular test method should be executed.

```java
@Test(invocationCount = 3)
public void testMethod() {
    System.out.println("This test will run 3 times.");
}
```

---

### Global Logic

### 1. How do you automate multiple tabs in Selenium?

To automate multiple tabs:

```java
// Open new tab using JavaScript
((JavascriptExecutor) driver).executeScript("window.open()");

// Get window handles
// Set<String> handles = driver.getWindowHandles(); // Use Set as handles are unique
// ArrayList<String> tabs = new ArrayList<>(handles); // Convert to List if indexed access is needed

// A more common way to get handles:
Set<String> handles = driver.getWindowHandles();
ArrayList<String> tabs = new ArrayList<>(handles); // Example converting to ArrayList


// Switch to the new tab (assuming it's the last one opened)
driver.switchTo().window(tabs.get(tabs.size() - 1)); // Switch to the last opened tab
// Or if you know the handle:
// driver.switchTo().window(windowHandleOfNewTab);
```
*(Note: Using `ArrayList` from `getWindowHandles()` works, but `getWindowHandles()` returns a `Set`, which is technically a more accurate representation as window handles are unique.)*

### 2. What is the predefined method for switching tabs in Selenium?

Use:

```java
driver.switchTo().window(windowHandle);
```

This method is used to switch the WebDriver's focus to a specific window or tab identified by its unique `windowHandle` (a String).

### 3. How many types of locators?

Selenium supports **8 types** of locators:

1.  ID
2.  Name
3.  Class Name
4.  Tag Name
5.  Link Text
6.  Partial Link Text
7.  CSS Selector
8.  XPath

### 4. How do you redirect one URL to another URL in Selenium?

You can redirect using:

```java
driver.navigate().to("[https://new-url.com](https://new-url.com)");
```

Or:

```java
driver.get("[https://new-url.com](https://new-url.com)");
```

*(`driver.get()` is generally used for the initial navigation to a page, while `driver.navigate().to()` is part of the Navigation interface and offers more navigation options like back, forward, and refresh, in addition to navigating to a URL.)*

### 5. Write the XPath for Flipkart Search mobile in search box and find the no of records text containing "SAMSUNG Galaxy"

*(Assuming the text "SAMSUNG Galaxy" is part of an element displaying the count or results summary)*

```xpath
//div[contains(text(), 'SAMSUNG Galaxy')]
```

*(Note: This XPath is a starting point. To find the number of records text specifically, you might need to inspect the page's HTML structure and refine the XPath to target the element containing both the count and the text, potentially using parent/ancestor or sibling axes depending on how the text and count are structured in the DOM.)*

### 6. How to re-run the failed test cases in a testing mechanism?

Using **TestNG**:

1.  Configure a listener (`ITestListener`) to capture test results and identify failures.
2.  After a test run, TestNG automatically generates an `testng-failed.xml` file in the `test-output` directory, containing only the failed test methods.
3.  You can then re-run the failed tests by executing this generated XML file.

Command example (adjusting classpath):

```bash
java -cp "<your-classpath>" org.testng.TestNG test-output/testng-failed.xml
```

**Combine With RetryAnalyzer (Best Practice)**
To rerun failed tests automatically *during* the same run (e.g., for flaky tests), combine the above with a custom `IRetryAnalyzer` implementation in TestNG. This way:

* `IRetryAnalyzer`: Automatically retries a test method a specified number of times immediately upon failure within the same test run.
* `testng-failed.xml`: Allows for a manual re-run of any tests that *still* failed after retries.

### 7. Java Program to count the word "test" in a string

```java
public class TestCounter {
    public static void main(String[] args) {
        String input = "test testing the test"; 
         int Count = 0;
        
        String[] split = input.split(" ");

        for (String word : split) {

            if (word.equals("test")) {

                Count++;
            }
        }
        System.out.println("Test Keyword is repeated "+Count+" Times");
    }
}
```

**Output:**

```
Test Keyword is repeated 2 Times
```

---

## Lloyds Bank

# Interview Questions and Answers for Selenium (String, Collections, Multithreading, POM, Postman, Git)

## StringBuilder vs. StringBuffer

* **Mutability:** Both `StringBuilder` and `StringBuffer` are mutable classes in Java. Their content can be changed after creation, unlike the immutable `String` class.

* **Synchronization:**
	* `StringBuffer` is **synchronized**, making it thread-safe. This means multiple threads can access and modify a `StringBuffer` instance concurrently without causing data inconsistency issues. The synchronization adds some performance overhead.
	* `StringBuilder` is **not synchronized**, making it not thread-safe. It is generally faster than `StringBuffer` because it doesn't have the overhead of managing concurrent access.

* **Performance:** `StringBuilder` is generally faster than `StringBuffer` in single-threaded environments due to the lack of synchronization overhead.

**Selenium Usage:**

In Selenium, you'll most often use `StringBuilder` when you need to build strings dynamically (e.g., constructing URLs, log messages, or complex test data strings). Since typical Selenium test execution per browser instance is single-threaded, the performance advantage of `StringBuilder` makes it the preferred choice unless you have a specific multi-threaded scenario where multiple threads are modifying the *same* string builder object.

## Collection Framework (List, LinkedList, HashMap)

The Java Collection Framework provides a set of interfaces and classes to represent and manipulate groups of objects as a single unit.

* **List:** An ordered collection (sequence) that allows duplicate elements. Elements in a List have an index based on their position, allowing for positional access.
	* **`ArrayList`:** Implemented using a dynamic array. It's generally good for random access (getting elements by index) and adding elements to the end. Insertions and deletions in the middle can be relatively slow as elements need to be shifted.
	* **`LinkedList`:** Implemented using a doubly-linked list. It's efficient for insertions and deletions anywhere in the list because only the pointers of nearby elements need to be updated. However, random access (getting an element by index) can be slower as it may require traversing the list.

* **`HashMap`:** Implements the `Map` interface, storing key-value pairs. It uses a hash table for storage, providing very fast average-case performance for operations like insertion, deletion, and retrieval based on the key. Keys must be unique, but values can be duplicated. `HashMap` does not guarantee any specific order of elements.

**Selenium Usage:**

* **`List` (`ArrayList`):** Frequently used to store collections of `WebElement` objects returned by methods like `findElements()`. This is useful for iterating through multiple similar elements (e.g., all links, all checkboxes, rows in a table).
* **`LinkedList`:** Less commonly used in typical Selenium workflows compared to `ArrayList`, but could be useful in scenarios where you are frequently adding or removing elements from the middle of a collection of WebElements or data.
* **`HashMap`:** Can be used to store test data (e.g., mapping a test case name to its input parameters) or to store properties of web elements where you need quick lookups based on a key (like storing locators by a logical name).

## Multiple Threading

Multiple threading (or multithreading) is the ability of a program to execute multiple parts (threads) concurrently. This allows for better utilization of CPU resources and can improve the performance and responsiveness of applications, especially for tasks that can run in parallel.

**How to make a class multithreaded in Java (Interview Point of View):**

There are two main ways to create threads in Java:

1.  **Implementing the `Runnable` interface:**
	* Create a class that `implements Runnable`.
	* Put the code to be executed in the thread within the `public void run()` method.
	* Create an instance of your `Runnable` class.
	* Create a `Thread` object, passing your `Runnable` instance to its constructor.
	* Call the `start()` method on the `Thread` object to begin execution in a new thread.

	```java
    class MyRunnableTask implements Runnable {
        private String taskName;

        public MyRunnableTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskName + " is running in thread: " + Thread.currentThread().getName());
            // Task logic goes here
        }

        public static void main(String[] args) {
            MyRunnableTask task1 = new MyRunnableTask("Task One");
            MyRunnableTask task2 = new MyRunnableTask("Task Two");

            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);

            thread1.start(); // Starts thread execution
            thread2.start(); // Starts thread execution
        }
    }
    ```

2.  **Extending the `Thread` class:**
	* Create a class that `extends Thread`.
	* Override the `public void run()` method with the code to be executed in the thread.
	* Create an instance of your class.
	* Call the `start()` method on your class instance.

	```java
    class MyThreadTask extends Thread {
        private String taskName;

        public MyThreadTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskName + " is running in thread: " + Thread.currentThread().getName());
            // Task logic goes here
        }

        public static void main(String[] args) {
            MyThreadTask thread1 = new MyThreadTask("Thread Alpha");
            MyThreadTask thread2 = new MyThreadTask("Thread Beta");

            thread1.start(); // Starts thread execution
            thread2.start(); // Starts thread execution
        }
    }
    ```
	*Implementing `Runnable` is generally preferred in Java as it allows your class to extend another class if needed, promoting better code organization and flexibility.*

**Selenium Usage:**

Multithreading in Selenium is primarily used for:

* **Parallel Test Execution:** Running multiple test cases, classes, or suites simultaneously to significantly reduce the total test execution time. TestNG and JUnit provide built-in support for parallel execution.
* **Executing tasks concurrently:** In advanced scenarios, you might use threads to perform actions like capturing screenshots, logging, or reporting in the background while the main test execution continues, although often built-in framework features or asynchronous programming patterns are used instead.

## Explain Page Object Model (POM)

The Page Object Model (POM) is a widely adopted design pattern in test automation that helps create a structured and maintainable automation framework. Its core idea is to represent each web page or significant component of the web application as a separate class.

Each **Page Object class** typically contains:

1.  **Web Elements (Locators):** It defines the locators (e.g., By.id, By.xpath, By.cssSelector) for the key UI elements on that page or component as private members of the class.
2.  **Page Methods (Actions):** It includes public methods that represent the interactions a user can perform on that page (e.g., `enterUsername(String username)`, `clickLoginButton()`, `isErrorMessageDisplayed()`). These methods encapsulate the logic for interacting with the web elements defined in the class.

**Benefits of using POM:**

* **Maintainability:** If the UI changes (e.g., a locator for a button changes), you only need to update the locator in one place – the corresponding Page Object class. This is much easier than finding and updating the locator in every test case where it's used.
* **Reusability:** The methods defined in a Page Object can be reused across multiple test cases that interact with that page.
* **Readability:** Test cases become more readable and understandable as they call methods that describe user actions in plain language (e.g., `loginPage.login("user", "pass")`) rather than directly interacting with locators.
* **Reduced Code Duplication:** By centralizing element locators and interactions, you avoid repeating the same code in different test scripts.
* **Separation of Concerns:** It separates the test logic (what is being tested) from the page interaction logic (how to interact with the page), making both easier to manage.

**Selenium Usage:**

In a Selenium project following POM, you would typically have a directory structure where each Page Object is a Java class file. Your test classes (e.g., TestNG or JUnit tests) would then create instances of these Page Objects and call their methods to perform test steps.

```java
// Example: LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Import other necessary Selenium classes like WebElement

public class LoginPage {
    private WebDriver driver;

    // Define locators for elements on the login page
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text()='Login']"); // Example XPath

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to perform the login action and potentially return the next page object
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        // Assuming successful login navigates to HomePage
        // You might add waits or checks here before returning the new page object
        return new HomePage(driver);
    }

    // Example of a method to check for an error message
    public boolean isErrorMessageDisplayed() {
        // Example locator for an error message element
        By errorMessage = By.cssSelector(".error-message");
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; // Error message not found
        }
    }
}

// Example: LoginTest.java (using TestNG)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        // Set up WebDriver (e.g., ChromeDriver)
        driver = new ChromeDriver();
        driver.get("your_login_page_url"); // Navigate to the login page
        loginPage = new LoginPage(driver); // Initialize the LoginPage object
    }

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = loginPage.login("valid_username", "valid_password");
        // Now you interact with elements/methods on the HomePage object
        // Example assertion: Check if a welcome message is displayed on the home page
        Assert.assertTrue(homePage.getWelcomeMessage().contains("Welcome"), "Welcome message not displayed after login");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.login("invalid_username", "invalid_password");
        // Assert that an error message is displayed on the same login page
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login");
    }


    @AfterMethod
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
```

## Postman

Postman is a popular API development and testing tool. It allows you to send various types of HTTP requests (GET, POST, PUT, DELETE, etc.) to APIs, inspect the responses, and automate API testing.

**Key features relevant to automation and testing:**

* **Sending API Requests:** Easily construct and send requests with different headers, body types (JSON, form-data, etc.), and parameters.
* **Inspecting Responses:** View the response status code, headers, body, and timing.
* **Organizing Requests:** Group requests into Collections for better organization.
* **Variables and Environments:** Use variables to store values (like base URLs, tokens) and switch between different environments (e.g., development, staging, production).
* **Tests:** Write scripts (using JavaScript) to validate API responses, perform assertions, and chain requests.
* **Monitoring:** Schedule collections to run automatically and monitor API performance and uptime.
* **Mock Servers:** Create mock APIs to simulate endpoints for testing before the actual backend is ready.
* **API Documentation:** Generate documentation for your APIs from your Postman collections.

**Usage in a testing context:**

* **API Testing:** Directly test the functionality and performance of REST or SOAP APIs.
* **Data Setup/Teardown:** Use Postman scripts or integrate Postman runs into your automation framework to set up test data via API calls before UI tests or clean up data afterward.
* **Validating Backend Operations:** After performing an action on the UI in Selenium, you can use Postman (or integrate API calls within your framework) to verify that the corresponding data changes occurred correctly in the backend via API calls.

## Git

Git is a distributed version control system. It's used to track changes in source code during software development, allowing multiple developers to collaborate on projects, manage different versions of the code, and revert to previous states if needed.

**Key Git Concepts:**

* **Repository:** A directory containing your project files, plus a `.git` subdirectory where Git stores its history and configuration. Can be local or remote.
* **Commit:** A snapshot of your repository at a specific point in time. Each commit has a unique identifier (hash).
* **Branch:** A lightweight movable pointer to a commit. Branches allow you to work on new features or fixes in isolation from the main codebase.
* **Merge:** The process of combining changes from one branch into another.
* **Clone:** Creating a local copy of a remote repository.
* **Pull:** Fetching changes from a remote repository and merging them into your current branch.
* **Push:** Uploading your local commits to a remote repository.
* **Status:** Shows the state of your working directory and staging area.
* **Add:** Stages changes, preparing them for the next commit.

**Git Commands for Selenium Projects (.md format):**

```markdown
# Git Commands for Selenium Projects

This is a quick reference for common Git commands used in a Selenium test automation project.

## 1. Initial Setup

```bash
# Configure user name and email (do this once globally)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

## 2. Creating or Cloning a Repository

```bash
# To initialize a new Git repository in your project directory
git init

# To clone an existing remote repository (e.g., from GitHub, GitLab, Bitbucket)
git clone <repository_url>
# Example: git clone https://github.com/yourusername/your-selenium-project.git
```

## 3. Basic Workflow (Add, Commit, Push)

```bash
# Check the status of your files (which are modified, staged, etc.)
git status

# Stage changes for the next commit
# Add all changes in the current directory and subdirectories
git add .
# Or add a specific file
git add path/to/your/TestFile.java
```

```bash
# Commit your staged changes with a descriptive message
git commit -m "Implement login test scenario"
# Good commit messages are concise and explain the purpose of the changes
```

```bash
# Push your committed changes to the remote repository (e.g., 'origin' is the default remote name, 'main' or 'master' is often the main branch name)
git push origin main
# You might need to specify the branch if pushing a new branch for the first time: git push -u origin feature/new-test
```

## 4. Branching

```bash
# List all local branches
git branch

# List local and remote branches
git branch -a

# Create a new branch
git branch feature/add-reporting

# Switch to an existing branch
git checkout feature/add-reporting
# Or using the newer switch command (recommended)
git switch feature/add-reporting

# Create a new branch AND switch to it
git checkout -b feature/add-reporting
# Or using the newer switch command
git switch -c feature/add-reporting

# Push a new local branch to the remote repository
git push -u origin feature/add-reporting
# The -u flag sets the upstream branch, so next time you can just use 'git push'
```

## 5. Merging

```bash
# First, switch to the branch where you want to merge changes INTO (e.g., main)
git checkout main

# Pull the latest changes from the remote main branch
git pull origin main

# Merge the feature branch INTO the current branch (main)
git merge feature/add-reporting
# Git will attempt to automatically merge. If there are conflicts, you'll need to resolve them manually.
```

## 6. Pulling Latest Changes

```bash
# Fetch changes from the remote and merge them into the current branch
git pull origin main
# This is equivalent to git fetch followed by git merge FETCH_HEAD
```

## 7. Viewing History

```bash
# View the commit history
git log
# Press 'q' to exit the log view

# View a summarized history graph
git log --graph --oneline --all
```

## 8. Discarding Changes

```bash
# Discard unstaged changes in a specific file
git checkout -- path/to/your/File.java
# BE CAREFUL: This will lose your local modifications in that file!

# Discard all unstaged changes in the current directory and subdirectories
git checkout -- . # Use with extreme caution!

# Unstage a staged file (move changes from staging area back to working directory)
git reset HEAD path/to/your/File.java
# Or for all staged files
git reset HEAD
```

## 9. Removing Files

```bash
# Remove a file from the working directory AND stage the removal for commit
git rm path/to/your/OldTest.java
# Then commit the change: git commit -m "Remove OldTest.java"

# To remove a file from the repository but keep it in your working directory (stop tracking)
git rm --cached path/to/your/ConfigFile.properties
# Then commit the change
```

---

**Tip:** Always run `git pull` before starting work on a feature branch or before merging to ensure you have the latest code. Regularly commit your changes with meaningful messages.

---

## innovasolutions

## 1. XPath for input tag from label
```html
 <label for="email">E-mail</label>
 <input type="text" name="email" id="email">
```
**Answer:**

Here's the recommended XPath:

```xpath
//label[text()='E-mail']/following-sibling::input
```
*Explanation provided previously covers the details of this XPath.*

## 2. Java program for the string "a2b3cd4ef5"

**Concept:** String manipulation, character iteration, conditional logic, and building a new string efficiently.

**Answer:**

The requirement is to expand the characters in the string based on the digit that follows them. If a character is followed by a digit, it's repeated that many times; otherwise, it appears once.

Here's a corrected Java program to implement this logic:

```java
public class StringPatternExpander {
	public static void main(String[] args) {
		String str = "a2b3cd4ef5";
		StringBuilder result = new StringBuilder();

		int i = 0;
		while (i < str.length()) {
			StringBuilder temp = new StringBuilder();

			// Collect letters
			while (i < str.length() && Character.isLetter(str.charAt(i))) {
				temp.append(str.charAt(i));
				i++;
			}

			// If next char is digit, repeat the collected letters
			if (i < str.length() && Character.isDigit(str.charAt(i))) {
				int count = str.charAt(i) - '0';  // convert char to int
				for (int j = 0; j < count; j++) {
					result.append(temp);
				}
				i++; // move past digit
			} else {
				// No digit, just append letters once
				result.append(temp);
			}
		}

		// Output the result
		System.out.println(result.toString());  // Output: aabbbcdcdcdefefefefef
	}
}

```
*(This corrected code now has the `expandString` method within the `StringExpander` class and the `main` method correctly calls it to demonstrate its usage.)*

```

End of Q&A
```

```
