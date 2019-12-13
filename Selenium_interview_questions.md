###### Daily Activities
###### How often do you do do retesting & Regression testing
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

> driver.switchTo().parentFrame();

> driver.switchTo().defaultContent();



###### How to switch back from a frame to default in Selenium Webdriver
> driver.switchTo().parentFrame();

> Switch to Parent Frame command sets the current browsing context for future commands to the parent of the current browsing context.

>As per the Java Docs parentFrame() method changes the focus to the parent context. If the current context is the top level browsing context, the context remains unchanged.

> driver.switchTo().defaultContent();

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






runtime polymorphism with code

list set map in java

how selenium  works

how selenium works internally

driver.get & driver.navigate

Serverity & Priority

Test case & test scenario/suite






