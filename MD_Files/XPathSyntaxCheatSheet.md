Here is a complete **XPath Syntax Cheat Sheet** in a tabular format, perfect for quick interview revision.

### 1. Basic & Attribute Based

| Syntax Pattern | Description | Example |
| --- | --- | --- |
| **`//tag[@attr='value']`** | **Standard:** Selects element with exact attribute match. | `//input[@id='email']` |
| **`//*[@attr='value']`** | **Wildcard Tag:** Selects *any* element with this attribute. | `//*[@name='submit']` |
| **`//tag`** | **Tag Only:** Selects all elements of this type. | `//button` |
| **`//tag[@attr1='v1'][@attr2='v2']`** | **Chained:** Selects element matching *both* attributes (same as AND). | `//input[@type='text'][@name='user']` |

### 2. Handling Dynamic Elements (Partial Match)

| Syntax Pattern | Description | Example |
| --- | --- | --- |
| **`//tag[contains(@attr,'val')]`** | **Contains:** Attribute *contains* this value. Best for dynamic IDs. | `//div[contains(@class,'error-msg')]` |
| **`//tag[starts-with(@attr,'val')]`** | **Starts-With:** Attribute *starts* with this value. | `//input[starts-with(@id,'session_')]` |
| **`//tag[ends-with(@attr,'val')]`** | **Ends-With:** *(XPath 2.0 only - rarely supported in browsers directly).* | `//img[ends-with(@src,'.png')]` |

### 3. Text Based Locators

| Syntax Pattern | Description | Example |
| --- | --- | --- |
| **`//tag[text()='Exact']`** | **Exact Text:** Matches visible text perfectly. | `//button[text()='Login']` |
| **`//tag[contains(text(),'Part')]`** | **Partial Text:** Text contains this substring. | `//a[contains(text(),'Forgot')]` |
| **`//tag[.='Text']`** | **Dot:** Shorthand for exact text match (inner text). | `//span[.='Success']` |
| **`//*[text()='Val']`** | **Wildcard Text:** Any tag having this text. | `//*[text()='Welcome']` |

### 4. Logic & Indexing

| Syntax Pattern | Description | Example |
| --- | --- | --- |
| **`//tag[@a='v' and @b='v']`** | **AND:** Both conditions must be true. | `//input[@type='text' and @name='user']` |
| **`//tag[@a='v' or @b='v']`** | **OR:** At least one condition is true. | `//button[@type='submit' or @class='btn']` |
| **`//tag[n]`** | **Index:** Selects the n-th match (index starts at 1). | `//option[2]` |
| **`//tag[last()]`** | **Last:** Selects the last element in the list. | `//tr[last()]` |
| **`//tag[position()<3]`** | **Position:** Selects first 2 items. | `//li[position()<3]` |

### 5. XPath Axes (Traversing the DOM)

Used when the element itself has no unique attributes, so you find it relative to another element.

| Syntax Pattern | Description | Example |
| --- | --- | --- |
| **`//node/parent::tag`** | **Parent:** Go up one level. | `//span[@id='x']/parent::div` |
| **`//node/child::tag`** | **Child:** Go down one level (Direct child). | `//ul[@id='menu']/child::li` |
| **`//node/ancestor::tag`** | **Ancestor:** All parents/grandparents up to root. | `//b/ancestor::form` |
| **`//node/descendant::tag`** | **Descendant:** All children/grandchildren down. | `//table/descendant::td` |
| **`//node/following-sibling::tag`** | **Following Sibling:** Siblings *after* current node. | `//h2/following-sibling::p` |
| **`//node/preceding-sibling::tag`** | **Preceding Sibling:** Siblings *before* current node. | `//td[text()='Price']/preceding-sibling::td` |
| **`//node/following::tag`** | **Following:** Everything in DOM *after* the closing tag. | `//div[@id='header']/following::input` |
