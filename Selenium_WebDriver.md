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

###### OOPS Concepts:

#### Encapsulation: 

Encapsulation can be achieved by: Declaring all the variables in the class as private and writing public methods in the class to set and get the values of variables.<br>

Encapsulation is also known as “data Hiding“
> 1. It improves maintainability and flexibility and re-usability
> 2. The fields can be made read-only
> 3. User would not be knowing what is going on behind the scene.

Wrapping up of the data(variable) & functions in a single unit is called as encapsulation

 

In encapsulation, the variables of a class will be hidden form other classes, and can be accessed only through the methods of their current class. Therefore, it is also know as data hiding.
    Assigning values of the variable-Method-Setter
    Fetching values of the variable-Method-Getter

 

To achieve encapsulation in java-
> Declare the variables of a class as private
> Provide public setter and getter methods to modify and view the variables values
    
 Secure:
        We define all the variable as a private and public getter and setter method to access this variable. So we are accessing variables indirectly so its make secure to our code.

>> Some important point you should remember related to encapsulation in Java:
       > Encapsulation in Java is used to data hiding.
       > It is helpful to reuse the code.
       > Unit testing is very easy for an encapsulated code.
       > Encapsulated code easy to maintain like we can change in a code or class without affecting other code or class.
       > Encapsulation helps to make our code secure.
>> Benefits:
       > The fields of a class can be made read-only or write-only.

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
#### Inheritance:
  We can create new class from an existing class is know as inheritance
    With the help of inheritance we can transfer the properties of a class to child class
    When we inherit from an existing class, we can reuse methods and fields of parent class, and we can add new methods & fields also
    By using "extends" keyword, we can inherit the class
    Inheritance represents IS-A relationship, it is also known as parent-child relationship

https://www.geeksforgeeks.org/inheritance-in-java/ <br>

It is the mechanism in java by which one class is allow to inherit the features(fields and methods) of another class<br>

Single Inheritance : In single inheritance, subclasses inherit the features of one superclass. In image below, the class A serves as a base class for the derived class B.<br>

>> Advantages:
   > Overriding is possible
   > Reduce the duplicate code --- Reusability
   > Ease of code/Ease of maintainace
   > Extensibility
   > Data hiding

>>  Types of Inheritance:
   > Single Inheritance -
   > Multilevel Inheritance -
   > Hierarchial Inheritance -


#### Polymorphism:
### Overloading: 
   If class have more than 1 method with same name but different signature is called as "Method overlodding"
             Also called as compile time polimorphism/Early Binding
### Overriding: 
   If the parent and child class have same name of the method & same signature is called overriden
            Also called as run time polymorphism/Late Binding

#### Abstraction:
   Abstraction is the process of hiding the implimentation details from the user. Only functionality will be provided to the user.
    An abstract method is a method that is declared without an implementation.
    An abstract class may or may not have all abstract methods. Some of them can be concrete methods
    A method defined abstract must always be redefined in the subclass,thus making overriding compulsory OR either make subclass itself abstract.
    Any class that contains one or more abstract methods must also be declared with abstract keyword.
    There can be no object of an abstract class.That is, an abstract class can not be directly instantiated with the new operator.
    An abstract class can have parametrized constructors and default constructor is always present in an abstract class.

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






<br><br><br><br>


jenkins Password:
42f08a8b1c954a7d8a0a66d0e0ff64db


/home/surya/Downloads/Softwares/jdk1.8.0_201/bin/java

which java
mvn --version
/usr/share/maven

