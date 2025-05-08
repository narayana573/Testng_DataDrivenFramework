
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



