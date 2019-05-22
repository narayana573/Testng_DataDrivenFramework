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


## TestNG Annotations
<br><br>

@BeforeSuite <br>
@AfterSuite <br>
@BeforeTest <br>
@AfterTest <br>
@BeforeGroups <br>
@AfterGroups<br>
@BeforeClass<br>
@AfterClass<br>
@BeforeMethod<br>
@AfterMethod<br><br>

@DataProvider	<br>
@Factory<br>
@Listeners<br>
@Parameters<br>
@Test<br>




```
@Test(groups={“Car”})
public void drive(){
system.out.println(“Driving the vehicle”);
}


@Test(dependsOnMethods={“drive”},groups={cars})
public void changeGear() {
system.out.println("Change Gears”);
}

@Test(threadPoolSize = 3, invocationCount = 10)
public void testServer() {
}
```



###### OOPS


#### Encapsulation:

Encapsulation can be achieved by: Declaring all the variables in the class as private and writing public methods in the class to set and get the values of variables.<br>

Encapsulation is also known as “data Hiding“
> 1. It improves maintainability and flexibility and re-usability
> 2. The fields can be made read-only
> 3. User would not be knowing what is going on behind the scene.

```
public class Student{ 

//private data member  
private String name;  

//getter method for name  
public String getName(){  
return name;  
}  


//setter method for name  
public void setName(String name){  
this.name=name  
}  


} 
```

#### Inheritence:
https://www.geeksforgeeks.org/inheritance-in-java/ <br>

It is the mechanism in java by which one class is allow to inherit the features(fields and methods) of another class<br>

Single Inheritance : In single inheritance, subclasses inherit the features of one superclass. In image below, the class A serves as a base class for the derived class B.<br>



#### Polymorphism:
#### Abstraction:



<br><br><br><br>


#### The advantages of TestNG are as follows:



> Using TestNG we can create the test cases in a systematic way.

> TestNG gives lots of annotations which in turn makes the test case creation easy.

> Using TestNG, priorities of the tests and the sequence of execution can be defined.

> Grouping is possible using TestNG.

> TestNG generates HTML reports (Selenium Webdriver cannot generate the test reports alone, TestNG helps SW to achieve this).

> Data parameterization is possible using TestNG.

> In addition to all the functionalities of junit, TestNG has its own functionalities, which in turn makes it more powerful.



## How to set priorities in TestNG?
@Test (priority=1), @Test (priority=2)


## How will you define grouping in TestNG?

@Test(groups=”title”)




## What is a dependency in TestNG?

For Example, If we want to test any application, and if the login page of the application is not working then we won't be able to test the rest of the scenarios.

So LoginTest is the method on which many tests are dependent on.

Hence we will write as follows:

@Test(dependsOnMethods=”LoginTest”) 



## What is InvocationCount in TestNG?

Answer:

If we want to execute a test case “n” number of times, then we can use the invocationCount attribute as shown in the below example.

Example:

@Test(invocationCount=8) 
Public void print()
 { 
 }

In the above example, the print() method will get executed 8 times.


##  How to disable a test in TestNG?

@Test(enabled=”false”)
