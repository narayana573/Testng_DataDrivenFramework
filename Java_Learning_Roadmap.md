# 🚀 Ultimate SDET & Automation Interview Roadmap (2025)

**Goal:** Zero to Hero in Core Java, Selenium WebDriver, Framework Design, and API Testing.  
**Start Date:** November 25, 2025  
**Duration:** 5 Weeks  
**Focus:** Theory implementation followed by logical coding exercises relevant to real-world interviews.

---

## 🗓️ Phase 1: Core Java Logic & OOPs Foundation
*Building the "Brain" of your automation framework.*

### 🟢 Day 1: Variables, Data Types & Operators
**Date:** Nov 25, 2025 (Tuesday)

#### 📘 Theory
1.  **Data Types:** * Primitive (`int`, `char`, `boolean`, `double`, etc.) vs Non-Primitive (`String`, Arrays).
2.  **Variables:** Local vs Instance vs Static.
3.  **Operators:** Arithmetic, Relational, Logical, and Unary.

#### 💻 Coding Exercises
* **Ex 1 (Type Casting):** Write a program to convert a `double` (e.g., 100.235) to an `int` and `char`. Print to observe data loss.
* **Ex 2 (Logic):** Swap two numbers **without** using a third variable.
* **Ex 3 (Ternary):** Find the largest of three numbers using the ternary operator `? :`.

### 🟢 Day 2: Control Statements (Conditional)
**Date:** Nov 26, 2025 (Wednesday)

#### 📘 Theory
1.  **Decision Making:** `if`, `else if`, `nested if`.
2.  **Switch Case:** Structure and `break` keyword.
3.  **Jump Statements:** `break` vs `continue`.

#### 💻 Coding Exercises
* **Ex 1 (ATM Logic):** Write a nested `if` program. 
    * Check if card is valid. If yes, ask PIN. If PIN correct, allow "Withdraw".
* **Ex 2 (Calculator):** Use `switch` case to accept two numbers and an operator (`+`, `-`, `*`, `/`) to perform math. Handle "Divide by Zero".

### 🟢 Day 3: Loops (Iteration Logic)
**Date:** Nov 27, 2025 (Thursday)

#### 📘 Theory
1.  **Loops:** `while` (pre-check), `do-while` (post-check), `for`.
2.  **Enhanced For Loop:** Iterating over arrays/collections.

#### 💻 Coding Exercises
* **Ex 1 (Palindrome):** Check if a number (e.g., 121) is a Palindrome.
* **Ex 2 (Pyramid):** Print a half-pyramid of stars `*` using nested loops.
* **Ex 3 (Factorial):** Calculate the factorial of a number using a `while` loop.

### 🟢 Day 4: Arrays & Strings
**Date:** Nov 28, 2025 (Friday)

#### 📘 Theory
1.  **Arrays:** Declaration, Heap memory allocation, Single vs Multidimensional.
2.  **Strings:** Immutability, String Constant Pool (SCP).
3.  **Classes:** `String` vs `StringBuilder` vs `StringBuffer`.

#### 💻 Coding Exercises
* **Ex 1 (Array Logic):** Find the **Second Largest Number** in an array without sorting.
* **Ex 2 (Zero Move):** Move all `0`s to the end of an array (e.g., `[0,1,0,3]` -> `[1,3,0,0]`).
* **Ex 3 (String Reverse):** Reverse a string using `StringBuilder`.

---

## 🗓️ Phase 2: Object-Oriented Programming (OOP)
*The architecture behind every Automation Framework.*

### 🟠 Day 5: Classes, Objects & Constructors
**Date:** Nov 29, 2025 (Saturday)

#### 📘 Theory
1.  **Blueprint:** Class vs Object (Instance).
2.  **Constructors:** Default vs Parameterized, `this` keyword.
3.  **Methods:** Return types and parameters.

#### 💻 Coding Exercises
* **Ex 1 (Class Design):** Create a `Student` class with `id`, `name`, `marks`. Use a constructor to initialize them.
* **Ex 2 (Logic):** Add a method `calculateGrade()` inside `Student`. If marks > 90 return 'A', else 'B'.

### 🟠 Day 6: Encapsulation
**Date:** Nov 30, 2025 (Sunday)

#### 📘 Theory
1.  **Access Modifiers:** `private`, `default`, `protected`, `public`.
2.  **Data Hiding:** Getters and Setters.
3.  **Relevance:** How this applies to the **Page Object Model (POM)** in Selenium.

#### 💻 Coding Exercises
* **Ex 1 (Secure Bank):** Create a `BankAccount` class. 
    * Make `balance` private.
    * Create public methods `deposit()` and `withdraw()` to modify balance safely.

### 🟠 Day 7: Inheritance
**Date:** Dec 01, 2025 (Monday)

#### 📘 Theory
1.  **IS-A Relationship:** `extends` keyword.
2.  **Types:** Single, Multilevel, Hierarchical.
3.  **Super:** Accessing parent variables/constructors.

#### 💻 Coding Exercises
* **Ex 1 (Hierarchy):** Create `Employee` (base) with `salary`.
    * Create `Developer` (child) that adds `bonus`.
    * Create `QA` (child) that adds `automationTool`.

### 🟠 Day 8: Polymorphism
**Date:** Dec 02, 2025 (Tuesday)

#### 📘 Theory
1.  **Overloading (Compile-time):** Same name, different parameters.
2.  **Overriding (Run-time):** Same signature, different logic in Child class.

#### 💻 Coding Exercises
* **Ex 1 (Overloading):** Create a `Login` class. Overload `login()` to accept just `username` OR `username` + `password`.
* **Ex 2 (Overriding):** Create `Bank` (interest 5%). Override in `HDFC` (7%) and `SBI` (6%).

### 🟠 Day 9: Abstraction
**Date:** Dec 03, 2025 (Wednesday)

#### 📘 Theory
1.  **Abstract Class:** `abstract` keyword, partial implementation.
2.  **Usage:** Base classes in Frameworks.

#### 💻 Coding Exercises
* **Ex 1:** Create abstract class `Shape` with abstract method `draw()`. Implement it in `Circle` and `Rectangle`.

### 🟠 Day 10: Interfaces
**Date:** Dec 04, 2025 (Thursday)

#### 📘 Theory
1.  **Pure Abstraction:** `interface`, `implements` keyword.
2.  **Selenium Link:** Why `WebDriver` is an interface.

#### 💻 Coding Exercises
* **Ex 1:** Create interface `WebDriver` with methods `get()` and `close()`. Implement in `ChromeDriver` and `FirefoxDriver`.

---

## 🗓️ Phase 3: Advanced Java & Collections
*Handling data structures for testing.*

### 🟣 Day 11: Collections (List)
**Date:** Dec 05, 2025 (Friday)

#### 📘 Theory
1.  **ArrayList:** Dynamic, resizable array.
2.  **Wrapper Classes:** `int` -> `Integer` (Autoboxing).

#### 💻 Coding Exercises
* **Ex 1:** Create an `ArrayList` of cities. Remove any city starting with "B".
* **Ex 2:** Find the average value of an Integer ArrayList.

### 🟣 Day 12: Collections (Map & Set)
**Date:** Dec 06, 2025 (Saturday)

#### 📘 Theory
1.  **HashSet:** Unique elements only.
2.  **HashMap:** Key-Value pairs (`put`, `get`).

#### 💻 Coding Exercises
* **Ex 1 (Frequency Count):** Count character occurrences in "PROGRAMMING" using `HashMap`.
    * Output: `P=1, R=2, O=1...`

### 🟣 Day 13: Exceptions & Java Capstone
**Date:** Dec 07, 2025 (Sunday)

#### 📘 Theory
1.  **Handling:** `try`, `catch`, `finally`, `throw`, `throws`.
2.  **Types:** Checked vs Unchecked.

#### 💻 Coding Exercises
* **Ex 1 (Custom Exception):** Throw `InvalidAgeException` if age < 18.
* **Capstone:** Create a console-based "Library System" using Classes, ArrayList, and Exceptions.

---

## 🗓️ Phase 4: Selenium WebDriver Mastery
*Interacting with the browser.*

### 🟢 Day 14: Architecture & Locators
**Date:** Dec 08, 2025 (Monday)

#### 📘 Concepts
* **WebDriver Architecture:** Client -> JSON Wire Protocol -> Browser Driver.
* **Locators:** XPath (Absolute/Relative), CSS, ID, Name.

#### 💻 Exercises
* **Ex 1:** Write an XPath using `following-sibling` to find an input field next to a label "Email".
* **Ex 2:** Write a dynamic XPath for a button containing text "Submit".

### 🟢 Day 15: WebElements & Dropdowns
**Date:** Dec 09, 2025 (Tuesday)

#### 📘 Concepts
* **Commands:** `click()`, `sendKeys()`, `getText()`.
* **Dropdowns:** `Select` class methods.

#### 💻 Exercises
* **Ex 1:** Automate selecting "India" from a country dropdown.
* **Ex 2:** Scrape text from a specific cell in an HTML table.

### 🟢 Day 16: Synchronization (Waits)
**Date:** Dec 10, 2025 (Wednesday)

#### 📘 Concepts
* **Implicit Wait:** Global timeout.
* **Explicit Wait:** `WebDriverWait` for specific conditions.
* **Fluent Wait:** Polling interval.

#### 💻 Exercises
* **Ex 1:** Replace `Thread.sleep` with `Explicit Wait` for an element to be clickable.

### 🟢 Day 17: Frames, Windows & Alerts
**Date:** Dec 11, 2025 (Thursday)

#### 📘 Concepts
* **Windows:** `getWindowHandles()`, switching via Iterator.
* **Frames:** `switchTo().frame()`.
* **Alerts:** `accept()`, `dismiss()`.

#### 💻 Exercises
* **Ex 1:** Script to open a new tab, switch focus, and verify the title.

### 🟢 Day 18: Actions & JS Executor
**Date:** Dec 12, 2025 (Friday)

#### 📘 Concepts
* **Actions:** Hover, Drag & Drop, Double Click.
* **JS Executor:** Scroll, Click hidden elements.

#### 💻 Exercises
* **Ex 1:** Automate a Double Click action.
* **Ex 2:** Scroll to the bottom of a page using JS Executor.

---

## 🗓️ Phase 5: Framework Design & API
*The "Job Ready" Skills.*

### 🟢 Day 19: TestNG Fundamentals
**Date:** Dec 15, 2025 (Monday)

#### 📘 Concepts
* **Annotations:** `@Test`, `@BeforeMethod`, `@AfterClass`.
* **xml:** Suite configuration, `priority`.

#### 💻 Exercises
* **Ex 1:** Convert a main method script into TestNG methods using Assertions.

### 🟢 Day 20: Advanced TestNG
**Date:** Dec 16, 2025 (Tuesday)

#### 📘 Concepts
* **Parallel:** `thread-count`, `parallel="tests"`.
* **Retries:** `IRetryAnalyzer` for failed tests.

#### 💻 Exercises
* **Ex 1:** Configure a suite to run two classes in parallel.

### 🟢 Day 21: Page Object Model (POM)
**Date:** Dec 17, 2025 (Wednesday)

#### 📘 Concepts
* **Design:** Separate Locators (Page Class) from Logic (Test Class).
* **PageFactory:** `@FindBy`, `initElements`.

#### 💻 Exercises
* **Ex 1:** Build a `LoginPage` and `LoginTest` using POM structure.

### 🟢 Day 22: Data Driven (Apache POI)
**Date:** Dec 18, 2025 (Thursday)

#### 📘 Concepts
* **Excel:** Reading data using `Workbook`, `Sheet`, `Row`.

#### 💻 Exercises
* **Ex 1:** Create a utility to read username/password from Excel for login.

### 🟢 Day 23: Maven, Git & CI/CD
**Date:** Dec 19, 2025 (Friday)

#### 📘 Concepts
* **Maven:** `pom.xml` dependencies.
* **Git:** `commit`, `push`, `pull`, `branch`.
* **Jenkins:** Creating a build job.

#### 💻 Exercises
* **Ex 1:** Push your framework to GitHub.
* **Ex 2:** Create a Jenkins job to pull code and run tests.

### 🟢 Day 24: API Testing (REST Assured)
**Date:** Dec 22, 2025 (Monday)

#### 📘 Concepts
* **Basics:** GET, POST, PUT, DELETE.
* **Status Codes:** 200, 201, 400, 404, 500.

#### 💻 Exercises
* **Ex 1:** Write a GET request to validate a 200 OK status.
* **Ex 2:** Write a POST request with a JSON payload.

### 🟢 Day 25: Complex Logic Challenge
**Date:** Dec 23, 2025 (Tuesday)

#### 💻 Exercises
* **Challenge 1:** String Expander (convert `a2b3` -> `aabbb`).
* **Challenge 2:** Count occurrences of a specific word in a sentence.
* **Challenge 3:** Handle `StaleElementReferenceException` via try-catch.

---
