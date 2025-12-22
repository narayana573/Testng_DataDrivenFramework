Here is the explanation of **Assertions in Selenium Java**, formatted in Markdown for your notes.

---

# Assertions in Selenium (Java)

## 1. What are Assertions?

Assertions are the **checkpoints** in your automation script. They verify if the actual result matches the expected result.

* Without assertions, a script only performs actions (click, type) but does not actually "test" anything.
* **Note:** Selenium WebDriver does **not** have built-in assertion methods. We rely on testing frameworks like **TestNG** or **JUnit** to handle assertions.

## 2. Types of Assertions (TestNG)

In TestNG, there are two primary types of assertions:

### A. Hard Assertions

* **Behavior:** If a Hard Assertion fails, the test execution **stops immediately**. The remaining steps in that specific test method are skipped.
* **Use Case:** Critical checks where proceeding makes no sense (e.g., if Login fails, there is no point in checking the Dashboard).
* **Class:** `org.testng.Assert`

**Syntax:**

```java
Assert.assertEquals(actual, expected);
Assert.assertTrue(condition);
Assert.fail("Custom failure message");

```

### B. Soft Assertions

* **Behavior:** If a Soft Assertion fails, the test execution **continues**. The failure is recorded, but the script runs the subsequent steps.
* **Use Case:** Non-critical checks (e.g., verifying multiple labels on a page, checking footer text). You want to catch all errors in one go.
* **Important:** You must call `assertAll()` at the end of the test to report the failures.
* **Class:** `org.testng.asserts.SoftAssert`

## 3. Code Examples

### Example 1: Hard Assertion

*If the title doesn't match, the code stops at line 14. Line 15 never prints.*

```java
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HardAssertTest {

    @Test
    public void testTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google"; // Correct

        // HARD ASSERTION
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
        
        System.out.println("This line executes only if assertion passes.");
        driver.quit();
    }
}

```

### Example 2: Soft Assertion

*Even if the title is wrong, the code continues to check the URL and prints the message.*

```java
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SoftAssertTest {

    @Test
    public void testPageDetails() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        
        // Create SoftAssert Object
        SoftAssert softAssert = new SoftAssert();

        // Check 1: Title (Let's assume we expect "Yahoo" to force a fail)
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, "Yahoo", "Title Check Failed");

        // Check 2: URL (This will pass)
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("google"), "URL Check Failed");

        System.out.println("This line executes even if Title check failed!");
        
        driver.quit();

        // MANDATORY: Consolidate all failures at the end
        softAssert.assertAll(); 
    }
}

```

## 4. Common Assertion Methods

| Method | Description | Example |
| --- | --- | --- |
| `assertEquals(actual, expected)` | Verifies two values are identical. | Checking page title or text. |
| `assertNotEquals(actual, expected)` | Verifies two values are different. | Checking if an error ID changes. |
| `assertTrue(condition)` | Expects the condition to be `true`. | `assertTrue(btn.isDisplayed())` |
| `assertFalse(condition)` | Expects the condition to be `false`. | `assertFalse(btn.isEnabled())` |
| `assertNull(object)` | Expects the object to be null. | Checking uninitialized data. |
| `fail(message)` | Forces the test to fail. | Used in `catch` blocks or `else` conditions. |


Here is a comprehensive guide on **Validating Responses in Rest Assured**, formatted for your notes.

# In Rest Assured, validation is primarily done after the execution method (like `.get()`, `.post()`) inside the `.then()` block. This follows the BDD (Behavior Driven Development) style: **Given  When  Then**.

---

## 1. Basic Status Code Validation

The most fundamental check is ensuring the API returns the correct HTTP status code (e.g., 200 OK, 201 Created, 400 Bad Request).

```java
import static io.restassured.RestAssured.*;

public class TestStatus {
    @Test
    public void validateStatusCode() {
        given()
            .baseUri("https://reqres.in/api")
        .when()
            .get("/users/2")
        .then()
            .statusCode(200) // Checks if status is 200
            .statusLine("HTTP/1.1 200 OK"); // Checks full status line
    }
}

```

---

## 2. Validating the Response Body (JSON)

Rest Assured uses **Hamcrest Matchers** to validate specific fields inside the JSON body without parsing the whole response manually.

**Sample JSON Response:**

```json
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet"
    }
}

```

**Code Example:**

```java
import static org.hamcrest.Matchers.*; // Important import for equalTo, hasItems

given()
    .baseUri("https://reqres.in/api")
.when()
    .get("/users/2")
.then()
    .statusCode(200)
    // 1. Validate a single field
    .body("data.first_name", equalTo("Janet"))
    
    // 2. Validate a number
    .body("data.id", equalTo(2))
    
    // 3. Multiple validations in one go
    .body("data.email", containsString("@reqres.in"),
          "data.first_name", notNullValue());

```

---

## 3. Validating Headers

You often need to verify headers like `Content-Type` to ensure the server is returning JSON or XML as expected.

```java
.then()
    .header("Content-Type", "application/json; charset=utf-8")
    .header("Server", containsString("cloudflare"));

```

---

## 4. Validating Lists (Arrays)

If your API returns a list of items, you can check if specific items exist in the collection.

**Sample JSON List:**

```json
{ "courses": ["Java", "Selenium", "Python"] }

```

**Code Example:**

```java
.then()
    .body("courses", hasItems("Java", "Python")); // Checks if these exist in the list

```

---

## 5. Advanced: Extracting Data for Later Use

Sometimes assertions inside `.then()` are not enough. You might need to **extract** a value (like an Auth Token or ID) to use it in the *next* test case.

```java
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

// 1. Store the response in a variable
Response response = given().when().get("/users/2");

// 2. Convert to JsonPath object
JsonPath js = response.jsonPath();

// 3. Extract specific values
String email = js.getString("data.email");
int id = js.getInt("data.id");

System.out.println("Extracted Email: " + email);

// 4. Custom Assertion using Java (TestNG)
Assert.assertEquals(email, "janet.weaver@reqres.in");

```

---

## Summary of Hamcrest Matchers

Rest Assured relies heavily on these matchers. Always add `import static org.hamcrest.Matchers.*;`.

| Matcher | Description | Example |
| --- | --- | --- |
| `equalTo("val")` | Strict equality check | `.body("name", equalTo("John"))` |
| `containsString("val")` | Partial match | `.body("email", containsString("@gmail"))` |
| `hasItems("A", "B")` | Checks if collection contains items | `.body("ids", hasItems(1, 2))` |
| `notNullValue()` | Checks if field is not null | `.body("id", notNullValue())` |
| `lessThan(1000L)` | Checks number/time comparison | `.time(lessThan(1000L))` |
