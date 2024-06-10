import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Vehicle {
    private static final Logger logger = LogManager.getLogger(Vehicle.class);

    private String type;
    private int wheels;
    private double price;

    // Default constructor
    public Vehicle() {
        this.type = "Unknown";
        this.wheels = 0;
        this.price = 0.0;
        logger.info("Default constructor called: Type set to {}, Wheels set to {}, Price set to {}", type, wheels, price);
    }

    // Parameterized constructor
    public Vehicle(String type, int wheels, double price) {
        this.type = type;
        this.wheels = wheels;
        this.price = price;
        logger.info("Parameterized constructor called: Type set to {}, Wheels set to {}, Price set to {}", type, wheels, price);
    }

    // Copy constructor
    public Vehicle(Vehicle another) {
        this.type = another.type;
        this.wheels = another.wheels;
        this.price = another.price;
        logger.info("Copy constructor called: Type set to {}, Wheels set to {}, Price set to {}", type, wheels, price);
    }

    // Overloaded constructor with different parameters
    public Vehicle(String type, int wheels) {
        this(type, wheels, 0.0);  // Calling another constructor
        logger.info("Overloaded constructor with two parameters called: Type set to {}, Wheels set to {}", type, wheels);
    }

    // Method to display vehicle information
    public void displayInfo() {
        logger.info("Vehicle type: {}, Wheels: {}, Price: {}", type, wheels, price);
    }
}

public class Constructor {
    private static final Logger logger = LogManager.getLogger(Constructor.class);

    public static void main(String[] args) {
        // Create instance using default constructor
        Vehicle vehicle1 = new Vehicle();
        vehicle1.displayInfo();

        // Create instance using parameterized constructor
        Vehicle vehicle2 = new Vehicle("Car", 4, 15000.0);
        vehicle2.displayInfo();

        // Create instance using copy constructor
        Vehicle vehicle3 = new Vehicle(vehicle2);
        vehicle3.displayInfo();

        // Create instance using overloaded constructor
        Vehicle vehicle4 = new Vehicle("Bike", 2);
        vehicle4.displayInfo();
    }
}
