import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class CarOperations {
    private String userName;
    private String registrationNumber;
    private String carModel;
    private String ownerName;
    private int modelYear;

    public CarOperations(String userName, String registrationNumber, String carModel, String ownerName, int modelYear) {
        this.userName = userName;
        this.registrationNumber = registrationNumber;
        this.carModel = carModel;
        this.ownerName = ownerName;
        this.modelYear = modelYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void displayDetails() {
        System.out.println("\u001B[36m--- Car Details ---\u001B[0m");
        System.out.println("Hello, " + userName);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Car Model: " + carModel);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Model Year: " + modelYear);
    }
}

class ServiceOperations {
    private String serviceType;
    private String registrationNumber;
    private int cost;

    public ServiceOperations(String serviceType, String registrationNumber, int cost) {
        this.serviceType = serviceType;
        this.registrationNumber = registrationNumber;
        this.cost = cost;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void displayServiceDetails() {
        System.out.println("\u001B[32mService Scheduled: " + serviceType + "\u001B[0m");
        System.out.println("Cost: \u001B[31m₹" + cost + "\u001B[0m");
    }
}

public class ServiceInt {
    static Scanner scanner = new Scanner(System.in);
    static Set<CarOperations> carDetails = new HashSet<>();
    static ArrayList<ServiceOperations> serviceRecords = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\u001B[34m===============================");
        System.out.println(" Welcome to SmartCarCare System ");
        System.out.println("===============================\u001B[0m");

        // Call login method
        if (!login()) {
            return; // Exit if login fails
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\n\u001B[33m1. Register Car");
            System.out.println("2. Check Car Details");
            System.out.println("3. Schedule Service");
            System.out.println("4. View Service History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: \u001B[0m");

            int choice = validateIntegerInput();

            switch (choice) {
                case 1:
                    registerCar();
                    break;
                case 2:
                    checkCarDetails();
                    break;
                case 3:
                    scheduleService();
                    break;
                case 4:
                    viewServiceHistory();
                    break;
                case 5:
                    System.out.println("\u001B[32mThank you for using SmartCarCare. Goodbye!\u001B[0m");
                    exit = true;
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }
    }

    private static boolean login() {
        System.out.print("\u001B[33mEnter Username: \u001B[0m");
        String username = scanner.nextLine();
        System.out.print("\u001B[33mEnter Password: \u001B[0m");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("\u001B[32mLogin Successful!\u001B[0m");
            return true;
        } else {
            System.out.println("\u001B[31mInvalid Credentials. Exiting...\u001B[0m");
            return false;
        }
    }

    private static void registerCar() {
        System.out.print("\u001B[33mEnter Your Name: \u001B[0m");
        String userName = scanner.nextLine();

        System.out.print("Enter Car Registration Number: ");
        String regNo = scanner.nextLine();

        System.out.print("Enter Car Model: ");
        String carModel = scanner.nextLine();

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter Model Year: ");
        int modelYear = validateIntegerInput();

        CarOperations newCar = new CarOperations(userName, regNo, carModel, ownerName, modelYear);

        if (carDetails.add(newCar)) {
            System.out.println("\u001B[32mCar successfully registered!\u001B[0m");
            newCar.displayDetails();
        } else {
            System.out.println("\u001B[31mCar is already registered!\u001B[0m");
        }
    }

    private static void checkCarDetails() {
        System.out.print("\u001B[33mEnter Car Registration Number to check details: \u001B[0m");
        String regNo = scanner.nextLine();

        boolean found = false;
        for (CarOperations car : carDetails) {
            if (car.getRegistrationNumber().equalsIgnoreCase(regNo)) {
                car.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\u001B[31mCar not found. Please register the car first.\u001B[0m");
        }
    }

    private static void scheduleService() {
        System.out.print("\u001B[33mEnter Car Registration Number: \u001B[0m");
        String regNo = scanner.nextLine();

        boolean carExists = carDetails.stream()
                .anyMatch(car -> car.getRegistrationNumber().equalsIgnoreCase(regNo));

        if (!carExists) {
            System.out.println("\u001B[31mCar not registered! Please register your car first.\u001B[0m");
            return;
        }

        System.out.println("Choose Service Type:");
        System.out.println("1. Car Wash - ₹500");
        System.out.println("2. Car Paint - ₹2000");
        System.out.println("3. Full Service - ₹5000");
        System.out.print("Enter your choice: ");

        int choice = validateIntegerInput();
        String serviceType;
        int cost;

        switch (choice) {
            case 1:
                serviceType = "Car Wash";
                cost = 500;
                break;
            case 2:
                serviceType = "Car Paint";
                cost = 2000;
                break;
            case 3:
                serviceType = "Full Service";
                cost = 5000;
                break;
            default:
                System.out.println("\u001B[31mInvalid service type!\u001B[0m");
                return;
        }

        ServiceOperations service = new ServiceOperations(serviceType, regNo, cost);
        serviceRecords.add(service);

        System.out.println("\u001B[32mService successfully scheduled!\u001B[0m");
        service.displayServiceDetails();
    }

    private static void viewServiceHistory() {
        System.out.println("\u001B[36m--- Service History ---\u001B[0m");
        if (serviceRecords.isEmpty()) {
            System.out.println("\u001B[33mNo service records available.\u001B[0m");
        } else {
            for (ServiceOperations record : serviceRecords) {
                System.out.println("Registration Number: " + record.getRegistrationNumber());
                record.displayServiceDetails();
            }
        }
    }

    private static int validateIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31mInvalid input. Please enter a number.\u001B[0m");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}