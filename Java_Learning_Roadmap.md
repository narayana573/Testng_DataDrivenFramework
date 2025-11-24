# 📅 Java & OOPs Intensive Learning Schedule (Nov - Dec 2025)

**Goal:** Master Core Java and Object-Oriented Programming for Automation Testing.  
**Start Date:** November 25, 2025  
**Approach:** Theory implementation followed by medium-level logical coding exercises.

---

## 🗓️ Week 1: The Building Blocks

### 🟢 Day 1: Variables, Data Types & Operators
**Date:** Nov 25, 2025 (Tuesday)

#### 📘 Theory
1.  **Data Types:**
    * **Primitive:** `int`, `char`, `boolean`, `byte`, `long`, `double`, `float`, `short`.
    * **Non-Primitive:** `String`, Arrays, Classes.
2.  **Variables:** Local, Instance, and Static variables.
3.  **Operators:** Arithmetic (`+`, `%`), Relational (`==`, `!=`), Logical (`&&`, `||`), Unary (`++`, `--`).

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Type Casting):** Write a program to convert a `double` value (e.g., 100.235) to an `int` and a `char`. Print all three to see data loss.
* **Exercise 2 (Logic Builder):** Create a program to swap two numbers **without** using a third temporary variable.
* **Exercise 3 (Ternary Operator):** Write a program that takes three numbers as input and prints the largest number using only the Ternary operator (`? :`).

---

### 🟢 Day 2: Control Statements (Conditional)
**Date:** Nov 26, 2025 (Wednesday)

#### 📘 Theory
1.  **If-Else & Nested If:** Decision making flow.
2.  **Switch Case:** Handling multiple conditions efficiently.
3.  **Jump Statements:** `break` (exit loop/switch) vs. `continue` (skip current iteration).

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Nested Logic):** Write a program for an ATM.
    * Check if the card is valid.
    * If valid, ask for a PIN.
    * If the PIN is correct, allow specific options (Withdraw/Check Balance).
* **Exercise 2 (Switch Case):** Create a "Calculator" that takes two numbers and an operator (`+`, `-`, `*`, `/`) as characters and performs the operation. Handle the "Divide by Zero" error using an `if` check inside the case.

---

### 🟢 Day 3: Iteration Statements (Loops)
**Date:** Nov 27, 2025 (Thursday)

#### 📘 Theory
1.  **While Loop:** Pre-condition check.
2.  **Do-While Loop:** Post-condition check (executes at least once).
3.  **For Loop:** Standard iteration.
4.  **Enhanced For Loop:** Iterating through collections/arrays easily.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Logic):** Write a program to check if a number is a **Palindrome** (e.g., 121 is a palindrome, 123 is not).
* **Exercise 2 (Pattern Printing):** Print the following pyramid pattern using nested loops:
    ```text
        *
       ***
      *****
     *******
    ```
* **Exercise 3 (Math Logic):** Write a program to find the **Factorial** of a number using a `while` loop.

---

### 🟢 Day 4: Arrays & Memory Management
**Date:** Nov 28, 2025 (Friday)

#### 📘 Theory
1.  **Declaration:** `int[] arr = new int[5];`
2.  **Memory:** Heap memory allocation for arrays.
3.  **Traversal:** Using standard `for` loop vs. `foreach` loop.
4.  **Multidimensional Arrays:** Matrix representation.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Array Manipulation):** Write a program to find the **Second Largest Number** in an integer array without sorting the array.
* **Exercise 2 (Logic):** Write a program to move all `0`s to the end of an array while maintaining the relative order of non-zero elements.
    * Input: `[0, 1, 0, 3, 12]` -> Output: `[1, 3, 12, 0, 0]`

---

## 🗓️ Week 2: Object-Oriented Programming (OOP)

### 🟠 Day 5: Class, Object, Method & Constructor
**Date:** Nov 29, 2025 (Saturday)

#### 📘 Theory
1.  **Class vs Object:** Blueprint vs Instance.
2.  **Constructors:** Default vs Parameterized. usage of `this` keyword.
3.  **Methods:** Return types, Parameters.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Class Design):** Create a class `Student` with `id`, `name`, and `marks`.
    * Create a constructor to initialize these.
    * Create a method `calculateGrade()`: If marks > 90 return 'A', else 'B'.
    * Create 3 objects and print their details.
* **Exercise 2 (Constructors):** Create a class `Rectangle`. Implement two constructors:
    * One taking no parameters (sets length/width to 0).
    * One taking two parameters (length, width).
    * Add a method to calculate Area.

---

### 🟠 Day 6: Encapsulation & Access Modifiers
**Date:** Nov 30, 2025 (Sunday)

#### 📘 Theory
1.  **Access Modifiers:** `private`, `default`, `protected`, `public`. (Scope visibility).
2.  **Encapsulation:** Wrapping data (variables) and code (methods) together.
3.  **Getters & Setters:** Controlling access to private variables.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Secure Data):** Create a `BankAccount` class.
    * Make `accountBalance` private.
    * Create a `deposit(amount)` method (increases balance).
    * Create a `withdraw(amount)` method. (Logic: Check if balance > amount. If not, print "Insufficient Funds").
    * You should **not** be able to change the balance directly from the main class.

---

### 🟠 Day 7: Inheritance
**Date:** Dec 01, 2025 (Monday)

#### 📘 Theory
1.  **Basics:** `extends` keyword. Parent (Super) vs Child (Sub) class.
2.  **Types:** Single, Multilevel, Hierarchical.
3.  **Super Keyword:** Accessing parent class variables/constructors.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Hierarchical):** Create a class `Employee` (base) with `salary`.
    * Create subclass `Developer` (adds `bonus`).
    * Create subclass `QAEngineer` (adds `overtimePay`).
    * Calculate `totalSalary` for both differently inside the specific classes using the parent's salary.

---

### 🟠 Day 8: Polymorphism (Overloading & Overriding)
**Date:** Dec 02, 2025 (Tuesday)

#### 📘 Theory
1.  **Compile-time (Overloading):** Same method name, different parameters.
2.  **Runtime (Overriding):** Same method name and parameters in Parent/Child.
3.  **Rules:** Return types, Access modifiers in overriding.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Overloading):** Create a class `MathUtils`. Write an `add()` method that works for:
    * Two integers.
    * Three integers.
    * Two doubles.
* **Exercise 2 (Overriding):** Create a class `Bank` with a method `getInterestRate()` returning 5%.
    * Create subclasses `SBI`, `HDFC`, `ICICI`.
    * Override `getInterestRate()` in each to return 7%, 8%, and 9% respectively.
    * Call them using Dynamic Method Dispatch (`Bank b = new SBI();`).

---

### 🟠 Day 9: Abstraction (Abstract Classes)
**Date:** Dec 03, 2025 (Wednesday)

#### 📘 Theory
1.  **Concept:** Hiding implementation details, showing functionality.
2.  **Abstract Class:** Can have abstract and non-abstract methods. Cannot be instantiated.
3.  **Keywords:** `abstract`.

#### 💻 Coding Exercises (Medium)
* **Exercise 1:** Create an abstract class `Animal` with:
    * Abstract method `makeSound()`.
    * Concrete method `sleep()` (prints "Zzz").
* Create subclasses `Dog` and `Cat`. Implement `makeSound()` differently (Bark/Meow). Verify that `sleep()` works for both.

---

### 🟠 Day 10: Interface
**Date:** Dec 04, 2025 (Thursday)

#### 📘 Theory
1.  **Concept:** 100% abstraction (before Java 8).
2.  **Keywords:** `interface`, `implements`.
3.  **Multiple Inheritance:** Achieved via Interfaces.

#### 💻 Coding Exercises (Medium)
* **Exercise 1:** Create an interface `WebDriver` with methods `openBrowser()` and `closeBrowser()`.
    * Create classes `Chrome` and `Firefox` that implement this interface.
    * Define the body of the methods to print "Opening Chrome" or "Opening Firefox".
* **Exercise 2 (Multiple Inheritance):** Create interfaces `Flyable` and `Swimmable`. Create a class `Duck` that implements both.

---

## 🗓️ Week 3: Advanced Concepts & Collections

### 🟣 Day 11: ArrayList & Wrapper Classes
**Date:** Dec 05, 2025 (Friday)

#### 📘 Theory
1.  **Wrapper Classes:** `int` vs `Integer`, Autoboxing/Unboxing.
2.  **ArrayList:** Dynamic array, Resizable.
3.  **Methods:** `add`, `get`, `remove`, `size`, `contains`.

#### 💻 Coding Exercises (Medium)
* **Exercise 1:** Create an `ArrayList` of Strings (Names of 5 cities).
    * Iterate using a `foreach` loop.
    * Write logic to remove any city name that starts with the letter 'B'.
* **Exercise 2:** Create an `ArrayList` of Integers. Find the sum and average of all elements.

---

### 🟣 Day 12: LinkedList & Map (HashMap)
**Date:** Dec 06, 2025 (Saturday)

#### 📘 Theory
1.  **LinkedList:** Node-based structure (Head/Tail). Faster manipulation than ArrayList.
2.  **HashMap:** Key-Value pairs. Unique keys.
3.  **Methods:** `put`, `get`, `keySet`, `entrySet`.

#### 💻 Coding Exercises (Medium)
* **Exercise 1 (Map Logic):** Write a program to count the frequency of characters in a String.
    * Input: "PROGAMMING"
    * Output: P=1, R=1, O=1, G=2, A=1, M=2, I=1, N=1
    * *Hint: Use Character as Key and Integer as Value.*

---

### 🟣 Day 13: Exception Handling
**Date:** Dec 07, 2025 (Sunday)

#### 📘 Theory
1.  **Try-Catch-Finally:** Handling runtime errors.
2.  **Exception Hierarchy:** Checked vs Unchecked Exceptions.
3.  **Keywords:** `throw` (create exception) vs `throws` (declare exception).

#### 💻 Coding Exercises (Medium)
* **Exercise 1:** Write a program for Division. Handle `ArithmeticException` (divide by zero) and `InputMismatchException` (if user enters text instead of numbers).
* **Exercise 2:** Create a custom exception called `InvalidAgeException`. Write a program that checks voting eligibility. If age < 18, throw this exception.

---

### 🏆 Day 14: Mini Capstone (Putting it together)
**Date:** Dec 08, 2025 (Monday)

#### 💻 Final Exercise: "Library Management System"
Create a console-based application using the concepts learned:
1.  **Class `Book`:** (Encapsulation) private fields for title, author, ISBN.
2.  **Interface `LibraryOperations`:** methods `addBook()`, `issueBook()`, `returnBook()`.
3.  **Class `Library`:** Implements operations. Use `ArrayList<Book>` to store data.
4.  **Exception:** Throw `BookNotFoundException` if a user tries to issue a book that doesn't exist.
5.  **Main Class:** Use a `Switch` case inside a `While` loop to keep the menu running until the user selects "Exit".

---
