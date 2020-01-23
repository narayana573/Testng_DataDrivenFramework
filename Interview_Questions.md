#### What is Abstract and Interface?

An abstract class is a class that is only partially implemented by the programmer. It may contain one or more abstract methods. 
An abstract method is simply a function definition that serves to tell the programmer that the method must be implemented in a child class.

An interface is like an abstract class; indeed, interfaces occupy the same namespace as classes and abstract classes. For that reason, you cannot define an interface with the same name as a class. An interface is a fully abstract class; none of its methods are implemented and instead of a class sub-classing from it, it is said to implement that interface.

- Abstract class doesn't support multiple inheritance. Abstract class can provide the implementation of interface.

- Interface supports multiple inheritance. Interface can't provide the implementation of abstract class.
