
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

