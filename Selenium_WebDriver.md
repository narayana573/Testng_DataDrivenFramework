# Testng_DataDrivenFramework


# Selenium Webdriver Notes

##### How to Handel Dropdown list

```
WebElement mySelectElement = driver.findElement(By.id("mySelect"));
Select dropdown = new Select(mySelectElement);
Now to select an option from that dropdown, we can do it in either of the three ways:

dropdown.selectByVisibleText(“Bikes”); → Selecting an option by the text that is visible
dropdown.selectByIndex(“1”); → Selecting, by choosing the Index number of that option
dropdown.selectByValue(“option2”); → Selecting, by choosing the value of that option
```

##### How to Handel Browser
```
if (Utility.fetchProperityValue("browserName", "config.properties").equalsIgnoreCase("chrome")) {
      System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
      driver = new ChromeDriver();
    }
```

##### XPATH
There are two types of XPath:
1) Absolute XPath  (html/body/div[1]/section/div[1]/div/div/div/div[1]/div/div/div/div/div[3]/div[1]/div/h4[1]/b)
2) Relative XPath 

> Xpath=//tagname[@attribute='value'] <br><br>

> Xpath=//*[contains(@name,'btn')]<br>
> Xpath=//input[@type='submit' and @name='btnLogin']<br>
> Xpath=//label[starts-with(@id,'message')]<br>
> Xpath=//*[@type='text']//following::input<br>
> Xpath=//*[text()='Enterprise Testing']//ancestor::div<br>
> Xpath=//*[@id='java_technologies']/child::li[1]<br>
> Xpath=//*[@type='submit']//preceding::input<br>
> Xpath=//*[@type='submit']//following-sibling::input<br>
> Xpath=//*[@id='rt-feature']//parent::div<br>
> Xpath =//*[@type='password']//self::input<br>
> Xpath=//*[@id='rt-feature']//descendant::a<br>
> Xpath=//*[@id='rt-feature']//descendant::a[1]<br>




##### How to Handel i frames

## iframe:
How to switch over the elements in iframes using Web Driver commands:

>By Index  -- driver.switchTo().frame(0);

>By Name or Id  -- driver.switchTo().frame("iframe1");

>By Web Element  -- driver.switchTo().frame(WebElement);

## How to switch over the frame, if we CANNOT switch using ID or Web Element:
```
public class IndexOfIframe {
 public static void main(String[] args) {
  WebDriver driver = new FirefoxDriver();
  driver.get("http://demo.guru99.com/test/guru99home/");
  driver.manage().window().maximize();
  //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  int size = driver.findElements(By.tagName("iframe")).size();

  for (int i = 0; i <= size; i++) {
   driver.switchTo().frame(i);
   int total = driver.findElements(By.xpath("html/body/a/img")).size();
   System.out.println(total);
   driver.switchTo().defaultContent();
  }
 }
}

```



##### How to handel Dynamic popup & Alert


## Alert
```
// Switching to Alert        
Alert alert = driver.switchTo().alert();    
// Capturing alert message.    
String alertMessage= driver.switchTo().alert().getText();   
// Displaying alert message   
System.out.println(alertMessage); 
Thread.sleep(5000);
// Accepting alert    
alert.accept();
// // Dismiss alert  
alert.dismiss();

```

## Popup

```
String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
String subWindowHandler = null;

Set<String> handles = driver.getWindowHandles(); // get all window handles
Iterator<String> iterator = handles.iterator();
while (iterator.hasNext()){
    subWindowHandler = iterator.next();
}
driver.switchTo().window(subWindowHandler); // switch to popup window

// Now you are in the popup window, perform necessary actions here

driver.switchTo().window(parentWindowHandler);  // switch back to parent window
```



##### How to Handel tables

```
public class RowandCell {
    public static void main(String[] args) throws ParseException {
      WebDriver wd;
    System.setProperty("webdriver.chrome.driver","G://chromedriver.exe");
     wd= new ChromeDriver();
     wd.get("http://demo.guru99.com/test/web-table-element.php"); 
     wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     WebElement baseTable = wd.findElement(By.tagName("table"));
      
     //To find third row of table
     WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
         String rowtext = tableRow.getText();
     System.out.println("Third row of table : "+rowtext);
        
        //to get 3rd row's 2nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
        String valueIneed = cellIneed.getText();
        System.out.println("Cell value is : " + valueIneed); 
        wd.close();
    }
}
```

##### implicitlyWait & ExplicitWait
```
implicitlyWait
// Wait For Page To Load
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
```
```
ExplicitWait
WebDriverWait wait=new WebDriverWait(driver,20);
// Wait till the element is not visible
WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ur xpath here")));
```

##### Database connection 

```
Step 1) Make a connection to the Database using method.
DriverManager.getConnection(URL, "userid", "password") 

Step 2) Create Query to the Database using the Statement Object.
Statement stmt = con.createStatement();

Step 3) Send the query to database using execute query and store the results in the ResultSet object.
ResultSet rs = stmt.executeQuery(select * from employee;);

```
##### Git Commands

##### getScreenshotAs()
```
File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(shot, new File("D:\\ shot1.jpg"));

```


###### Actions in Selenium Webdriver:

```
Actions actions = new Actions(driver);
```
###### Handel Drag & Drop:
```
 //To get source locator
 WebElement sourceLocator = driver.findElement(By.cssSelector("#draggable"));
  `              //To get target locator`
 WebElement targetLocator = driver.findElement(By.cssSelector("#droppable"));
                //dragAndDrop(source, target) method accepts two parameters source and locator. 
                //used dragAndDrop method to drag and drop the source locator to target locator
 actions.dragAndDrop(sourceLocator, targetLocator).build().perform();
```
###### MoveToElement:
```
 WebElement mainMenu = driver.findElement(By.linkText("menulink"));
actions.moveToElement(mainMenu);
actions.sendKeys(Keys.TAB).build().perform();
```





<br><br><br><br>


jenkins Password:
42f08a8b1c954a7d8a0a66d0e0ff64db


/home/surya/Downloads/Softwares/jdk1.8.0_201/bin/java

which java
mvn --version
/usr/share/maven



## Webdriver exceptions

| Webdriver exceptions    				  | Description         																		 | 
| :---         			  				   |     :---:      																			 |
| NoSuchElementException                  | This exception is due to accessing an element which is not available on the page.            | 
| NoAlertPresentException                 | If a user tries to handle an alert box but the alert is not present.                         | 
| ElementNotVisibleException              | If selenium tries to find an element but the element is not visible within the page          | 
| NoSuchAttributeException                | While trying to get attribute value but the attribute is not available in DOM.               | 
| WebDriverException                      | Exception comes when a code is unable to initialize WebDriver.                               | 
| NoSuchWindowException                   | This is thrown when WebDriver tries to switch to an invalid window.                          | 
| NoSuchFrameException                    | When WebDriver is trying to switch to an invalid frame, NoSuchFrameException under NotFoundException class is thrown.                                                                                                                               | 
| InvalidSelectorException                | This subclass of NoSuchElementException class occurs when a selector is incorrect or syntactically invalid. This exception occurs commonly when XPATH locator is used.																	             |
| ElementNotSelectableException           | This exception comes under InvalidElementStateException class. ElementNotSelectableException indicates that the web element is present in the web page but cannot be selected.															             |
| TimeoutException                        | This exception occurs when a command completion takes more than the wait time. Waits are mainly used in WebDriver to avoid the exception ElementNotVisibleException.																             |
| NoSuchSessionException                  | This exception is thrown when a method is called after quitting the browser by WebDriver.quit(). This can also happen due to web browser issues like crashes and WebDriver cannot execute any command using the driver instance.	               |
| StaleElementReferenceException          | StaleElementReferenceException is thrown when an object for a particular web element was created in the program without any problem and however; this element is no longer present in the window. 									             |


