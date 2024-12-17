import java.util.ArrayList;
import java.util.Scanner;

class CarOperations {
    private String registrationNumber;
    private String model;
    private String owner;

    public void setDetails(String regNo, String model, String owner) {
        this.registrationNumber = regNo;
        this.model = model;
        this.owner = owner;
    }

    public void displayDetails() {
        System.out.println("\u001B[32m--- Car Details ---\u001B[0m");
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Car Model: " + model);
        System.out.println("Owner Name: " + owner);
    }

    public void scheduleService(String serviceType) {
        System.out.println("\nService Scheduled: " + serviceType);
        System.out.println("Thank you, " + owner + "! Your car (" + model + ") is scheduled for " + serviceType + ".");
    }

    public int calculateServiceCost(String serviceType) {
        int cost;
        switch (serviceType.toLowerCase()) {
            case "car wash":
                cost = 500;
                break;
            case "oil change":
                cost = 1500;
                break;
            case "full service":
                cost = 3000;
                break;
            default:
                System.out.println("\u001B[31mInvalid service type selected.\u001B[0m");
                return -1;
        }
        return cost;
    }
}

class ServiceRecord<T> {
    private T recordData;

    public ServiceRecord(T recordData) {
        this.recordData = recordData;
    }

    public void displayRecord() {
        System.out.println("\u001B[32mRecord Data: \u001B[0m" + recordData);
    }
}

public class ServiceInt {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> serviceHistory = new ArrayList<>();
    
    public static void main(String[] args) {
        CarOperations car = new CarOperations();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n\u001B[34m===============================\u001B[0m");
            System.out.println("\u001B[36m Welcome to the SmartCarCare System \u001B[0m");
            System.out.println("\u001B[34m===============================\u001B[0m");
            System.out.println("1. Enter Car Details");
            System.out.println("2. Schedule Service");
            System.out.println("3. View Service History");
            System.out.println("4. Exit");
            System.out.print("\u001B[33mEnter your choice: \u001B[0m");

            int choice = validateIntegerInput();

            switch (choice) {
                case 1:
                    enterCarDetails(car);
                    break;
                case 2:
                    scheduleCarService(car);
                    break;
                case 3:
                    viewServiceHistory();
                    break;
                case 4:
                    System.out.println("\u001B[32mThank you for using SmartCarCare. Goodbye!\u001B[0m");
                    exit = true;
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }
        scanner.close();
    }

    private static void enterCarDetails(CarOperations car) {
        System.out.print("\u001B[33mEnter Car Registration Number: \u001B[0m");
        String regNo = scanner.nextLine();
        System.out.print("\u001B[33mEnter Car Model: \u001B[0m");
        String model = scanner.nextLine();
        System.out.print("\u001B[33mEnter Owner Name: \u001B[0m");
        String owner = scanner.nextLine();
        car.setDetails(regNo, model, owner);

        System.out.println("\u001B[32mCar details successfully added!\u001B[0m");
        car.displayDetails();
    }

    private static void scheduleCarService(CarOperations car) {
        System.out.print("\u001B[33mEnter Service Type (Car Wash/Oil Change/Full Service): \u001B[0m");
        String serviceType = scanner.nextLine();

        int cost = car.calculateServiceCost(serviceType);
        if (cost != -1) {
            car.scheduleService(serviceType);
            System.out.println("\u001B[32mThe cost for " + serviceType + " is: \u001B[31m₹" + cost + "\u001B[0m");

            // Add service record to history
            serviceHistory.add("Service: " + serviceType + " | Cost: ₹" + cost);
            System.out.println("\u001B[32mService record added successfully!\u001B[0m");
        }
    }

    private static void viewServiceHistory() {
        System.out.println("\u001B[36m--- Service History ---\u001B[0m");
        if (serviceHistory.isEmpty()) {
            System.out.println("\u001B[33mNo service records available.\u001B[0m");
        } else {
            for (String record : serviceHistory) {
                System.out.println("\u001B[32m" + record + "\u001B[0m");
            }
        }
    }

    private static int validateIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return input;
    }
}
