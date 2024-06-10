import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Abstract class 
abstract class City {
    protected static final Logger logger = LogManager.getLogger(City.class);

    private String name;
    private int population;

    // Constructor
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    // Abstract method to be implemented by subclasses
    public abstract void display();

    // Concrete method
    public void displayBasicInfo() {
        logger.info("City Name: {}", name);
        logger.info("Population: {}", population);
    }
}

//Subclass MetropolitanCity
class MetropolitanCity extends City {
 private String landmark;

 // Constructor
 public MetropolitanCity(String name, int population, String landmark) {
     super(name, population); // Call the constructor of the base class
     this.landmark = landmark;
 }

 // Implement the abstract method
 @Override
 public void display() {
     displayBasicInfo();
     logger.info("Landmark: {}", landmark);
 }
}

public class Abstraction {
    private static final Logger logger = LogManager.getLogger(Abstraction.class);

    public static void main(String[] args) {
        // Creating instances of different city types
        City metroCity = new MetropolitanCity("Mumbai", 12500000, "Gateway of India");
        

        // Displaying information about each city
        logger.info("Displaying details of a metropolitan city:");
        metroCity.display();
        }
}