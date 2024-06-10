import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Base class
class Flower {
    private static final Logger logger = LogManager.getLogger(Flower.class);

    // Instance variables
    String name;
    String color;

    // Constructor
    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Method to display flower details
    public void displayInfo() {
        logger.info("Flower Name: {}", name);
        logger.info("Flower Color: {}", color);
    }

    // Method to describe the flower
    public void describe() {
        logger.info("This is a beautiful flower.");
    }
}

// Derived class
class Rose extends Flower {
    private static final Logger logger = LogManager.getLogger(Rose.class);

    // Additional instance variable
    boolean hasThorns;

    // Constructor
    public Rose(String name, String color, boolean hasThorns) {
        super(name, color); // Call the constructor of the base class
        this.hasThorns = hasThorns;
    }

    // Override the describe method
    @Override
    public void describe() {
        logger.info("The rose is known for its beauty and fragrance.");
        if (hasThorns) {
            logger.info("This rose has thorns.");
        } else {
            logger.info("This rose does not have thorns.");
        }
    }

    // Method to display rose details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the base class method
        logger.info("Has Thorns: {}", hasThorns);
    }
}

public class Inheritance {
    private static final Logger logger = LogManager.getLogger(Inheritance.class);

    public static void main(String[] args) {
        // Creating an object of the base class
        Flower flower = new Flower("Lily", "White");
        flower.displayInfo();
        flower.describe();

        // Creating an object of the derived class
        Rose rose = new Rose("Rose", "Red", true);
        rose.displayInfo();
        rose.describe();
    }
}
