
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