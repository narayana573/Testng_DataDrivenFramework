# Core Java Concepts for Selenium Interviews

This document outlines key Core Java concepts frequently discussed in Selenium interviews, along with their relevance and important points for preparation.

## OOPS Concepts

**Encapsulation**

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



---

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


**Polymorphism (Overloading & Overriding)**

* **Definition:** The ability of an object to take on many forms. Achieved through method overloading (compile-time) and method overriding (run-time).
    * **Overloading:** Having multiple methods in the same class with the same name but different parameter lists (number, types, or order of parameters). Resolved at compile time.
    * **Overriding:** A subclass providing a specific implementation for a method that is already defined in its superclass. The method signature (name and parameters) must be the same. Resolved at runtime based on the object's actual type.
* **Selenium Relevance:**
    * **Fluent Wait:** Custom wait conditions might involve overloaded methods to handle different waiting scenarios.
    * **Driver Interactions:** While less direct, the underlying Selenium WebDriver implementations might utilize polymorphism.
    * **Custom Framework Design:** You might use overriding to customize behavior in inherited test classes or utility classes.
* **Interview Notes:** Clearly differentiate between overloading and overriding with examples. Explain when each is resolved (compile-time vs. run-time). Understand the conditions for method overriding (same signature, IS-A relationship).

**Abstraction**

* **Definition:** Hiding complex implementation details and showing only the essential functionality to the user. Achieved using abstract classes and interfaces.
    * **Abstract Classes:** Can have both abstract (declared without implementation) and non-abstract methods. Cannot be instantiated directly. Declared using the `abstract` keyword.
    * **Interfaces:** A contract that specifies a set of methods that a class must implement. Prior to Java 8, they contained only abstract methods. Java 8 introduced default and static methods in interfaces. Declared using the `interface` keyword.
* **Selenium Relevance:**
    * **WebDriver Interface:** Selenium WebDriver itself is an interface (`WebDriver`) with various implementations for different browsers (ChromeDriver, FirefoxDriver, etc.). This provides a common abstraction for interacting with browsers.
    * **Framework Design:** Abstract classes can define common steps or templates for test flows, while interfaces can define contracts for different components of the framework (e.g., reporting, data handling).
* **Interview Notes:** Understand the difference between abstract classes and interfaces, their purpose, and when to use each. Know that abstract classes can have constructors (though they can't be directly instantiated), while interfaces (before Java 8) couldn't. Be aware of default and static methods in interfaces (Java 8+).

**Interface**

* **(Covered under Abstraction)**

## Access Modifiers in Java

| Modifier    | Class | Package | Subclass (same pkg) | Subclass (diff pkg) | Outside Class |
| :---------- | :---- | :------ | :------------------ | :-------------------- | :------------ |
| `public`    | Yes   | Yes     | Yes                 | Yes                   | Yes           |
| `protected` | Yes   | Yes     | Yes                 | Yes                   | No            |
| `default`   | Yes   | Yes     | Yes                 | No                    | No            |
| `private`   | Yes   | No      | No                  | No                    | No            |

* **Selenium Relevance:** Access modifiers are crucial for controlling the visibility and accessibility of classes, methods, and variables within your test framework. For example, page elements in POM are often declared as `private` to enforce encapsulation, and methods to interact with them are `public`.
* **Interview Notes:** Understand the scope and accessibility of each access modifier. Be able to explain scenarios where you would use each one.

## Keywords: `this` and `super`

**`this`**

* Refers to the current object of the class.
* Used to:
    * Access instance variables when local variables have the same name.
    * Invoke the current class's methods.
    * Invoke the current class's constructors (constructor chaining).
    * Pass the current object as an argument to another method.
    * Return the current object from a method.
* **Selenium Relevance:** Can be used within Page Object classes to refer to the current page instance.

**`super`**

* Refers to the immediate parent class object.
* Used to:
    * Access parent class fields and methods (if they are not private).
    * Invoke the parent class's constructor (must be the first statement in the subclass constructor).
* **Selenium Relevance:** Used in test classes that extend a base class to call the parent class's setup or teardown methods.

* **Interview Notes:** Understand the purpose of both keywords and when to use them, especially in the context of inheritance and object references.

## Additional Core Java Concepts for Selenium

**1. Constructor**

* **Definition:** A special method with the same name as the class, used to initialize objects of that class. It has no explicit return type.
* **Types:**
    * **Default Constructor:** No-argument constructor provided by the compiler if no other constructor is defined.
    * **Parameterized Constructor:** Constructor that accepts one or more arguments to initialize object attributes with specific values.
    * **Copy Constructor:** Creates a new object as a copy of an existing object (less common in standard Java but important to understand the concept).
* **Selenium Relevance:** Constructors are used in Page Object classes to initialize the WebDriver instance and other necessary elements. They are also used when creating instances of utility classes or data objects.
* **Interview Notes:** Understand the purpose of constructors, their different types, and how they are invoked when an object is created. Be aware of constructor chaining using `this()`.

**2. Static Keyword**

* **Definition:** Members (variables, methods, blocks, nested classes) declared as `static` belong to the class itself rather than to any specific instance (object) of the class. They are loaded into memory when the class is loaded.
* **Selenium Relevance:**
    * **WebDriver Instance Management:** Sometimes, a `static` WebDriver instance is used (though this can lead to issues with parallel execution, so be aware of the implications).
    * **Utility Methods:** Helper methods that don't depend on object state are often declared `static` (e.g., logging utilities, file readers).
    * **Configuration:** Static variables can be used to store global configuration values.
* **Interview Notes:** Understand the concept of class-level members versus instance-level members. Know when and why to use the `static` keyword and its implications (memory management, thread safety).

**3. Final Keyword**

* **Definition:** The `final` keyword can be used with variables, methods, and classes, with different meanings:
    * **Final Variable:** Its value cannot be changed once assigned.
    * **Final Method:** Cannot be overridden by subclasses.
    * **Final Class:** Cannot be subclassed (extended).
* **Selenium Relevance:**
    * **Constants:** `final static` variables are often used to define constants (e.g., URLs, locators).
    * **Preventing Overriding:** You might declare certain utility methods as `final` if you want to prevent subclasses from modifying their behavior.
    * **Immutability:** Using `final` fields helps in creating immutable classes, which can be beneficial in concurrent testing scenarios.
* **Interview Notes:** Understand the different uses of the `final` keyword and their implications.

**4. Exception Handling**

* **Definition:** A mechanism to handle runtime errors (exceptions) gracefully, preventing the program from crashing. Java provides `try-catch-finally` blocks, `throw`, and `throws` keywords for exception handling.
* **Selenium Relevance:** Selenium code frequently encounters exceptions (e.g., `NoSuchElementException`, `TimeoutException`). Proper exception handling is crucial for creating robust and stable test scripts. You need to handle expected exceptions and log or report unexpected ones.
* **Interview Notes:** Understand the different types of exceptions (checked vs. unchecked), the purpose of `try-catch-finally`, and the use of `throw` and `throws`. Be prepared to discuss how you handle exceptions in your Selenium framework.

**5. Collections Framework**

* **Definition:** A set of interfaces and classes that provide a way to store and manipulate groups of objects. Key interfaces include `List`, `Set`, `Map`, and common implementations like `ArrayList`, `HashSet`, `HashMap`.
* **Selenium Relevance:** Collections are widely used in Selenium for:
    * Storing lists of web elements.
    * Handling data from tables or lists on web pages.
    * Managing test data.
    * Implementing data-driven testing.
* **Interview Notes:** Have a good understanding of the core interfaces (`List`, `Set`, `Map`) and their common implementations. Know the differences between them and when to use each. Be familiar with operations like adding, removing, and iterating through elements.

**6. String Manipulation**

* **Definition:** Java provides various classes and methods for working with strings (`String`, `StringBuilder`, `StringBuffer`).
* **Selenium Relevance:** String manipulation is frequently needed for:
    * Working with locators (e.g., dynamic XPath or CSS selectors).
    * Verifying text on web pages.
    * Handling test data.
    * Generating reports.
* **Interview Notes:** Be familiar with common `String` methods (e.g., `equals()`, `equalsIgnoreCase()`, `contains()`, `substring()`, `split()`, `trim()`). Understand the difference between `String`, `StringBuilder`, and `StringBuffer` (immutability, thread safety, performance).

**7. Multithreading (Basics)**

* **Definition:** The ability of a program to execute multiple threads concurrently.
* **Selenium Relevance:** While not always explicitly used in basic test scripts, understanding multithreading can be important for:
    * Parallel test execution (though frameworks often handle this).
    * Improving performance in utility tasks.
* **Interview Notes:** Have a basic understanding of threads and processes, how to create threads (using `Runnable` and `Thread` classes), and the concept of thread synchronization (though in Selenium, you'd typically rely on testing frameworks for parallel execution management).

**8. File Handling (Basics)**

* **Definition:** Java provides classes for reading from and writing to files.
* **Selenium Relevance:** File handling is often required for:
    * Reading test data from external files (e.g., CSV, Excel, JSON).
    * Writing test reports or logs to files.
    * Handling file uploads/downloads.
* **Interview Notes:** Be familiar with basic file input/output operations using classes like `File`, `FileReader`, `BufferedReader`, `FileWriter`, `BufferedWriter`.

**9. Serialization and Deserialization (Basic Understanding)**

* **Definition:** The process of converting an object's state to a byte stream (serialization) and vice versa (deserialization).
* **Selenium Relevance:** Can be relevant in complex framework designs for saving and restoring the state of certain objects, though less commonly encountered in basic Selenium interviews.
* **Interview Notes:** Understand the basic concept and the `Serializable` interface.

**10. Annotations**

* **Definition:** Metadata that provides information about the code. Annotations start with `@` symbol.
* **Selenium Relevance:** TestNG and JUnit frameworks heavily rely on annotations (e.g., `@Test`, `@BeforeMethod`, `@AfterMethod`). Understanding these annotations is crucial for writing and running Selenium tests.
* **Interview Notes:** Be familiar with common testing framework annotations and their purpose.

**11. Generics**

* **Definition:** A feature that allows you to parameterize types, making your code more type-safe and reducing the need for casting.
* **Selenium Relevance:** Can be used in custom utility classes or when working with collections to ensure type safety.
* **Interview Notes:** Understand the basic concept of generics and their benefits.

Here is the explanation in .md (Markdown) format, ready for copy-pasting:

# String vs StringBuilder vs StringBuffer in Java (Layman Explanation)

## 1. String

- **What is it?**  
  A `String` is a **sequence of characters**, like words or sentences.

- **Example:**
  ```java
  String name = "Surya";

Immutable:

Once a string is created, it cannot be changed.

Any modification creates a new object in memory.


Example:

String str = "Hello";
str = str + " World"; // Creates a new string object "Hello World"

Use case:
Use String when the text does not change frequently.



---

2. StringBuilder

What is it?
A StringBuilder is used to modify strings without creating new objects.

Example:

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");

Mutable:

You can change its contents.

It is faster than String for many modifications.


Use case:
Use StringBuilder when strings need to be changed frequently in a single-threaded program.



---

3. StringBuffer

What is it?
Similar to StringBuilder, but it is thread-safe.

Thread-safe:

Safe to use in multi-threaded environments.

Uses synchronization internally (slightly slower due to this).


Example:

StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World");

Use case:
Use StringBuffer when multiple threads access and modify the same string object.



---

Comparison Table

Feature	String	StringBuilder	StringBuffer

Mutable	No	Yes	Yes
Thread-safe	No	No	Yes
Performance	Slow (if modified often)	Fast	Slower than StringBuilder
Use case	Read-only or few changes	Many changes in single thread	Many changes in multi-threaded programs



---

Interview Tip

String: Use when the value doesn’t change.

StringBuilder: Use when you need to modify strings often and thread-safety is not a concern.

StringBuffer: Use when you need thread safety while modifying strings.


Would you like the same content as a downloadable `.md` file?

# Java Strings Cheat Sheet

## Strings Basics

**What are strings?**

Strings are nothing but the sequence of characters. In Java, strings are objects of the `java.lang.String` class.

**How are strings represented in Java?**

In some other languages, strings are represented as an array of characters. But in Java, strings are represented as objects of the `java.lang.String` class.

**How do you create string objects in Java?**

There are two ways to create string objects in Java:

1.  **Using String Literals:**
    ```java
    String s1 = "ABC";
    String s2 = "ABC";
    ```
2.  **Using `new` Operator:**
    ```java
    String s3 = new String("ABC");
    String s4 = new String("ABC");
    ```

**How string objects are stored in the memory?**

Whenever you create string objects using string literals, those objects will be stored in a special memory location known as the **String Constant Pool (SCP)**. The JVM first checks if a string with the same content already exists in the SCP.

* If it exists, the JVM returns the reference of the existing string object. This is why `s1 == s2` will evaluate to `true`.

Whenever you create a string object using the `new` operator, a new string object will be created in the **heap memory**. Even if a string with the same content exists in the SCP, a new object will be created in the heap.

* This is why `s3 == s4` will evaluate to `false`, and `s1 == s3` will also evaluate to `false`. However, `s1.equals(s3)` will evaluate to `true` because the `equals()` method compares the content of the strings.

**Java string objects are immutable.**

Immutable means unchangeable. Once a string object is created, you cannot change its content. If you perform any operation that seems to modify a string (like concatenation), a new string object is created in memory with the modified content, and the original string object remains unchanged.

For example:

```java
String str = "Hello";
str = str + " World"; // A new "Hello World" object is created, and 'str' now refers to it. The original "Hello" remains.
| Java Version | String Class Methods Introduced |
|---|---|
| Java 1.1 | `charAt()`, `compareTo()`, `concat()`, `endsWith()`, `equals()`, `getBytes()`, `hashCode()`, `indexOf()`, `intern()`, `lastIndexOf()`, `length()`, `regionMatches()`, `startsWith()`, `substring()`, `toCharArray()`, `toLowerCase()`, `toString()`, `toUpperCase()`, `trim()`, `valueOf()` |
| Java 1.4 | `codePointAt()`, `codePoints()`, `contentEquals()`, `equalsIgnoreCase()`, `format()`, `indexOf(String str, int fromIndex)`, `lastIndexOf(String str, int fromIndex)`, `matches(String regex)`, `replace(char oldChar, char newChar)`, `split(String regex)`, `subSequence(int beginIndex, int endIndex)` |
| Java 1.5 | `codePointBefore(int index)`, `contains(CharSequence s)`, `endsWith(String suffix)`, `equals(Object anObject)`, `getBytes(Charset charset)`, `indexOf(String str)`, `lastIndexOf(String str)`, `replace(CharSequence target, CharSequence replacement)`, `split(String regex, int limit)`, `startsWith(String prefix)`, `substring(int beginIndex)`, `toCharArray()`, `toLowerCase(Locale locale)`, `toUpperCase(Locale locale)`, `trim()` |
| Java 1.6 | `codePointCount(int beginIndex, int endIndex)`, `format(String format, Object... args)`, `intern()`, `isEmpty()`, `lastIndexOf(String str, int fromIndex)`, `length()`, `matches(String regex)`, `offsetByCodePoints(int index, int codePointOffset)`, `regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)`, `replace(CharSequence target, CharSequence replacement)`, `split(String regex)`, `startsWith(String prefix, int toffset)`, `subSequence(int beginIndex, int endIndex)`, `substring(int beginIndex, int endIndex)`, `toCharArray()`, `toLowerCase(Locale locale)`, `toUpperCase(Locale locale)`, `trim()`, `valueOf(Object obj)` |
| Java 1.7 | `join(CharSequence delimiter, CharSequence... elements)` |
| Java 11 | `strip()`, `stripLeading()`, `stripTrailing()`, `isBlank()`, `lines()`, `repeat(int count)`, `replaceFirst(String regex, String replacement)`, `replaceAll(String regex, String replacement)`, `transform(Function<? super String, ? extends R> f)`, `translateEscapes()`, `indent(int n)` |

## java.lang.StringBuffer Class

The `java.lang.StringBuffer` class is used to create mutable (modifiable) string objects.

**Important Methods:**

* `append(String str)`: Adds the specified string to the end of the current string.
* `insert(int offset, String str)`: Inserts the specified string at the specified position.
* `delete(int start, int end)`: Deletes the characters within the specified range (end index is exclusive).
* `deleteCharAt(int index)`: Deletes the character at the specified position.
* `replace(int start, int end, String str)`: Replaces the characters within the specified range with the specified string.
* `reverse()`: Reverses the sequence of characters in the string buffer.
* `length()`: Returns the length (number of characters) of the string buffer.
* `capacity()`: Returns the current capacity of the string buffer (the amount of storage available for new characters).
* `ensureCapacity(int minimumCapacity)`: Ensures that the capacity of the buffer is at least equal to the specified minimum.
* `charAt(int index)`: Returns the character at the specified index.
* `setCharAt(int index, char ch)`: Sets the character at the specified index to the given character.
* `substring(int start)`: Returns a new string that is a substring of this string buffer, starting from the specified index to the end.
* `substring(int start, int end)`: Returns a new string that is a substring of this string buffer, starting from the specified `start` index (inclusive) to the specified `end` index (exclusive).

**Key Characteristics:**

* It is **not possible** to create `StringBuffer` objects using string literals; you **must** use the `new` operator to create `StringBuffer` objects.
    ```java
    StringBuffer sb1 = new StringBuffer();
    StringBuffer sb2 = new StringBuffer("initial value");
    ```
* Objects are stored in **heap memory**.
* **Thread-safe**: Methods in `StringBuffer` are synchronized, making it safe for use in multi-threaded environments.
* Generally **slower** compared to `StringBuilder` due to the overhead of synchronization.

## java.lang.StringBuilder Class

The `java.lang.StringBuilder` class is also used to create mutable string objects. It is similar to `StringBuffer` but is **not thread-safe**, which makes it faster in single-threaded environments.

**Important Methods:**

It has the **same important methods as StringBuffer**: `append()`, `insert()`, `delete()`, `deleteCharAt()`, `replace()`, `reverse()`, `length()`, `capacity()`, `ensureCapacity()`, `charAt()`, `setCharAt()`, `substring()`.

**Key Characteristics:**

* It is **not possible** to create `StringBuilder` objects using string literals; you **must** use the `new` operator to create `StringBuilder` objects.
    ```java
    StringBuilder sbl1 = new StringBuilder();
    StringBuilder sbl2 = new StringBuilder("another value");
    ```
* Objects are stored in **heap memory**.
* **Not thread-safe**: Methods in `StringBuilder` are not synchronized.
* **Faster** compared to `StringBuffer` because there is no synchronization overhead.

## String vs StringBuffer vs StringBuilder

| Feature        | String                                                     | StringBuffer                                  | StringBuilder                                     |
|----------------|------------------------------------------------------------|-----------------------------------------------|---------------------------------------------------|
| **Mutability** | Immutable (operations create new strings)                  | Mutable (modifications happen in the same object) | Mutable (modifications happen in the same object)   |
| **Thread-safe** | Yes (implicitly, as operations create new strings)         | Yes (synchronized methods)                    | No (not synchronized)                             |
| **Performance**| Generally slower for modifications                         | Slower due to synchronization                 | Faster (no synchronization overhead)              |
| **Creation** | Literal (e.g., `"hello"`) or `new String("hello")`         | Only `new StringBuffer()`                      | Only `new StringBuilder()`                        |
| **Memory Storage** | String Constant Pool (for literals) and Heap (for `new`) | Heap                                          | Heap                                              |

## String Intern

String interning is the process of creating or ensuring that a single copy of a string literal exists in the **String Constant Pool (SCP)**. When the `intern()` method is called on a `String` object, the JVM checks if a string with the same content exists in the SCP.

* **If it exists**, the reference to that string in the SCP is returned.
* **If it doesn't exist**, the string object is added to the SCP, and the reference to this new string in the SCP is returned.

String interning can be useful for **memory optimization** if you have many `String` objects with the same content. However, it should be used **judiciously** as the interning process itself takes time.

## Note for Interview Preparation:

* **Immutability of String:** This is a very common interview question. Be prepared to explain **why** strings are immutable in Java (security, caching, thread safety) and the **implications** of immutability (creation of new objects on modification). Provide clear examples.
* **String Constant Pool (SCP):** Understand **how** string literals are stored in the SCP and the **benefits** of this (memory efficiency). Explain the difference between creating strings using literals and the `new` operator with respect to the SCP.
* **`equals()` vs. `==`:** Be able to clearly **differentiate** between these two. `==` compares object references (memory addresses), while `equals()` (for `String`) compares the **content** of the strings.
* **StringBuffer vs. StringBuilder:** Know the **key differences**, especially regarding thread safety and performance. Understand **when to use each class**. Use `StringBuffer` in multi-threaded environments where thread safety is crucial, and `StringBuilder` in single-threaded environments for better performance.
* **String Interning:** Be able to explain **what** string interning is and the **purpose** of the `intern()` method. Discuss its potential **benefits** (memory saving) and **drawbacks** (performance overhead of interning).
* **Common String Methods:** Familiarize yourself with the commonly used methods of the `String` class (e.g., `substring()`, `indexOf()`, `concat()`, `replace()`, `split()`, `trim()`, `length()`, `charAt()`, `equals()`, `equalsIgnoreCase()`). Be prepared to explain what they do and provide simple usage examples.

## Examples:

**Immutability:**

```java
String s1 = "Java";
String s2 = s1.concat(" Programming");
System.out.println(s1); // Output: Java (s1 remains unchanged)
System.out.println(s2); // Output: Java Programming (s2 is a new string)
