# **Library Management System Exercise Instructions**

## **Objective**  
In this exercise, you will build a **Library Management System** using Java. You will practice working with **classes**, **objects**, **ArrayLists**, and **methods** while interacting with a user via a CLI (Command Line Interface).

---

## **Instructions**

### **1. Display Menu**
- Create a method named `displayMenu()` in your main class.
- This method should display the following 4 options:

Library Management System Menu:

1. View Available Books
2. Borrow a Book
3. Return a Book
4. Exit 

---
### **2. Book Class**
- Create a `Book` class with the following attributes:
  - `title` (String)
  - `numberOfPages` (int)
  - `author` (String)
  - `isBestSeller` (boolean)
  - `isAvailable` (boolean)
  
- Generate **setters** and **getters** for all attributes.
- Override the `toString()` method to display book details in a readable format.





### **3. ArrayList of Books**
- In your `Main` class, create a **static** `ArrayList<Book>` named `books`.

---

### **4. Initialize Books**
- Create a method named `initializeBooks()` in your `Main` class.
- This method should:
  - Instantiate **4 different `Book` objects** with appropriate details.
  - Add these `Book` objects to the `books` ArrayList.

---

### **5. View Available Books**
- Create a method named `viewAvailableBooks()`.
- This method should:
  - Loop through the `books` ArrayList.
  - Display details of books that have `isAvailable == true`.

---

### **6. Borrow Book by Title**
- Create a method named `borrowBookByTitle(String title)`.
- This method should:
  - Search for the book by title in the `books` ArrayList.
  - Check if the book is available (`isAvailable == true`).
  - If available, set `isAvailable` to `false` and return:
  You have checked out {title}.


- If the book is not available, return: Sorry, the book "{title}" is currently unavailable.


### **7. Return Book**
- Create a method named `returnBook(String title)`.
- This method should:
- Search for the book by title in the `books` ArrayList.
- If found, set `isAvailable` to `true` and return: You have successfully returned the book. Thank you!



- If the book is not found, return: The book "{title}" was not found in our records.



## **Optional Challenges**
- Add functionality to **display all books** (whether available or not).
- Implement a **search feature** to find books by the author.
- Allow users to **filter books** based on whether they are bestsellers.

