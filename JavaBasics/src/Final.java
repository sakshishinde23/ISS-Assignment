import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class FinalDemo {
    // Logger instance
    private static final Logger logger = LogManager.getLogger(FinalDemo.class);

    // final variable - Constant
    public static final int MAX_CAPACITY = 100;

    // Method to demonstrate final variable usage
    public void displayMaxCapacity() {
        logger.info("Maximum capacity is: " + MAX_CAPACITY);
    }

    // final method - Cannot be overridden by subclasses
    public final void showInfo() {
        logger.info("This method cannot be overridden.");
    }

    // final class - Cannot be subclassed
    final class NoInheritance {
        public void showMessage() {
            logger.info("This class cannot be inherited.");
        }
    }
}

class SubDemo extends FinalDemo {
    // Attempting to override a final method results in a compile-time error
    // public void showInfo() {
    //   logger.info("Trying to override.");
    // }
}

public class Final {
    public static void main(String[] args) {
        
        FinalDemo demo = new FinalDemo();
        demo.displayMaxCapacity();
        demo.showInfo();

        FinalDemo.NoInheritance noExtend = demo.new NoInheritance();
        noExtend.showMessage();
    }
}
