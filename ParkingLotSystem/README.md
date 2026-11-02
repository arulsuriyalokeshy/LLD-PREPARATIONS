# Parking Lot Management System

A console-based Parking Lot Management System developed using Java. This project demonstrates Object-Oriented Programming (OOP), data structures, vehicle management, parking spot allocation, ticket generation, and parking fee calculation.

The project is designed as a beginner-friendly Low-Level Design (LLD) practice exercise for software engineering interviews.

## Features

- **Park Vehicle:** Supports Bikes, Cars, and Trucks.
- **Automatic Spot Allocation:** Assigns an available spot matching the vehicle type.
- **Ticket Generation:** Generates a unique ticket ID for every parking session.
- **Remove Vehicle:** Allows vehicles to exit using their registration number.
- **Parking Fee Calculation:** Calculates fees based on vehicle type and parking duration.
- **Parking Status:** Displays available and occupied parking spots.
- **Duplicate Entry Validation:** Prevents the same vehicle from being parked twice.
- **Input Validation:** Handles invalid vehicle types and empty registration numbers.

## Tech Stack

- **Programming Language:** Java
- **JDK:** Java 8 or later
- **Data Structures:** ArrayList, HashMap
- **Interface:** Command-Line Interface (CLI)
- **IDE:** Visual Studio Code / IntelliJ IDEA / Eclipse

## Project Structure

```text
ParkingLotManagementSystem/
├── ParkingLotSystem.java
└── README.md
```

## Class Overview

| Class | Responsibility |
|---|---|
| `Vehicle` | Stores vehicle registration number and type |
| `ParkingSpot` | Manages parking spot details and availability |
| `Ticket` | Stores ticket ID, vehicle details, spot ID and entry time |
| `ParkingLot` | Handles parking, vehicle exit, spot allocation and fee calculation |
| `ParkingLotSystem` | Provides the main menu and user interaction |

## Parking Configuration

The system initially supports five parking spots:

| Spot ID | Vehicle Type |
|---|---|
| 1 | Bike |
| 2 | Bike |
| 3 | Car |
| 4 | Car |
| 5 | Truck |

Vehicles can only occupy parking spots matching their vehicle type.

## Getting Started

### Prerequisites

Install Java Development Kit (JDK) 8 or later.

Verify your Java installation:

```bash
java -version
javac -version
```

### Installation

**1. Clone the repository**

```bash
git clone <YOUR_REPOSITORY_URL>
cd ParkingLotManagementSystem
```

**2. Compile the Java program**

```bash
javac ParkingLotSystem.java
```

**3. Run the application**

```bash
java ParkingLotSystem
```

## Application Menu

```text
===== PARKING LOT SYSTEM =====
1. Park Vehicle
2. Remove Vehicle
3. Display Parking Spots
4. Exit

Enter choice:
```

## Sample Execution

### 1. Park a Vehicle

```text
Enter choice: 1

Enter vehicle number: TN01AB1234
Enter type (BIKE/CAR/TRUCK): CAR

Vehicle parked successfully!
Spot ID: 3
Ticket ID: 1
```

### 2. Display Parking Status

```text
--- PARKING STATUS ---

Spot 1 | Type: BIKE | Status: AVAILABLE
Spot 2 | Type: BIKE | Status: AVAILABLE
Spot 3 | Type: CAR | Status: OCCUPIED (TN01AB1234)
Spot 4 | Type: CAR | Status: AVAILABLE
Spot 5 | Type: TRUCK | Status: AVAILABLE
```

### 3. Remove a Vehicle

```text
Enter choice: 2

Enter vehicle number: TN01AB1234

Vehicle exited successfully!
Parking duration: 5 minute(s)
Parking fee: Rs.100
```

*Note: Parking duration and fees depend on the actual execution time.*

## Parking Fee Structure

The current implementation calculates fees per minute.

| Vehicle Type | Rate per Minute |
|---|---:|
| Bike | Rs.10 |
| Car | Rs.20 |
| Truck | Rs.30 |

**Formula:**

Parking Fee = Parking Duration (minutes) × Vehicle Rate

## Concepts Demonstrated

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Composition and object relationships
- Java Collections Framework
- `ArrayList` for parking spot management
- `HashMap` for active ticket lookup
- CRUD-like operations
- Conditional statements and loops
- Input validation
- Time-based fee calculation
- Basic exception-free business logic

## Time Complexity

Let `n` represent the total number of parking spots.

| Operation | Time Complexity |
|---|---|
| Find available parking spot | O(n) |
| Park vehicle | O(n) |
| Find active ticket | O(1) average |
| Remove vehicle | O(n) |
| Display parking status | O(n) |

## Current Limitations

- Supports only a single-floor parking lot.
- Parking spots are assigned according to exact vehicle types.
- Parking records are stored in memory.
- Data is lost when the application exits.
- No payment gateway integration.
- No concurrent vehicle allocation handling.
- Pricing is calculated per minute.

## Future Enhancements

- Support multiple parking floors.
- Implement different parking spot sizes.
- Add database or file-based persistence.
- Implement configurable pricing strategies.
- Add concurrency control for simultaneous parking requests.
- Generate detailed parking receipts.
- Introduce interfaces and design patterns.
- Add unit testing using JUnit.

## Learning Objectives

The objective of this project is to understand how to design a real-world parking management application using Java and OOP principles.

It provides practical experience in class relationships, object responsibilities, data structure selection, business logic implementation, and LLD interview problem-solving.

## Author

**Suriya Prakash**

Cybersecurity Engineering Student | Aspiring Software Development Engineer

## License

This project is intended
