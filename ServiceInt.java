import java.util.*;

class CarOperations {
    private String userName;
    private String registrationNumber;
    private String carModel;
    private String ownerName;
    private int modelYear;
    private String registrationDate;

    public CarOperations(String userName, String registrationNumber, String carModel, String ownerName, int modelYear, String registrationDate) {
        this.userName = userName;
        this.registrationNumber = registrationNumber;
        this.carModel = carModel;
        this.ownerName = ownerName;
        this.modelYear = modelYear;
        this.registrationDate = registrationDate;
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
        System.out.println("Registration Date: " + registrationDate);
    }
}

class ServiceOperations {
    private String serviceType;
    private String registrationNumber;
    private int cost;
    private String serviceDate;

    public ServiceOperations(String serviceType, String registrationNumber, int cost, String serviceDate) {
        this.serviceType = serviceType;
        this.registrationNumber = registrationNumber;
        this.cost = cost;
        this.serviceDate = serviceDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void displayServiceDetails() {
        System.out.println("\u001B[32mService Scheduled: " + serviceType + "\u001B[0m");
        System.out.println("Cost: \u001B[31m₹" + cost + "\u001B[0m");
        System.out.println("Service Date: " + serviceDate);
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

        if (!login()) {
            return;
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
                case 1 -> registerCar();
                case 2 -> checkCarDetails();
                case 3 -> scheduleService();
                case 4 -> viewServiceHistory();
                case 5 -> {
                    System.out.println("\u001B[32mThank you for using SmartCarCare. Goodbye!\u001B[0m");
                    exit = true;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
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

        System.out.print("\u001B[33mEnter Car Registration Number: \u001B[0m");
        String regNo = scanner.nextLine();

        System.out.print("\u001B[33mEnter Car Model: \u001B[0m");
        String carModel = scanner.nextLine();

        System.out.print("\u001B[33mEnter Owner Name: \u001B[0m");
        String ownerName = scanner.nextLine();

        System.out.print("\u001B[33mEnter Model Year: \u001B[0m");
        int modelYear = validateIntegerInput();

        System.out.print("\u001B[33mEnter Registration Date (YYYY-MM-DD): \u001B[0m");
        String registrationDate = scanner.nextLine();

        CarOperations newCar = new CarOperations(userName, regNo, carModel, ownerName, modelYear, registrationDate);

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
        System.out.print("\u001B[33mEnter your choice: \u001B[0m");

        int choice = validateIntegerInput();
        String serviceType;
        int cost;

        switch (choice) {
            case 1 -> { serviceType = "Car Wash"; cost = 500; }
            case 2 -> { serviceType = "Car Paint"; cost = 2000; }
            case 3 -> { serviceType = "Full Service"; cost = 5000; }
            default -> { System.out.println("\u001B[31mInvalid service type!\u001B[0m"); return; }
        }

        System.out.print("\u001B[33mEnter Service Date (YYYY-MM-DD): \u001B[0m");
        String serviceDate = scanner.nextLine();

        ServiceOperations service = new ServiceOperations(serviceType, regNo, cost, serviceDate);
        serviceRecords.add(service);

        System.out.println("\u001B[32mService successfully scheduled!\u001B[0m");
        service.displayServiceDetails();
    }

    private static void viewServiceHistory() {
        if (serviceRecords.isEmpty()) {
            System.out.println("\u001B[33mNo service records available.\u001B[0m");
        } else {
            for (ServiceOperations record : serviceRecords) {
                record.displayServiceDetails();
            }
        }
    }

    private static int validateIntegerInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("\u001B[31mInvalid input. Please enter a number.\u001B[0m");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
