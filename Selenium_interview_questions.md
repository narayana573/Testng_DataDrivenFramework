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
7. Write syntax for Implicity wait & Explicity wait
8. How return data of findElements & iframs
9. Write the code for find element from the table , for the text have "Name"
9. Write syntax for How to moving existing frame to previous frame
10. How to handle drop-down & how many methods
11. Write the code for reverse string
12. Why we using get() in element level
13. Differance b/w findElement & findElements
14. How many types of Xpath & explain


Interview 2:
1. Element & Elements
2. implicity, explicity & fluient
3. Abstraction, interface
4. Encapsulation
5. Project framework
6. Status codes
7. 3rd party redirect steps
8. exceptions you handled
9. strayNotFoundException
10. DB Contion
11. Xpath - makemytrip
        search results count
12. your Framework for login page & dashboard
13. parallel execution on crome & FF
14. How to fast execute testcases of 5000
15. tell me about sprint & agile


