
# Selenium & Java Interview Questions and Answers - Complete Set

---

## Interview 1

1. **Project Structure (from `src` folder)**

```
project-name/
├── src/
│   └── main/java/
│       └── com/projectname/
│           ├── base/
│           │   └── BaseTest.java
│           ├── pages/
│           │   └── LoginPage.java
│           ├── utils/
│           │   └── ExcelUtils.java
│           └── tests/
│               └── LoginTest.java
├── testng.xml
├── pom.xml
```

2. **Read Excel File Code**

```java
FileInputStream fis = new FileInputStream("./TestData/data.xlsx");
Workbook workbook = WorkbookFactory.create(fis);
Sheet sheet = workbook.getSheet("Sheet1");
String value = sheet.getRow(0).getCell(0).getStringCellValue();
System.out.println(value);
```

3. **Encapsulation**

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

4. **Run-time Polymorphism (Method Overriding)**

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
```

5. **Method Overloading and Overriding**

- Overloading:
```java
void login(String user) {}
void login(String user, String pass) {}
```

- Overriding:
```java
class Parent { void greet() {} }
class Child extends Parent { void greet() {} }
```

6. **Difference Between Abstract Class and Interface**

| Abstract Class       | Interface                |
|----------------------|---------------------------|
| Can have methods     | Only abstract methods     |
| Has constructors     | No constructors           |
| Can have variables   | Only static/final fields  |
| extends              | implements                |

7. **Waits Syntax**

```java
// Implicit
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Explicit
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));

// Fluent
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(5))
    .ignoring(NoSuchElementException.class);
```

8. **Return of `findElements` and IFrames**

- Returns `List<WebElement>`
- Switch iframe:
```java
driver.switchTo().frame("frameName");
driver.switchTo().parentFrame();
driver.switchTo().defaultContent();
```

9. **Find Text "Name" from Table**
```java
WebElement cell = driver.findElement(By.xpath("//table//td[text()='Name']"));
```

10. **Switch to Previous Frame**
```java
driver.switchTo().parentFrame();
```

11. **Handle Drop-Down**
```java
Select select = new Select(driver.findElement(By.id("dropdown")));
select.selectByIndex(0);
select.selectByValue("value");
select.selectByVisibleText("Text");
```

12. **Reverse String**
```java
String str = "Hello";
String rev = new StringBuilder(str).reverse().toString();
System.out.println(rev);
```

13. **Why use `get()` at Element Level**

Used to fetch the value, text or attribute: `getText()`, `getAttribute("value")`

14. **Difference Between `findElement` & `findElements`**

- `findElement`: Returns one element, throws exception if not found.
- `findElements`: Returns list, size zero if none found.

15. **Types of XPath**

- Absolute: `/html/body/div[1]/div`
- Relative: `//div[@class='name']`
- Advanced: `//div[contains(text(),'Name') and @class='title']`

---

## Selenium & Java Interview Questions and Answers

---

### Interview 1

...(Content from Interview 1 remains unchanged)

---

### Interview 2 (iTPC INDIA)

1. **Element & Elements**

* `findElement`: Returns the first matching element.
* `findElements`: Returns a list of matching elements.

2. **Implicit, Explicit & Fluent Wait**

* Implicit: Waits for a defined time before throwing NoSuchElementException.

```java
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
```

* Explicit: Waits until a specific condition is met.

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
```

* Fluent: Checks the condition at regular intervals.

```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(5))
    .ignoring(NoSuchElementException.class);
```

3. **Abstraction, Interface**

* Abstraction: Hiding internal details, showing functionality only.
* Interface: 100% abstraction, only method signatures.

4. **Encapsulation**

* Wrapping data and methods together.

```java
public class Person {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

5. **Project Framework**

* POM structure with TestNG, PageFactory, Maven, Log4j, Reports.

6. **Status Codes**

* 200 OK, 201 Created, 204 No Content
* 400 Bad Request, 401 Unauthorized, 404 Not Found, 500 Server Error

7. **3rd Party Redirect Steps**

* Use `driver.navigate().to("redirect_url")`.
* Use `302` response for redirect logic.

8. **Exceptions Handled**

* NoSuchElementException
* TimeoutException
* StaleElementReferenceException

9. **StaleElementReferenceException**

```java
try {
   element.click();
} catch(StaleElementReferenceException e) {
   element = driver.findElement(By.id("id"));
   element.click();
}
```

10. **DB Connection**

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

11. **XPath - MakeMyTrip Search Results Count**

```java
List<WebElement> results = driver.findElements(By.xpath("//div[@class='result']"));
System.out.println(results.size());
```

12. **Framework for Login & Dashboard**

* LoginPage.java and DashboardPage.java using PageFactory.

13. **Parallel Execution on Chrome & Firefox**

* Use TestNG XML parallel settings with separate browser setup methods.

14. **Execute 5000 Test Cases Fast**

* Use Grid, Headless Mode, Parallel Tests, Grouping, and Prioritizing.

15. **Sprint & Agile**

* 2-week cycles, daily stand-up, planning, review, retrospective.

16. **HashMap vs Hashtable**
    \| Feature       | HashMap          | Hashtable        |
    \|---------------|------------------|------------------|
    \| Thread-safe   | No               | Yes              |
    \| Performance   | Faster           | Slower           |
    \| Null Values   | Allows one null key | No null keys allowed |

17. **PageFactory**

```java
@FindBy(id = "username")
WebElement username;
PageFactory.initElements(driver, this);
```

18. **Jenkins**

* CI/CD tool for running builds and tests automatically.

19. **Sprint Model**

* Scrum: Iterative development in sprints with planning and demo.

20. **Appium**

* Mobile automation tool.
* Inspect using UIAutomatorViewer.
* APK is required to automate.

---

### Capgemini

1. **Declare WebDriver Globally**

```java
public class BaseClass {
    public static WebDriver driver;
}
```

2. **Skip Rest Methods if First Fails (Without TestNG Annotations)**

* Use `if` conditions and exception handling manually.

3. **Find Characters 's' in "name's"**

```java
String name = "name's";
int count = name.length() - name.replace("s", "").length();
System.out.println(count);
```

---

### Cognizant

1. **Framework Structure**

* Base, Pages, Utils, Tests

2. **Excel Connect Program**

```java
Workbook wb = WorkbookFactory.create(new File("data.xlsx"));
Sheet sh = wb.getSheet("Sheet1");
```

3. \**Print Half Pyramid Using *:**

```java
for(int i=1;i<=5;i++){
    for(int j=1;j<=i;j++){
        System.out.print("* ");
    }
    System.out.println();
}
```

---

### NCR

1. **String Character Count & Position**

```java
String str = "asdfghjklaqweff4";
int countA = 0, countF = 0;
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == 'a') {
        countA++;
        System.out.println("a found at position: " + i);
    } else if (str.charAt(i) == 'f') {
        countF++;
        System.out.println("f found at position: " + i);
    }
}
System.out.println("Total a: " + countA + ", Total f: " + countF);
```

2. **XPath for Preceding**

```xpath
//div[@id='a']/preceding::div[1]
```

3. **Table Last Record Check for Same Employee**

```java
List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
WebElement lastRow = rows.get(rows.size() - 1);
String empName = lastRow.findElement(By.xpath("td[1]")).getText();
System.out.println("Last Employee: " + empName);
```

---


# Interview Q&A Compilation

This document provides concise question-and-answer style responses for common interview topics in Selenium, Java, TestNG, API testing, and related tools.

---

## Zenq

**Q: What is Selenium Grid?**  
A: Selenium Grid allows you to run tests in parallel on multiple machines and browsers, improving test execution time.

**Q: How do you achieve parallel execution in TestNG?**  
A: Set `parallel` attribute in testng.xml (e.g., `<suite parallel="tests" thread-count="5">`) or use `@DataProvider(parallel=true)`.

**Q: How are parameters defined in TestNG XML & accessed in code?**  
A: Define in testng.xml under `<parameter name="paramName" value="value"/>`. Access in test with `@Parameters("paramName")`.

**Q: What happens if a declared parameter is missing?**  
A: TestNG throws `org.testng.TestNGException: Parameter ... not found.`

**Q: How do you fail a test case deliberately?**  
A: Use `Assert.fail("Reason")` or throw an exception in the test method.

**Q: What is a StaleElementReferenceException and how do you handle it?**  
A: Occurs when the referenced element is no longer in DOM. Handle by re-finding the element or using WebDriverWait until the element is present.

---

## Infor

**Q: Explain different waits in Selenium.**  
A: 
- Implicit Wait: Applied globally, waits for element presence.  
- Explicit Wait: Waits for a specific condition using WebDriverWait.  
- Fluent Wait: Like explicit, with polling frequency and ignore exceptions.

**Q: What are TestNG annotations for setup and teardown?**  
A:  
- `@BeforeClass` / `@AfterClass` for class-level setup/teardown.  
- `@BeforeMethod` / `@AfterMethod` for method-level setup/teardown.

**Q: How do you handle dynamic elements?**  
A: Use robust locators with `contains()`, `starts-with()` in XPath or CSS selectors, and explicit waits.

**Q: How do you switch between browser tabs/windows?**  
A: Use `driver.getWindowHandles()` to get handles, iterate, and `driver.switchTo().window(handle)` to switch.

---

## Cognizant

**Q: Difference between List and Map in Java?**  
A:  
- List: Ordered collection allowing duplicates, accessed by index.  
- Map: Key-value pairs, no duplicate keys, values accessed by keys.

**Q: Explain method overloading vs overriding.**  
A:  
- Overloading: Same method name, different parameters in same class.  
- Overriding: Subclass provides specific implementation of superclass method.

**Q: When to use StringBuffer vs StringBuilder?**  
A:  
- StringBuffer: Thread-safe (synchronized), use when multiple threads modify the sequence.  
- StringBuilder: Not synchronized, faster, use in single-thread context.

**Q: How do you perform right-click and double-click actions?**  
A:  
```java
Actions actions = new Actions(driver);
actions.contextClick(element).perform(); // Right-click
actions.doubleClick(element).perform();  // Double-click
```

---

## Coforge

**Q: Name some Java 8 features.**  
A: Lambda expressions, Stream API, Functional interfaces, Default and static methods in interfaces.

**Q: What is abstraction and how is it achieved in Java?**  
A: Abstraction hides implementation details. Achieved using abstract classes and interfaces.

**Q: Can interfaces have private methods?**  
A: Yes, since Java 9, interfaces can have private methods for code reuse within default methods.

---

## Mars Telecom

**Q: How do you write a GET and POST request in REST Assured?**  
A:  
```java
given().when().get("/endpoint").then().statusCode(200);
given().body(payload).when().post("/endpoint").then().statusCode(201);
```

**Q: What is the purpose of TestNG XML?**  
A: Configures test suites, test groups, parameters, parallel execution, and listeners in TestNG.

---

## Anaqua

**Q: Difference between Query Param and Path Param?**  
A:  
- Query Param: Appended after `?`, e.g., `?id=1`.  
- Path Param: Part of URL path, e.g., `/users/{id}`.

**Q: What status code is returned for duplicate records?**  
A: 409 Conflict.

**Q: How do you refresh tokens in API tests?**  
A: Capture refresh token and use it to request a new access token endpoint, update headers for subsequent calls.

---

## TCS

**Q: How do you validate response headers in REST Assured?**  
A:  
```java
given().when().get("/endpoint").then().header("Content-Type", "application/json");
```

**Q: Difference between SOAP and REST?**  
A:  
- SOAP: Uses XML, WSDL, strict standards.  
- REST: Uses JSON/XML, lighter, uses HTTP verbs.

**Q: How do you read Excel files in Java?**  
A: Use Apache POI library:  
```java
Workbook wb = WorkbookFactory.create(new FileInputStream(file));
Sheet sheet = wb.getSheet("Sheet1");
```

---

## HCL

**Q: How do you reverse a String in Java?**  
A:  
```java
String reversed = new StringBuilder(str).reverse().toString();
```

**Q: How do you concatenate two arrays?**  
A:  
```java
int[] result = Arrays.copyOf(a, a.length + b.length);
System.arraycopy(b, 0, result, a.length, b.length);
```

**Q: Explain polymorphism with examples.**  
A:  
- Compile-time: Method overloading.  
- Run-time: Method overriding using inheritance.



