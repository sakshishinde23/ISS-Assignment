import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Define the Animal interface
interface Animal {
    void eat();
    void makeSound();
}

// Implement the Animal interface in the Dog class
class Dog implements Animal {
    private static final Logger logger = LogManager.getLogger(Dog.class);

    @Override
    public void eat() {
        logger.info("The dog is eating.");
    }

    @Override
    public void makeSound() {
        logger.info("The dog barks.");
    }
}

public class Interfaces {

    private static final Logger logger = LogManager.getLogger(Interfaces.class);

    public static void main(String[] args) {
        // Create instances of Dog
        Animal dog = new Dog();

        // Call the eat and makeSound methods 
        dog.eat();
        dog.makeSound();

    }
}
