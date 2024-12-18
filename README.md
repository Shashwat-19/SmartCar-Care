# **SmartCarCare - Car Service Management System**

## **Overview**

**SmartCarCare** is a comprehensive car service management system built using Java. It enables users to:
- Register and maintain car details, such as registration number, model, and owner information.
- Schedule car services like Car Wash, Car Paint, or Full Service with predefined costs.
- Track and view service history for easy reference.

The system employs **object-oriented programming** concepts, a user-friendly console interface, and robust input validation to ensure seamless operation.

---

## **Features**

1. **Car Registration**
   - Add car details, including registration number, model, and owner name.
   - Ensure uniqueness of car entries using a `Set`.

2. **Service Scheduling**
   - Book car services:
     - Car Wash: ₹500
     - Car Paint: ₹2000
     - Full Service: ₹5000
   - Automatically calculate and display the cost for each service.

3. **Service History**
   - Maintain a comprehensive log of all scheduled services.
   - View past service records categorized by car registration numbers.

4. **Robust Input Handling**
   - Validate user input to prevent invalid entries during menu navigation and form submissions.

5. **Enhanced Console Design**
   - Incorporates ANSI color codes for an aesthetically pleasing user interface.

---

## **Technologies Used**

- **Programming Language:** Java
- **Key Concepts:** OOP, Data Storage (ArrayList, HashSet), Input Validation, Console UI Design

---

## **How to Run**

1. **Prerequisites**
   - Download and install the latest version of [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Configure `javac` and `java` in your system's environment path.

2. **Run the Code**
   - Save the code in a file named `ServiceInt.java`.
   - Open a terminal or command prompt and navigate to the file directory.
   - Compile the program:
     ```bash
     javac ServiceInt.java
     ```
   - Run the program:
     ```bash
     java ServiceInt
     ```

3. **Follow the Menu**
   - Select from the displayed options to:
     - Register a car
     - View car details
     - Schedule a service
     - View service history
     - Exit the program

---

## **Sample Interaction**

```plaintext
===============================
 Welcome to SmartCarCare System
===============================
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
Enter your choice: 1
Service successfully scheduled!
Service Scheduled: Car Wash
Cost: ₹500

Enter your choice: 4
--- Service History ---
Registration Number: KA01AB1234
Service Scheduled: Car Wash
Cost: ₹500
```
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


