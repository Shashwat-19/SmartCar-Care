# **SmartCarCare - Car Service Management System**

## **Overview**

**SmartCarCare** is a simple and efficient car service management system built using Java. It allows users to:
- Enter and store car details such as registration number, model, and owner name.
- Schedule car services such as Car Wash, Oil Change, or Full Service with calculated costs.
- Maintain a service history log for tracking previous services.

This program demonstrates **object-oriented programming** principles, custom methods, and input validation while providing a clean console-based interface with enhanced user experience.

---

## **Features**

1. **Car Details Management**
   - Input and display car details, including registration number, car model, and owner name.

2. **Service Scheduling**
   - Schedule services for the car, including:
     - Car Wash: ₹500
     - Oil Change: ₹1500
     - Full Service: ₹3000
   - Display service costs dynamically.

3. **Service History Log**
   - Maintain a log of scheduled services, showing service type and cost.

4. **Robust Input Validation**
   - Prevents invalid inputs during menu selection and ensures user-friendly interaction.

5. **Clean Console UI**
   - Uses ANSI color codes for a visually appealing user interface.

---

## **Technologies Used**

- **Programming Language:** Java
- **Concepts Demonstrated:** OOP (Object-Oriented Programming), Generics, Input Validation, Data Storage (ArrayList)

---

## **How to Run**

1. **Prerequisites**
   - Install the latest version of [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Set up `javac` and `java` in your environment path.

2. **Run the Code**
   - Copy the code into a file named `ServiceInt.java`.
   - Open a terminal/command prompt and navigate to the directory containing the file.
   - Compile the program:
     ```bash
     javac ServiceInt.java
     ```
   - Run the program:
     ```bash
     java ServiceInt
     ```

3. **Follow the Menu**
   - The program displays a menu with options:
     - Enter car details
     - Schedule a car service
     - View service history
     - Exit the program

---

## **Sample Interaction**

```plaintext
================================
 Welcome to the SmartCarCare System 
================================
1. Enter Car Details
2. Schedule Service
3. View Service History
4. Exit
Enter your choice: 1
Enter Car Registration Number: KA01AB1234
Enter Car Model: Tesla Model S
Enter Owner Name: John Doe

Car details successfully added!
--- Car Details ---
Registration Number: KA01AB1234
Car Model: Tesla Model S
Owner Name: John Doe

Enter your choice: 2
Enter Service Type (Car Wash/Oil Change/Full Service): Car Wash
Service Scheduled: Car Wash
Thank you, John Doe! Your car (Tesla Model S) is scheduled for Car Wash.
The cost for Car Wash is: ₹500
Service record added successfully!

Enter your choice: 3
--- Service History ---
Service: Car Wash | Cost: ₹500

Enter your choice: 4
Thank you for using SmartCarCare. Goodbye!
```

---

## **Code Structure**

- **`CarOperations`**: Handles car details, displays car information, and manages service scheduling with cost calculation.
- **`ServiceRecord<T>`**: A generic class for potential future extensibility to store different types of records.
- **`ServiceInt`**: The main class that drives the program, including:
  - Menu-driven system.
  - Service history stored using an `ArrayList`.
  - Input validation for smooth execution.

---

## **Enhancements**

Future improvements to consider:
- **Persistent Storage**: Save service records to a file or database for long-term storage.
- **Multi-Car Support**: Allow management of multiple cars simultaneously.
- **Advanced Services**: Add more car service options.
- **GUI Interface**: Build a graphical user interface for better user experience.

---

## **Contributing**

Contributions are welcome! Feel free to:
- Fork this repository.
- Create feature branches.
- Submit a pull request with your updates or fixes.


---

## **Author**

**Shashwat**  
BCA (Hons), Christ University, Bangalore  
[GitHub Profile](https://github.com/Shashwat-19) | [LinkedIn](https://www.linkedin.com/in/shashwatk1956/)


