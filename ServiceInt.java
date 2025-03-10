import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

class User {
    private String username;
    private String passwordHash;

    public User(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return passwordHash.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password");
        }
    }
}

class CarOperations {
    private String userName;
    private String registrationNumber;
    private String carModel;
    private String ownerName;
    private int modelYear;
    private String registrationDate;

    public CarOperations(String userName, String regNo, String carModel, String ownerName, int modelYear, String registrationDate) {
        this.userName = userName;
        this.registrationNumber = regNo;
        this.carModel = carModel;
        this.ownerName = ownerName;
        this.modelYear = modelYear;
        this.registrationDate = registrationDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void displayDetails() {
        System.out.println("\u001B[32mCar Details:\u001B[0m");
        System.out.println("Car Model: " + carModel);
        System.out.println("Owner: " + ownerName);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Registration Date: " + registrationDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CarOperations car = (CarOperations) obj;
        return registrationNumber.equals(car.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}

class ServiceOperations {
    private String registrationNumber;
    private String serviceDate;
    private String serviceType;
    private String serviceDescription;

    public ServiceOperations(String regNo, String serviceDate, String serviceType, String serviceDescription) {
        this.registrationNumber = regNo;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.serviceDescription = serviceDescription;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void displayServiceDetails() {
        System.out.println("\u001B[32mService Details:\u001B[0m");
        System.out.println("Service Date: " + serviceDate);
        System.out.println("Service Type: " + serviceType);
        System.out.println("Service Description: " + serviceDescription);
    }
}

public class ServiceInt {
    static Scanner scanner = new Scanner(System.in);
    static Set<CarOperations> carDetails = new HashSet<>();
    static ArrayList<ServiceOperations> serviceRecords = new ArrayList<>();
    static HashMap<String, User> users = new HashMap<>();
    static String currentUser = null;

    public static void main(String[] args) {
        System.out.println("\u001B[34m===============================");
        System.out.println(" Welcome to SmartCarCare System ");
        System.out.println("===============================\u001B[0m");

        if (!authenticateUser()) {
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

    private static boolean authenticateUser() {
        while (true) {
            System.out.println("\u001B[33m1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: \u001B[0m");
            int choice = validateIntegerInput();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> {
                    if (loginUser()) return true;
                }
                case 3 -> {
                    System.out.println("\u001B[32mExiting SmartCarCare System. Goodbye!\u001B[0m");
                    return false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }
    }

    private static void registerUser() {
        System.out.print("\u001B[33mEnter New Username (or type 'exit' to cancel): \u001B[0m");
        String username = scanner.nextLine();
        if (username.equalsIgnoreCase("exit")) return;
        
        if (users.containsKey(username)) {
            System.out.println("\u001B[31mUsername already exists! Try another.\u001B[0m");
            return;
        }
        System.out.print("\u001B[33mEnter New Password: \u001B[0m");
        String password = scanner.nextLine();
        users.put(username, new User(username, password));
        System.out.println("\u001B[32mRegistration Successful!\u001B[0m");
    }

    private static boolean loginUser() {
        System.out.print("\u001B[33mEnter Username (or type 'exit' to cancel): \u001B[0m");
        String username = scanner.nextLine();
        if (username.equalsIgnoreCase("exit")) return false;
        
        System.out.print("\u001B[33mEnter Password: \u001B[0m");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.validatePassword(password)) {
            System.out.println("\u001B[32mLogin Successful!\u001B[0m");
            currentUser = username;
            return true;
        } else {
            System.out.println("\u001B[31mInvalid Credentials. Try again.\u001B[0m");
            return false;
        }
    }

    private static void registerCar() {
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

        CarOperations newCar = new CarOperations(currentUser, regNo, carModel, ownerName, modelYear, registrationDate);
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
            if (car.getRegistrationNumber().equalsIgnoreCase(regNo) && car.getUserName().equals(currentUser)) {
                car.displayDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\u001B[31mCar not found or you don't have access to it.\u001B[0m");
        }
    }

    private static void scheduleService() {
        System.out.println("\u001B[33mFeature to be implemented: Schedule a service\u001B[0m");
    }

    private static void viewServiceHistory() {
        System.out.println("\u001B[33mFeature to be implemented: View service history\u001B[0m");
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