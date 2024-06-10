import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiThreading {
    private static final Logger logger = LogManager.getLogger(MultiThreading.class);

    public static void main(String[] args) {
        // Create instances of Thread 
        Thread numberThread = new Thread(new NumberPrinter());
        Thread charThread = new Thread(new CharPrinter());

        // Start threads
        numberThread.start();
        charThread.start();
    }

    static class NumberPrinter implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                logger.info("Number: {}", i);
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    logger.error("Number printer thread interrupted.", e);
                }
            }
        }
    }

    static class CharPrinter implements Runnable {
        public void run() {
            char c = 'A';
            for (int i = 0; i < 10; i++) {
                logger.info("Character: {}", c);
                c++;
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    logger.error("Character printer thread interrupted.", e);
                }
            }
        }
    }
}
