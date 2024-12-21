# SmartCarCare - Car Service Management System

## Overview

**SmartCarCare** is a robust car service management system developed using Java. It enables users to register cars, schedule services, and track service history with a user-friendly console interface. Designed with object-oriented programming principles, it ensures seamless operation and robust input validation.

---

## Features

### 1. Car Registration
- Add details such as registration number, car model, owner name, and model year.
- Ensures uniqueness of car entries using a `HashSet`.

### 2. Service Scheduling
- Book car services:
  - **Car Wash**: ₹500
  - **Car Paint**: ₹2000
  - **Full Service**: ₹5000
- Automatically calculates and displays the cost for the selected service.

### 3. Service History
- Maintain a comprehensive log of scheduled services.
- View past service records categorized by car registration numbers.

### 4. User Authentication
- Login with username and password to access the system.

### 5. Robust Input Validation
- Ensures valid entries for menu navigation and form inputs.

### 6. Enhanced Console UI
- Uses ANSI color codes to provide a visually appealing interface.

---

## Technologies Used

- **Programming Language:** Java
- **Core Concepts:** Object-Oriented Programming (OOP), Data Structures (ArrayList, HashSet), Input Validation

---

## How to Run

### 1. Prerequisites
- Install the latest version of [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- Configure `javac` and `java` in your system's environment path.

### 2. Steps to Execute
1. Save the code in a file named `ServiceInt.java`.
2. Open a terminal or command prompt and navigate to the file's directory.
3. Compile the program:
   ```bash
   javac ServiceInt.java
   ```
4. Run the program:
   ```bash
   java ServiceInt
   ```

### 3. Follow the Menu
- Options include:
  - Register a car
  - View car details
  - Schedule a service
  - View service history
  - Exit the program

---

## Sample Interaction

```plaintext
===============================
 Welcome to SmartCarCare System 
===============================

Enter Username: admin
Enter Password: 1234

Login Successful!

1. Register Car
2. Check Car Details
3. Schedule Service
4. View Service History
5. Exit
Enter your choice: 1
Enter Your Name: Shashwat
Enter Car Registration Number: KA01AB1234
Enter Car Model: Tesla Model S
Enter Owner Name: Shashwat
Enter Model Year: 2023

Car successfully registered!
--- Car Details ---
Hello, Shashwat
Registration Number: KA01AB1234
Car Model: Tesla Model S
Owner Name: Shashwat
Model Year: 2023

Enter your choice: 3
Enter Car Registration Number: KA01AB1234
Choose Service Type:
1. Car Wash - ₹500
2. Car Paint - ₹2000
3. Full Service - ₹5000
Enter your choice: 2
Service successfully scheduled!
Service Scheduled: Car Paint
Cost: ₹2000

Enter your choice: 4
--- Service History ---
Registration Number: KA01AB1234
Service Scheduled: Car Paint
Cost: ₹2000

Enter your choice: 5
Thank you for using SmartCarCare. Goodbye!
```

---

## File Structure

- **ServiceInt.java**: The main program file containing all the functionality, including car registration, service scheduling, and history tracking.

---

## Contributing

Contributions are welcome! If you'd like to enhance the project or fix any issues, follow these steps:
1. Fork the repository.
2. Create a new feature branch.
3. Commit your changes.
4. Open a pull request.

---

## Author

**Shashwat**  
BCA (Hons), Christ University, Bangalore  
[GitHub Profile](https://github.com/Shashwat-19) | [LinkedIn](https://www.linkedin.com/in/shashwatk1956/)

---

## License

This project is licensed under the MIT License.
