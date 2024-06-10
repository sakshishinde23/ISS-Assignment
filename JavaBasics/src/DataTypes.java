import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Car{
	String name;
}

public class DataTypes{
	
		// Creating a Logger instance
		private static final Logger logger = LogManager.getLogger(DataTypes.class);
		
		public static void main(String[] args) {
			
		//Demonstrating Different Primitive Data Types
		byte byteValue1 = 2;
	    byte byteValue2 = 4;
	    byte byteResult = (byte)(byteValue1 + byteValue2);
	    logger.info("Byte: " + byteResult);
	    
	    short shortValue1 = 2;
	    short shortValue2 = 4;
	    short shortResult = (short)(shortValue1 + shortValue2);
        logger.info("Short: " + shortResult);

        int intValue1 = 2;
	    int intValue2 = 4;
	    int intResult = intValue1 + intValue2;
	    logger.info("Int: " + intResult);

	    long longValue1 = 2L;
	    long longValue2 = 4L;
	    long longResult = longValue1 + longValue2;
	    logger.info("Long: " + longResult);

	    float floatValue1 = 2.0f;
	    float floatValue2 = 4.0f;
	    float floatResult = floatValue1 + floatValue2;
	    logger.info("Float: " + floatResult);

	    double doubleValue1 = 2.0;
	    double doubleValue2 = 4.0;
	    double doubleResult = doubleValue1 + doubleValue2;
	    logger.info("Double: " + doubleResult);

	    boolean booleanValue = true;
	    logger.info("Boolean: " + booleanValue);

	    char charValue = 'A';
	    logger.info("Char: " + charValue);   
	    
	    //Demonstrating reference (or, object) data types.
	    
	    // Creating an object of 'Car' class
	    Car car = new Car();
	    car.name="Honda";
	    logger.info("Car name is " + car.name);

	    // Creating an object of 'String' class
	    String myString = new String("Hello, World!");
	    logger.info(myString);
	   }
	}
