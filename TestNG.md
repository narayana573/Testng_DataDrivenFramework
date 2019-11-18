
## TestNG Annotations
<br><br>

1. What are the annotations available in TestNG?


**@BeforeSuite:** 	The annotated method will be run before all tests in this suite have run.<br>
**@AfterSuite:** 	The annotated method will be run after all tests in this suite have run.<br>
**@BeforeTest:** 	The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.<br>
**@AfterTest:** 	The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.<br>
**@BeforeGroups:** 	The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.<br>

**@AfterGroups:** 	The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.<br>

**@BeforeClass:** 	The annotated method will be run before the first test method in the current class is invoked.<br>
**@AfterClass:** 	The annotated method will be run after all the test methods in the current class have been run.<br>
**@BeforeMethod:** 	The annotated method will be run before each test method.<br>
**@AfterMethod:** 	The annotated method will be run after each test method.<br>



**@DataProvider:** Marks a method as supplying data for a test method. The annotated method must return an Object[][] where each Object[] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.<br><br>


**name:**			The name of this data provider. If it's not supplied, the name of this data provider will automatically be set to the name of the method.<br>
parallel:		If set to true, tests generated using this data provider are run in parallel. Default value is false.<br>


**@Factory:**		Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[]. <br>


**@Listeners:** 	Defines listeners on a test class.<br>
value:			An array of classes that extend org.testng.ITestNGListener.<br>


**@Parameters:**	Describes how to pass parameters to a @Test method.<br>
value:			The list of variables used to fill the parameters of this method.<br>


**@Test:** 				Marks a class or a method as part of the test.<br>
**alwaysRun:**			If set to true, this test method will always be run even if it depends on a method that failed.<br>
**dataProvider:**		The name of the data provider for this test method.<br>
**dataProviderClass:**	The class where to look for the data provider. If not specified, the data provider will be looked on the class of the current test method or one of its base classes. If this attribute is specified, the data provider method needs to be static on the specified class.<br>
**dependsOnGroups:**	The list of groups this method depends on.<br>
**dependsOnMethods:**	The list of methods this method depends on.<br>
**description:**		The description for this method.<br>
**enabled:**			Whether methods on this class/method are enabled.<br>
**expectedExceptions:**	The list of exceptions that a test method is expected to throw. If no exception or a different than one on this list is thrown, this test will be marked a failure.<br>
**groups:**				The list of groups this class/method belongs to.<br>
**invocationCount:**	The number of times this method should be invoked.<br>
**invocationTimeOut:**	The maximum number of milliseconds this test should take for the cumulated time of all the invocationcounts. This attribute will be ignored if invocationCount is not specified.<br>
**priority:**			The priority for this test method. Lower priorities will be scheduled first.<br>
**successPercentage:**	The percentage of success expected from this method.<br>
**singleThreaded:**		If set to true, all the methods on this test class are guaranteed to run in the same thread, even if the tests are currently being run with parallel="methods". This attribute can only be used at the class level and it will be ignored if used at the method level. Note: this attribute used to be called sequential (now deprecated).<br>
**timeOut:**			The maximum number of milliseconds this test should take.<br>
**threadPoolSize:**		The size of the thread pool for this method. The method will be invoked from multiple threads as specified by invocationCount.
Note: this attribute is ignored if invocationCount is not specified<br>

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
