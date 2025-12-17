#### 1. What is Abstract and Interface?

Abstract
- An abstract class is a class that is only partially implemented by the programmer. It may contain one or more abstract methods. 
- An abstract method is simply a function definition that serves to tell the programmer that the method must be implemented in a child class.

- An interface is like an abstract class; indeed, interfaces occupy the same namespace as classes and abstract classes. For that reason, you cannot define an interface with the same name as a class. An interface is a fully abstract class; none of its methods are implemented and instead of a class sub-classing from it, it is said to implement that interface.

- Abstract class doesn't support multiple inheritance. Abstract class can provide the implementation of interface.

- Interface supports multiple inheritance. Interface can't provide the implementation of abstract class.



#### 2. Where do use public, final and static?

Public -

- Public is a Java keyword which declares a member's access as public.
- Public members are visible to all other classes. 
- This means that any other class can access a public field or method. 
- Further, other classes can modify public fields unless the field is declared as final.

Final -

- When we apply "final" keyword to a variable, the value of that variable remains constant. 
- (or) Once we declare a variable as final. the value of that variable cannot be changed.
- It is useful when a variable value does not change during the life time of a program

Static -

- when we apply "static" keyword to a variable, it means it belongs to class.
- When we apply "static" keyword to a method, it means the method can be accessed without creating any instance of the class
	


#### 3. Can you declare a Final class? If yes, where can you use it?

- Yes, A final class is simply a class that can't be extended.
- By marking a class as final you disable a powerful and flexible feature of the language for that part of the code. 
- Some classes however, should not (and in certain cases cannot) be designed to take sub classing into account in a good way. 
- In these cases, it makes sense to mark the class as final, even though it limits OOPS. 
- (Remember however that a final class can still extend another non-final class	



#### 4. Overloading and overriding?

- Overloading occurs when two or more methods in one class have the same method name but different parameters.
- Overriding means having two methods with the same method name and parameters (i.e., method signature). One of the methods is in the parent class and the other is in the child class. Overriding allows a child class to provide a specific implementation of a method that is already provided its parent class.




 #### 5. Inheritance concept?

Inheritance is an important pillar of OOP (Object Oriented Programming). It is the mechanism in java by which one class can inherit the features (fields and methods) of another class.

Important terminology:

- Super Class: The class whose features are inherited is known as super class (or a base class or a parent class).
    
- Sub Class: The class that inherits the other class is known as sub class (or a derived class, extended class, or child class). The subclass can add its own fields and methods in addition to the superclass fields and methods.
    
- Reusability: Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there is already a class that includes some of the code that we want, we can derive our new class from the existing class. By doing this, we are reusing the fields and methods of the existing class.
    
- The keyword used for inheritance is extends.


#### 6. What are the data types available in java? 

      byte, short, int, long, float, double, boolean, char

#### 7. What are primitives & non-primitives? 

- Primitives : int, float, character and boolean
- Non-primitives: Strings, Arrays, Classes, Interface

	A variable of a non-primitive type doesn't contain the value directly; instead, it is a reference (similar to a pointer) to an object. (It is not possible in Java to create user-defined value types).


#### 8. Difference b/w int and integer ?

- int is a primitive type. Variables of type int store the actual binary value for the integer you want to represent. 
	int.parseInt("1") doesn't make sense because int is not a class and therefore doesn't have any methods.
	
- Integer is a class and int is a primitive type.

#### 9. Why is an array non-primitive? 

- Non-primitive, or reference data types, are the more sophisticated members of the data type family. They don't store the value, but store a reference to that value. 
- Instead of partNumber 4030023, Java keeps the reference, also called address, to that value, not the value itself.

#### 10. What is the difference between array & arraylist? 

- Array is static in size that is fixed length data structure, One can not change the length after creating the Array object.
- ArrayList is dynamic in size . Each ArrayList object has instance variable capacity which indicates the size of the ArrayList. As elements are added to an ArrayList its capacity grows automatically.


#### 11. What are OOPs? Explain them. 

Core OOPS concepts are:

- Encapsulation. This is the practice of keeping fields within a class private, then providing access to them via public methods. It’s a protective barrier that keeps the data and code safe within the class itself. This way, we can re-use objects like code components or variables without allowing open access to the data system-wide.

- Inheritance. This is a special feature of Object Oriented Programming in Java. It lets programmers create new classes that share some of the attributes of existing classes. This lets us build on previous work without reinventing the wheel.

- Polymorphism. This Java OOPs concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. See more on this below.

- Abstraction. Abstraction means using simple things to represent complexity. We all know how to turn the TV on, but we don’t need to know how it works in order to enjoy it. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets avoid repeating the same work multiple times.


#### 12. Explain Inheritance concept? 

- Inheritance is the object-oriented programming concept where an object is based on another object. Inheritance is the mechanism of code reuse. The object that is getting inherited is called superclass and the object that inherits the superclass is called subclass.

  

#### 13. What is the difference between Abstract class and Interface? 

- Main difference is methods of a Java interface are implicitly abstract and cannot have implementations. 
- A Java abstract class can have instance methods that implements a default behaviour.

2.Variables declared in a Java interface is by default final. An abstract class may contain non-final variables.

3.Members of a Java interface are public by default. A Java abstract class can have the usual flavours of class members like private, protected, etc..

4.Java interface should be implemented using keyword “implements”; A Java abstract class should be extended using keyword “extends”.

5.An interface can extend another Java interface only, an abstract class can extend another Java class and implement multiple Java interfaces.

6.A Java class can implement multiple interfaces but it can extend only one abstract class.

7.Interface is absolutely abstract and cannot be instantiated; A Java abstract class also cannot be instantiated, but can be invoked if a main() exists.

8.In comparison with java abstract classes, java interfaces are slow as it requires extra indirection.

#### 14. What is polymorphism? 

- Polymorphism is the concept where an object behaves differently in different situations. 
- There are two types of polymorphism – compile time polymorphism and runtime polymorphism.
- Compile time polymorphism is achieved by method overloading.
- Runtime polymorphism is implemented when we have “IS-A” relationship between objects. This is also called as method overriding because subclass has to override the superclass method for runtime polymorphism.

#### 15. Explain the difference between Method overloading & Method overriding with an example

- Method overriding is when a child class redefines the same method as a parent class, with the same parameters. For example, the standard Java class java.util.LinkedHashSet extends java.util.HashSet. The method add() is overridden in LinkedHashSet. If you have a variable that is of type HashSet, and you call its add() method, it will call the appropriate implementation of add(), based on whether it is a HashSet or a LinkedHashSet. This is called polymorphism.

- Method overloading is defining several methods in the same class, that accept different numbers and types of parameters. In this case, the actual method called is decided at compile-time, based on the number and types of arguments. For instance, the method System.out.println() is overloaded, so that you can pass ints as well as Strings, and it will call a different version of the method.


#### 16. What are the Types of Exception

Checked Exception:

- The classes which directly inherit Throwable class except RuntimeException and Error are known as checked exceptions 
e.g. IOException, SQLException etc. Checked exceptions are checked at compile-time.

Unchecked Exception:

- The classes which inherit RuntimeException are known as unchecked exceptions 
e.g.     ArithmeticException,
	 NullPointerException,
	 ArrayIndexOutOfBoundsException etc. 
- Unchecked exceptions are not checked at compile-time, but they are checked at runtime.
