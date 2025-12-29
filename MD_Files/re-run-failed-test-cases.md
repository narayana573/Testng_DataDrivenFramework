In automation testing, rerunning failed test cases is a common strategy to handle "flaky" tests—those that fail occasionally due to environmental issues like network lags rather than actual bugs.

Depending on the framework you are using (TestNG, JUnit, or Cucumber), the implementation differs.

---

## 1. Using TestNG (Most Common)

There are two primary ways to handle reruns in TestNG:

### A. Automatic Retries (IRetryAnalyzer)

You can write code that automatically retries a test the moment it fails.

1. **Create a Retry Class:** Implement the `IRetryAnalyzer` interface.
```java
public class MyRetry implements IRetryAnalyzer {
  private int count = 0;
  private static final int maxRetry = 2; // Retry twice

  @Override
  public boolean retry(ITestResult result) {
    if (count < maxRetry) {
      count++;
      return true; // Tells TestNG to run again
    }
    return false;
  }
}

```


2. **Apply to Test:** Use the `retryAnalyzer` attribute in your `@Test` annotation.
```java
@Test(retryAnalyzer = MyRetry.class)
public void testLogin() {
    // Your test logic
}

```



### B. Using `testng-failed.xml`

If you don't want to retry immediately, TestNG automatically generates a file called `testng-failed.xml` in your `test-output` folder after every run. This file contains **only** the failed tests. You can simply run this XML file as a TestNG suite to execute just the failures.

---

## 2. Using Maven (Surefire Plugin)

If you run your tests via Maven, you can configure the **Surefire Plugin** in your `pom.xml` to automatically rerun failing tests without changing any Java code.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M5</version>
    <configuration>
        <rerunFailingTestsCount>2</rerunFailingTestsCount>
    </configuration>
</plugin>

```

*Setting this to `2` means every failed test will be attempted up to 3 times (1 initial run + 2 reruns).*

---

## 3. Using Cucumber (BDD)

For Cucumber, the common approach is to use a "rerun" formatter that saves failed scenarios to a text file.

1. **Add the Plugin:** In your Runner class, add `rerun:target/rerun.txt` to the `@CucumberOptions`.
2. **Run Failed Tests:** Create a second Runner class that points its `features` attribute to `@target/rerun.txt`.

---

### Best Practices for Reruns

* **Don't over-retry:** Usually, 1 or 2 retries are enough. If a test fails 3 times, it's likely a real bug or a very unstable environment.
* **Analyze the "Flakes":** Use reruns to get the job done, but investigate *why* tests are flaky. Rerunning shouldn't be a permanent fix for bad code.
* **Cleanup:** Ensure your `@BeforeMethod` or `@AfterMethod` logic (like clearing cookies) handles reruns correctly so the second attempt starts fresh.

