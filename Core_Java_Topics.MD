Core Java Concepts for Interview


---

OOPS Concepts

Encapsulation

Inheritance

Polymorphism (Overloading & Overriding)

Abstraction

Interface



---

Encapsulation

Wrapping up data (variables) and code (methods) into a single unit.

Achieved by declaring variables as private and providing public getter and setter methods.

Improves maintainability, security, and reusability.

Known as Data Hiding.


public class Student {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}


---

Inheritance

A mechanism where one class acquires properties (fields/methods) of another class using extends keyword.

Promotes code reuse and method overriding.

Represents "IS-A" relationship.


Types of Inheritance:

Single

Multilevel

Hierarchical


Advantages:

Reusability

Maintainability

Overriding capability



---

Polymorphism

Compile-time Polymorphism (Overloading):

Same method name with different parameter types or counts.

Resolved at compile time.


public class MathUtils {
  int add(int a, int b) { return a + b; }
  float add(float a, float b) { return a + b; }
}

Run-time Polymorphism (Overriding):

Same method signature in both parent and child class.

Resolved at runtime.


class Animal {
  void sound() {
    System.out.println("Animal sound");
  }
}

class Dog extends Animal {
  void sound() {
    System.out.println("Bark");
  }
}


---

Abstraction

Hiding internal implementation and showing only functionality.

Achieved using abstract classes and interfaces.


abstract class Shape {
  abstract void draw();
}

Cannot instantiate abstract classes.

Can have both abstract and non-abstract methods.



---

Interface

Contract with only abstract methods (Java 8 onwards: can have default and static methods).

Achieved using implements keyword.


interface Animal {
  void sound();
}

class Dog implements Animal {
  public void sound() {
    System.out.println("Bark");
  }
}


---

Access Modifiers in Java

Modifier	Class	Package	Subclass (same pkg)	Subclass (diff pkg)	Outside Class

public	Yes	Yes	Yes	Yes	Yes
protected	Yes	Yes	Yes	Yes	No
default	Yes	Yes	Yes	No	No
private	Yes	No	No	No	No



---

Keywords: this and super

this

Refers to current class object.

Used to:

Access current class variables.

Invoke current class methods/constructors.

Pass current object as argument.



this.name = name;
this(); // constructor chaining

super

Refers to parent class object.

Used to:

Access parent class fields and methods.

Call parent class constructor.



super.name = "Parent";
super(); // constructor chaining


---

Additional Core Java Concepts

Constructor

Special method used to initialize objects.

Same name as class, no return type.

Types:

Default

Parameterized

Copy



Static Keyword

Belongs to the class, not object.

Used with variables, methods, blocks, and nested classes.


Final Keyword

