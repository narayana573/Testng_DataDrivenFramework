###### Daily Activities
###### How often do you do do retesting & Regression testing
For regression-  when ever there is major changes to any module regression testing is required

Retest - it depends on fixing the bugs

###### string and stringbuffer difference
> String is immutable, if you try to alter their values, another object gets created, 
whereas StringBuffer and StringBuilder are mutable so they can change their values

> At any point of time StringBuffer contains some particular sequence of characters, but the length and content of the sequence can be changed through certain method calls.

> StringBuffer low performer as it is synchronized.



###### reverse string
mutable and immutable
###### assert and verify in selenium
> When an “assert” command fails, the test execution will be aborted

> When a “verify” command fails, the test will continue executing and logging the failure.


###### frame vs iframe difference
> iframe is able to "float" within content in a page

> frameset allows you to split the screen into different pages (horizontally and vertically)


###### how to swith over frame & iframe
> https://www.guru99.com/handling-iframes-selenium.html
```
driver.switchTo().parentFrame();

driver.switchTo().defaultContent();
```


###### How to switch back from a frame to default in Selenium Webdriver
``` driver.switchTo().parentFrame(); ```

> Switch to Parent Frame command sets the current browsing context for future commands to the parent of the current browsing context.

>As per the Java Docs parentFrame() method changes the focus to the parent context. If the current context is the top level browsing context, the context remains unchanged.

```driver.switchTo().defaultContent();```

> defaultContent() method selects either the first frame on the page, or the main document when a page contains iframes.

###### XPATH   (following   &following-sibling::td[1])

> following: This function will return the immediate element of the particular component.

> Preceding: This function will return the preceding element of the particular element.


###### Which is best locator in selenium?

> IDs are the safest, fastest locator option and should always be your first choice


###### How to switch back from a Window to default in Selenium Webdriver
###### oops concepts
###### testng annotations
###### Framework
###### find dynamic value from table sele






###### Difference between Runtime Polymorphism and Compile time Polymorphism

|	Compile time Polymorphism	|	Run time Polymorphism
|	:---	|	:---
|	In Compile time Polymorphism, call is resolved by the compiler.	|	In Run time Polymorphism, call is not resolved by the compiler.
|	It is also known as Static binding, Early binding and overloading as well.	|	It is also known as Dynamic binding, Late binding and overriding as well.
|	Overloading is compile time polymorphism where more than one methods share the same name with different parameters or signature and different return type.	|	Overriding is run time polymorphism having same method with same parameters or signature, but associated in a class & its subclass.
|	It is achieved by function overloading and operator overloading.	|	It is achieved by virtual functions and pointers.
|	It provides fast execution because known early at compile time.	|	It provides slow execution as compare to early binding because it is known at runtime.
|	Compile time polymorphism is less flexible as all things execute at compile time.	|	Run time polymorphism is more flexible as all things execute at run time.



###### Difference Between List &  Set java
|	List	|	Set	|
|	:---	|	:---	|
|	Duplicates are allowed	|	Duplicates are not allowed	|
|	Insertion Order Preserved	|	Insertion order not Preserved	|

how selenium  works

###### How selenium works internally

> 1. Language binding
> 2. Json wire protocol
> 3. WebDriver server
> 4. Browser

driver.get & driver.navigate

Serverity & Priority


> <b>Severity:</b> Defect Severity is defined as the degree of impact that a defect has on the operation of the product
**Severity is categorized into five types**
* Critical
* Major
* Moderate
* Minor
* Cosmetic


> <b>Priority:</b> Defect Priority has defined the order in which the developer should resolve a defect
**Priority is categorized into three types**
* Low
* Medium
* High


Test case & test scenario/suite

>Test Case

Test cases contain definite test steps, data, expected results for testing all the features of an application.

> Test Scenario   

A test scenario contains high-level documentation which describes an end to end functionality to be tested. 




Commands need to be perfect

###### Elements and Element

```
 List<WebElement> elements = driver.findElements(By.name("name"));
 WebElement loginLink = driver.findElement(By.linkText("Login"));

```



Interface vs abstract

Implicit vs explicit

50th table find
https://www.youtube.com/watch?v=Ue2DmBICOkE

Frame button selection

Framework

What is webdriver

Selenium WebDriver is a collection of open source APIs which are used to automate the testing of a web application. 

Methods for services
GET,POST,PATCH,DELETE

> HTTP response status codes
```
2xx Success
200 OK
201 Created
202 Accepted
204 No Content

3xx Redirection
301 Moved Permanently
304 Not Modified

4xx Client Error
400 Bad Request
401 Unauthorized
403 Forbidden
404 Not Found
 
5xx Server Error
500 Internal Server Error
502 Bad Gateway
504 Gateway Timeout

```

https://developer.mozilla.org/en-US/docs/Web/HTTP/Status




Interview 1:
1. Please write the project structure - starting from 'src' folder
2. How to call excel file - write code
3. Encapsulation
4. Explain Run Time polimarphisum & write the Syntax
5. What is method overloading & overridding
6. Differance b/w Abstract & Interface
7. Write syntax for Implicit, Explicit, & Fluent Wait
8. How return data of findElements & iframs
9. Write the code for find element from the table , for the text have "Name"
9. Write syntax for How to moving existing frame to previous frame
10. How to handle drop-down & how many methods
11. Write the code for reverse string
12. Why we using get() in element level
13. Differance b/w findElement & findElements
14. How many types of Xpath & explain

Interview 2(iTPC INDIA):
1. Element & Elements
2. implicity, explicity & fluient
3. Abstraction, interface
4. Encapsulation
5. Project framework
6. Status codes
7. 3rd party redirect steps
8. exceptions you handled
9. StaleElementReferenceException
10. DB Connection
11. Xpath - makemytrip
        search results count
12. your Framework for login page & dashboard
13. parallel execution on crome & FF
14. How to fast execute testcases of 5000
15. tell me about sprint & agile
16. hashmap and hashtable
17. PageFactory
18. jenkins
19. Sprint Model
20. Appium
21. how to inspect element for android app
22. is APK required to automate in appium.


Capgemini:

1. How to declare Webdriver global in single place
2. If first method fails how to skip rest Methods without testng annatoations
3. Find characters 's' in name's



Cognizant:

1. Framework structure
2. Excel connect program
3. Program to print half pyramid using *
```
*
* *
* * *
* * * *
* * * * *
```




NCR

1. String  2 character  both side  Strinh="asdfghjklaqweff4";

     find the "a" & "f" count and the position

2. Xpath for preseding
```
<div>
    <div>.         - identify this
    <div id=a>
```
3. Table last record to check with same employ



Zenq:

1. Grid
2. Parallel execution
3. Parameters in test ng and XML file
4. Not declared parameters in testng file
5. without parameter what will happen 
6. Fail test cases
7. Stale element exception how to handle
8. String '1qwerty123z'. Program
9. Status codes
10. Get and put diff and features
11. Selenium exceptions
12. Different ways to skip test cases
13. Troubleshooting for not identifying element find the solution 
14. Docker 
15. kubernetes
16. jenkins
17. Java 8 Features
18. Selenium 3.141 features








Infor:
1. waits 
2. Access modifiers
3. Beoremethod  Aftermethod beforeclass
4. Prallel executiion
5. Depends
6. element
7. elements
8. handel dynamic elements
9. whindow handel windows handes
10. driver deriver = new webDriver & Chrome deriver = new Chrome deriver()
11. Fibnic



1. Roles & Responsibility
2. My role in Project
3. assert and verify
  
  
     ```
   // +hard assertion: hard validation: if a hard assertion is getting failed: immediately test case will me marked as failed and test case will be terminated.
   // +soft assertion : soft validation: if a soft assertion is getting failed: test case will not be marked as passed as well as next lines will be executed
   // +assertAll() : is used to mark the test case as failed, if any soft assertion is getting failed
   ```

5. Implecit wait , explict wait & fluent wait
6. Scenario: one page sudden alert click ook and proceed next step
7. on button click multiple tabs opens how to navigate to particult tab (tab count)
8. cross browser testing
9. how to manuplate dom  to change button colour
10. Relative & Absolute xpath
11. Driver quit & close
12. how to take screenshot in selenium
13. Headless browser in selenium

https://javatutorial95.blogspot.com/2017/08/interview-questions-on-interface-in-java.html







Cognizant

Java:
1. Difference B/w List & Map
2. how to use Overload concept in selenium
3. About Constructor - Yes/No
4. Return Type :
5. Static :
6. Final :
7. Private :
8. Overload :
9. Override : 
10. Selenium:
11. What is difference between = & ==
12. Difference Between String Buffer & String Build
   ```
    StringBuffer:
     1. StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously.
     2. StringBuffer is less efficient than StringBuilder.

    StringBuilder:
     1. StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously.
     2. StringBuilder is more efficient than StringBuffer.
   ``` 

13. Which method is use to move footer of the page
14. How to list multiple footer links ?
   ```
     // Get Footer element which contains all footer links
     // Then "findElements" with anchor tag
     // create loop based upon number of links to traverse all links
   ```
15. How to handle broken links
   ```
    https://www.toolsqa.com/selenium-webdriver/find-broken-links-in-selenium/
   ```
    
16. When you write the xpath & which type
17. What the different type methods for check box
  ```
{ 
        // Selecting CheckBox		
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

        // This will Toggle the Check box 		
        option1.click();			

        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        }
```
18. what is the method for Right click on mouse
```
{
  Actions actions = new Actions(driver);
//Retrieve WebElement to perform right click
WebElement btnElement = driver.findElement(By.id("rightClickBtn"));
//Right Click the button to display Context Menu&nbsp;
actions.contextClick(btnElement).perform();
}
```
19. What is the methos for double click of mouse
```
{
 //Double click on element
     WebElement ele = driver.findElement(By.xpath("XPath of the element")); 
act.doubleClick(ele).perform();
}
```
20. Explain about your framework
21. How to run test cases, tell me in 3 steps
22. How to generate reports
23. Manual Exhaustive Testing



Coforge:

1. Java 8 features


2. what is Abstraction


3. what is  Interface


4. In your project where you use it ( interface & abstraction)


5. In interface can we extend private ....


6. Rest assured dependencies


7. Test ng annotations



8. Reverse string using recursion or own logic



9. App logs find how



Mars Telecom:

1. Rest Assured Methods

2. Rest Assured with java

3. what is url

4. Testng XML file

5. jmeter response capture

6. Test in postman

7. POST Method explain with java & BDD

8. excluding in testng xml file

9. Response 10th value capture

10. postman 10th value capture


Anaqua:

1. What is Head
2. what is Query Parm & Path Param
3. Status code for Duplicate record
4. Postman request Encription type
5. List down the status codes
6. Refesh token handling in rest assured
7. Authentication Methods used
8. Challanges faced in API Automation
9. 
