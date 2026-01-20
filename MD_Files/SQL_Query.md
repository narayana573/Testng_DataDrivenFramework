

---

### 📋 SQL Joins Reference Sheet

#### 🏗️ Setup Data (Modified for Clarity)

**Orders Table**
| OrderID | CustomerID | OrderDate |
| :--- | :--- | :--- |
| 10308 | 2 | 1996-09-18 |
| 10309 | 37 | 1996-09-19 |
| 10310 | 77 | 1996-09-20 |
| 10311 | NULL | 1996-09-21 |

**Customers Table**
| CustomerID | CustomerName | Country |
| :--- | :--- | :--- |
| 1 | Alfreds Futterkiste | Germany |
| 2 | Ana Trujillo | Mexico |
| 3 | Antonio Moreno | Mexico |

---

### 1. INNER JOIN

**Goal:** Returns records that have matching values in both tables.
**QA Use Case:** To verify that every order displayed in the UI is correctly linked to an existing customer.

```sql
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

```

* **Result:** Only Order `10308` appears because only `CustomerID 2` exists in both tables.

---

### 2. LEFT JOIN (Left Outer Join)

**Goal:** Returns all records from the left table, and the matched records from the right table.
**QA Use Case:** To find **Orphaned Orders** (orders that are not linked to a valid customer).

```sql
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
LEFT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

```

* **Result:** All Orders (10308, 10309, 10310, 10311) are returned. For 10309, 10310, and 10311, the `CustomerName` will be `NULL`.

---

### 3. RIGHT JOIN (Right Outer Join)

**Goal:** Returns all records from the right table, and the matched records from the left table.
**QA Use Case:** To find **Inactive Customers** (customers who have never placed an order).

```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Orders
RIGHT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

```

* **Result:** All Customers (1, 2, 3) are returned. Orders for `1` and `3` will be `NULL`.

---

### 4. FULL OUTER JOIN

**Goal:** Returns all records when there is a match in either left or right table.
**QA Use Case:** **Data Reconciliation.** Used during database migrations to ensure no records were lost on either side (Source vs. Destination).

```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Orders
FULL OUTER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

```

* **Note:** If using MySQL, you simulate this using a `UNION` of a Left and Right join.

---

### 5. SELF JOIN

**Goal:** A regular join, but the table is joined with itself.
**QA Use Case:** Testing **Hierarchical Data** (e.g., an Employees table where one column is `EmployeeID` and another is `ManagerID`).

*Modification for Example:* Let's assume the Customers table had a `ReferredBy` column.

```sql
SELECT A.CustomerName AS Customer, B.CustomerName AS ReferredBy
FROM Customers A, Customers B
WHERE A.ReferredBy = B.CustomerID;

```

---

