# Collections Framework


#### What are the classes implementing List and Set interface?

> Class implementing List interface :  ArrayList, LinkedList, Vector

> Class implementing Set interface :  HashSet, TreeSet, LinkedHashSet

> Class implementing Map interface :  HashMap, HashTable, TreeMap


Sure! Here's the complete Markdown content in copyable format, including three section titles for diagrams and Java code examples with their expected outputs:

# Java Collections Framework Overview

## 1. Interface and Class Hierarchy

### Diagram 1: Overall Collection Framework Hierarchy
![Collection Diagram 1](attachment:image1.png)

### Diagram 2: List Interface and Implementations
![Collection Diagram 2](attachment:image2.png)

### Diagram 3: Set and Queue Hierarchy
![Collection Diagram 3](attachment:image3.png)

---

## 2. Java Code Examples

### Example 1: List (ArrayList)
```java
import java.util.ArrayList;
public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println(list);
    }
}

Output:

[Apple, Banana, Cherry]

Example 2: Queue (PriorityQueue)

import java.util.PriorityQueue;
public class QueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(30);
        queue.add(10);
        queue.add(20);
        System.out.println(queue);
    }
}

Output (Order may vary based on internal heap):

[10, 30, 20]

Example 3: Set (HashSet)

import java.util.HashSet;
public class SetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Dog");
        System.out.println(set);
    }
}

Output (Order not guaranteed, duplicates removed):

[Cat, Dog]


---
