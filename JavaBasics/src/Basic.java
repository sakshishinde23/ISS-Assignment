import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Plant {
  // Declaring and initializing the attributes
  String type;
  int height; // in 
  String color;

  // Creating a Logger instance
  private static final Logger logger = LogManager.getLogger(Plant.class);

  // methods to set type, height, and color of the plant
  public void setType(String type) {
    this.type = type;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public void setColor(String color) {
    this.color = color;
  }

  // method to print all three values
  public void printDetails() {
    logger.info("Plant details:");
    logger.info("Type: " + this.type);
    logger.info("Height: " + this.height + " cm");
    logger.info("Color: " + this.color);
  }
  
  //Methods to demonstrate instance variables
  public void grow(int cm) {
	  this.height += cm;
	  logger.info("The plant has grown by " + cm + " cm. New height: " + this.height + " cm.");
  }
  public void changeColor(String newColor) {
	    this.color = newColor;
	    logger.info("The plant color has changed to " + this.color + ".");
  }
}

public class Basic {
  public static void main(String[] args) {
	
    // Creating an object of the class Plant
    Plant plant = new Plant();

    // setting the attributes
    plant.setType("Rose");
    plant.setHeight(30);
    plant.setColor("Red");

    // Printing values
    plant.printDetails();
    
   // Grow the plant by 10 cm
    plant.grow(10);

    // Change the color of the plant
    plant.changeColor("Pink");

    // Print final values
    plant.printDetails();
  }
}
