#### 1. What is Abstract and Interface?

An abstract class is a class that is only partially implemented by the programmer. It may contain one or more abstract methods. 
An abstract method is simply a function definition that serves to tell the programmer that the method must be implemented in a child class.

An interface is like an abstract class; indeed, interfaces occupy the same namespace as classes and abstract classes. For that reason, you cannot define an interface with the same name as a class. An interface is a fully abstract class; none of its methods are implemented and instead of a class sub-classing from it, it is said to implement that interface.

- Abstract class doesn't support multiple inheritance. Abstract class can provide the implementation of interface.

- Interface supports multiple inheritance. Interface can't provide the implementation of abstract class.



#### 2. Where do use public, final and static?

Public -

	>Public is a Java keyword which declares a member's access as public.
	>Public members are visible to all other classes. 
	>This means that any other class can access a public field or method. 
	>Further, other classes can modify public fields unless the field is declared as final.

Final -

	>When we apply "final" keyword to a variable, the value of that variable remains constant. 
	>(or) Once we declare a variable as final. the value of that variable cannot be changed.
	>It is useful when a variable value does not change during the life time of a program

Static -

	>when we apply "static" keyword to a variable, it means it belongs to class.
	>When we apply "static" keyword to a method, it means the method can be accessed without creating any instance of the class
	


#### 3. Can you declare a Final class? If yes, where can you use it?

	>Yes, A final class is simply a class that can't be extended.
	>By marking a class as final you disable a powerful and flexible feature of the language for that part of the code. 
	>Some classes however, should not (and in certain cases cannot) be designed to take sub classing into account in a good way. 
	>In these cases, it makes sense to mark the class as final, even though it limits OOPS. 
	>(Remember however that a final class can still extend another non-final class	
