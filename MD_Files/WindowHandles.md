Here is the step-by-step guide to handling multiple tabs (or windows) in Selenium.

In Selenium, there is no difference between a "New Tab" and a "New Window." Both are handled using unique identifiers called **Window Handles**.

### The Logic (Step-by-Step)

1. **Get the Parent ID:** Store the unique ID of your current tab (Parent) so you can return to it later.
2. **Open New Tab:** Click the button or link that launches the new tab.
3. **Get All IDs:** Selenium gives you a set of IDs for *all* currently open tabs.
4. **Iterate & Switch:** Loop through the list. If an ID is **not** the Parent ID, then it must be the Child ID. Switch to it.
5. **Work & Close:** Perform your actions, close the child tab, and switch back to the parent.

### Code Example

```java
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsTest {

    public static void main(String[] args) {
        
        // 1. Setup
        System.setProperty("webdriver.chrome.driver", "./path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");

        // 2. Store the Parent Window Handle
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent ID: " + parentWindow);

        // 3. Perform action to open new tab
        driver.findElement(By.id("tabButton")).click();

        // 4. Get ALL Window Handles (Parent + Child)
        Set<String> allWindows = driver.getWindowHandles();

        // 5. Iterate and Switch
        for (String window : allWindows) {
            
            // Check if the current ID is NOT the parent
            if (!window.equals(parentWindow)) {
                
                // Switch focus to the new tab
                driver.switchTo().window(window);
                System.out.println("Switched to Child Tab ID: " + window);
                
                // --- Perform actions in the New Tab ---
                String childText = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println("Text from new tab: " + childText);
                
                // 6. Close the Child Tab (Optional but recommended)
                driver.close(); 
            }
        }

        // 7. Important: Switch control BACK to the Parent Tab
        driver.switchTo().window(parentWindow);
        
        System.out.println("Back to Parent Window title: " + driver.getTitle());
        
        driver.quit();
    }
}

```

### Key Methods Used

| Method | Description | Return Type |
| --- | --- | --- |
| `driver.getWindowHandle()` | Gets the ID of the *current* active window. | `String` |
| `driver.getWindowHandles()` | Gets IDs of *all* open windows/tabs. | `Set<String>` |
| `driver.switchTo().window(id)` | Moves the focus of the driver to the specified window ID. | `TargetLocator` |
| `driver.close()` | Closes **only** the current active tab. | `void` |
| `driver.quit()` | Closes **all** tabs and kills the driver session. | `void` |

### Important Note: `close()` vs `quit()`

When working with multiple tabs, be careful:

* Use **`driver.close()`** inside the loop to close the *child* tab only.
* If you use `driver.quit()`, it will close everything immediately, stopping your test.
