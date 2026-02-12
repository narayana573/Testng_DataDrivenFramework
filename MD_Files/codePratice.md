

## 1 Java String Manipulation: Extracting Order ID

### 📝 Problem Statement

Given a success message string from a customer transaction, extract the specific **Order ID** using the `split()` method. The message format is:
`"Thank you! Your order ID is: ORD-98765-XYZ. Please save it."`

### 💻 Solution

The following Java code demonstrates how to use the `.split()` method twice to isolate the ID from the surrounding text.

```java
package Pratice_2026;

/**
 * A utility class to extract an Order ID from a formatted string.
 * Demonstrates the use of String.split() and String.trim().
 */
public class orderIDExtract {

    public static void main(String[] args) {

        String message = "Thank you! Your order ID is: ORD-98765-XYZ. Please save it.";

        // Step 1: Split the string by "is:" to separate the intro from the ID section
        String[] split1 = message.split("is:");
        
        // split1[0] = "Thank you! Your order ID "
        // split1[1] = " ORD-98765-XYZ. Please save it."
        System.out.println("First Split Part 1: " + split1[0]);
        System.out.println("First Split Part 2: " + split1[1]);

        // Step 2: Split the second part by the period and space ". " to isolate the ID
        // Note: In a regex-based split, "." is a special character, but 
        // in simple contexts, this separates the ID from the closing sentence.
        String[] split2 = split1[1].split(". ");
        
        // Step 3: Use .trim() to remove any leading/trailing whitespace
        System.out.println("Extracted ID: " + split2[0].trim());
        System.out.println("Remaining Text: " + split2[1]);
    }
}

```

### 🔍 Key Concepts

* **`split(String regex)`**: Breaks the string into an array based on the provided delimiter.
* **`trim()`**: Removes leading and trailing whitespace, ensuring the extracted ID is clean.
* **Array Indexing**: Accessing specific parts of the split string using `[0]` and `[1]`.

---

**Quick Tip:** In Java, `split()` uses Regular Expressions. If you find that `.split(".")` isn't working as expected (because `.` matches any character in regex), you might need to escape it as `\\.split("\\. ")`.

Would you like me to show you how to do this same extraction using **Regex (Pattern/Matcher)**, which is often considered a more "robust" way to handle varying string formats?




This is a fantastic addition to your revision notes. Reversing words is a "bread and butter" interview question because it tests your understanding of **Array indexing**, **Loops**, and **String efficiency**.

Here is the structured layout for your `README.md`.

---

## 2. Reverse the Words (Logical Thinking)

### 📝 Scenario

A classic interview favorite designed to test algorithmic logic. The goal is to reverse the order of words in a sentence without using built-in library shortcuts (like `Collections.reverse()`) and without reversing the characters within the words themselves.

### 💡 Logic Flow

1. **Split**: Break the sentence into an array of strings using the space `" "` as a delimiter.
2. **Iterate Backwards**: Start a `for` loop at the last index (`length - 1`) and move toward index `0`.
3. **Build**: Use a `StringBuilder` to append each word. This is more memory-efficient than standard String concatenation in a loop.
4. **Clean up**: Use `.trim()` to remove the trailing space added after the final word.

### 💻 Code Implementation

```java
package Pratice_2026;

/**
 * Interview Question: Reverse the order of words in a string.
 * Input: "I am Surya"
 * Output: "Surya am I"
 */
public class reverseWord {

    public static void main(String[] args) {

        String str = "I am Surya";
        
        // Step 1: Split the string into an array based on spaces
        String[] revword = str.split(" ");
        
        // Step 2: Use StringBuilder for efficient string manipulation
        StringBuilder builder = new StringBuilder();
        
        // Step 3: Loop through the array starting from the last element
        for (int i = revword.length - 1; i >= 0; i--) {
            builder.append(revword[i]);
            
            // Append a space between words
            builder.append(" ");
        }
        
        // Step 4: Convert to string and trim the last extra space
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + builder.toString().trim());
    }
}

```

### 🛠 Why use `StringBuilder`?

In Java, `String` objects are **immutable**. If you use `str = str + revword[i]`, Java creates a brand new String object in memory every single time the loop runs.

* **`String` concatenation**:  complexity in a loop.
* **`StringBuilder`**:  complexity because it modifies the same buffer in memory.

---

### 🚩 Interviewer "Follow-up" Questions

* **Q: What if there are multiple spaces between words?**
* *A: Use `str.split("\\s+")` which matches one or more whitespace characters.*


* **Q: Can you do this in-place?**
* *A: In-place reversal usually requires converting the string to a `char[]`, reversing the whole array, and then reversing each individual word back.*



Would you like me to provide the **In-Place Reversal** version (the more advanced version of this question)?
