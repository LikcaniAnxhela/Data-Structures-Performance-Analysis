# Data Structures Word Analyzer

## Overview

This project was developed as part of the **Data Structures** course and focuses on the implementation, testing, and analysis of several fundamental data structures in Java.

The project is divided into two parts:

* **Part 1:** Linked Lists and List Operations
* **Part 2:** Trees, Hash Tables, and Performance Analysis

A dataset containing **10,000 words** was used throughout the project to test the functionality and efficiency of the implemented data structures.

---

## Features

### Part 1 – Linked Lists

* Read and process 10,000 words from a text file
* Store words in a Singly Linked List
* Store words in a Doubly Linked List
* Implement Union operation
* Implement Intersection operation
* Implement a Doubly Linked List with Header but No Tail
* Implement a Doubly Linked List with Tail but No Header
* Test all list implementations and operations

### Part 2 – Trees and Hash Tables

* Binary Search Tree (BST)
* AVL Tree (Balanced Binary Search Tree)
* Hash Table implementation
* Insert operation analysis
* Search operation analysis
* Delete operation analysis
* Hash distribution analysis
* Performance comparison between data structures

---

## Data Structures Implemented

### Singly Linked List

Each node stores:

* Data
* Reference to the next node

Used for storing and processing the dictionary words.

### Doubly Linked List

Each node stores:

* Data
* Reference to previous node
* Reference to next node

Allows traversal in both directions.

### Binary Search Tree (BST)

A hierarchical structure where:

* Smaller values are stored in the left subtree
* Larger values are stored in the right subtree

Operations implemented:

* Insert
* Search
* Delete

### AVL Tree

A self-balancing Binary Search Tree that automatically maintains balance after insertions and deletions using rotations.

Operations implemented:

* Insert
* Search
* Delete

### Hash Table

Stores data using a hash function.

Features:

* Fast insertion
* Fast searching
* Fast deletion
* Hash distribution analysis

---

## Project Structure

```text
src
│
├── weiss
│   ├── util
│   │   ├── SinglyLinkedList.java
│   │   ├── DoubleLinkedList.java
│   │   ├── DoubleLinkedListHeaderNoTail.java
│   │   ├── DoubleLinkedListTailNoHeader.java
│   │   └── TextFileReader.java
│   │
│   └── nonstandart
│       └── TestProgram.java
│
├── ProjectPart2
│   ├── SimpleBST.java
│   ├── SimpleAVLTree.java
│   ├── SimpleHashTable.java
│   ├── Part2FileReader.java
│   └── ProjectPart2Test.java
│
└── data
    └── words.txt
```

## Experimental Results

The performance of the three main data structures was measured using Java's:

```java
System.nanoTime()
```

The following operations were tested:

* Insert
* Search
* Remove

### Example Results

| Data Structure | Insert   | Search   | Remove   |
| -------------- | -------- | -------- | -------- |
| BST            | Measured | Measured | Measured |
| AVL Tree       | Measured | Measured | Measured |
| Hash Table     | Measured | Measured | Measured |

The Hash Table achieved the best overall performance during testing, while the AVL Tree provided more consistent performance than the regular BST due to automatic balancing.

---

## Hash Distribution Analysis

The Hash Table size was chosen to be twice the number of words:

```text
10,000 words
20,000 table positions
```

The project analyzed:

* Positions hashed zero times
* Positions hashed once
* Positions hashed twice
* Positions hashed multiple times

This analysis helped evaluate the effectiveness of the hash function and the overall distribution of data within the table.

---

## Technologies Used

* Java
* NetBeans
* Maven
* Object-Oriented Programming
* Data Structures and Algorithms

---

## Learning Outcomes

Through this project I gained practical experience with:

* Linked Lists
* Binary Search Trees
* AVL Trees
* Hash Tables
* Hashing Techniques
* Tree Rotations
* Algorithm Analysis
* Performance Measurement
* Time Complexity Evaluation

---

## Author

**Anxhela Likcani**

Software Engineering Student

University of New York Tirana (UNYT)

Academic Year 2025–2026
