import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Cars {
    // Instance variable
    String name;

    // Static variable
    static int numberOfCars = 0;

    // Constructor
    public Cars(String name) {
        this.name = name;
        numberOfCars++;
    }

    // Instance Method
    public void setName(String name) {
        this.name = name;
    }

    // Static method
    public static int getNumberOfCars() {
        return numberOfCars;
    }
}

public class VariableTypes {

    // Creating a Logger instance
    private static final Logger logger = LogManager.getLogger(VariableTypes.class);
    
    public static void main(String[] args) {
    	//Local Variables
    	String myName = "Sakshi";
    	int myAge = 22;
    	
    	logger.info("Local variable myName: " + myName);
    	logger.info("Local variable myAge: " + myAge);
    	
    	// Creating objects of 'Car' class
        Cars car1 = new Cars("Honda");
        Cars car2 = new Cars("Toyota");

        // Logging instance variables
        logger.info("Car 1 name: " + car1.name);
        logger.info("Car 2 name: " + car2.name);

        // Logging static variable
        logger.info("Number of cars: " + Cars.getNumberOfCars());
    }
}