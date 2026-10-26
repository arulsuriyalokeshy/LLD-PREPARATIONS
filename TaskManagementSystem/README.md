# Task Management System

A simple, console-based Task Management System built using Java. This project demonstrates core Object-Oriented Programming (OOP) concepts, collection handling, input validation, and CRUD operations. It is designed as a beginner-friendly Low-Level Design (LLD) practice project for software engineering interviews.

## Features

- **Add Task:** Create tasks with a title and priority.
- **List Tasks:** Display all existing tasks.
- **Update Task:** Modify the title of an existing task.
- **Complete Task:** Mark a task as completed.
- **Delete Task:** Remove a task using its ID.
- **Search by Status:** Filter tasks by `PENDING` or `COMPLETED`.
- **Input Validation:** Handle invalid task IDs, priorities, and empty titles.
- **Unique Task IDs:** Automatically assign an ID to each new task during execution.

## Tech Stack

- **Language:** Java
- **JDK:** Java 8 or later
- **Data Structure:** `ArrayList`
- **Interface:** Command-line interface (CLI)
- **IDE:** IntelliJ IDEA, Eclipse, or Visual Studio Code

## Project Structure

```text
TaskManagementSystem/
├── TaskManagementSystem.java
└── README.md
```

### Class Overview

| Component | Responsibility |
|---|---|
| `Task` | Stores task ID, title, priority, and status |
| `TaskManagementSystem` | Handles the menu, task operations, and user input |
| `ArrayList<Task>` | Stores tasks in memory |

## Getting Started

### Prerequisites

Install the Java Development Kit (JDK) and ensure `java` and `javac` are available in your terminal.

Verify your installation:

```bash
java -version
javac -version
```

### Installation and Execution

**1. Clone the repository**

Replace the placeholder with your actual GitHub repository URL.

```bash
git clone <YOUR_REPOSITORY_URL>
cd TaskManagementSystem
```

**2. Compile the Java source file**

```bash
javac TaskManagementSystem.java
```

**3. Run the application**

```bash
java TaskManagementSystem
```

Alternatively, open `TaskManagementSystem.java` in your Java IDE and run its `main()` method.

## Usage

When the application starts, a menu appears:

```text
===== TASK MANAGEMENT SYSTEM =====
1. Add Task
2. List Tasks
3. Update Task
4. Complete Task
5. Delete Task
6. Search by Status
7. Exit

Choose an option:
```

### Example

Add a new task:

```text
Choose an option: 1
Enter task title: Prepare for Zoho LLD
Enter priority (LOW/MEDIUM/HIGH): HIGH
Task added successfully.
```

List tasks:

```text
Choose an option: 2
ID: 1 | Title: Prepare for Zoho LLD | Priority: HIGH | Status: PENDING
```

Complete the task:

```text
Choose an option: 4
Enter task ID: 1
Task completed successfully.
```

## Concepts Demonstrated

- Object-Oriented Programming
- Classes, objects, and constructors
- Encapsulation fundamentals
- Java Collections Framework
- CRUD operations
- Conditional statements and loops
- Input validation and exception handling
- Basic method decomposition and modularity
- Time complexity analysis

## Time Complexity

Let `n` be the number of tasks.

| Operation | Time Complexity |
|---|---|
| Add task | O(1) amortized |
| List tasks | O(n) |
| Find task by ID | O(n) |
| Update task | O(n) |
| Complete task | O(n) |
| Delete task | O(n) |
| Search by status | O(n) |

The time complexity of adding a task assumes the next ID is assigned directly and the `ArrayList` does not need to resize.

## Current Limitations

- Tasks are stored in memory and are lost when the application exits.
- Only task titles can be updated.
- Task priority cannot currently be modified after creation.
- The application supports a single local user.
- There is no graphical interface or database integration.

## Future Enhancements

- Persist tasks using file handling or a database.
- Separate the application into model, service, and repository classes.
- Add task descriptions, due dates, and categories.
- Support priority-based sorting and filtering.
- Add unit tests using JUnit.
- Implement a graphical interface or REST API.
- Improve input validation and automated testing.

## Learning Objective

The objective of this project is to understand how to design and implement a small Java application using OOP principles, collections, validation, and CRUD operations while building a foundation for more advanced LLD interview problems.

## Author

**Suriya Prakash**

Cybersecurity Engineering Student | Aspiring Software Development Engineer

## License

This project is available for educational and learning purposes.
