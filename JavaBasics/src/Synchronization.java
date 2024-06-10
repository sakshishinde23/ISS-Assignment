import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Counter {
    private int count;

    // Synchronized method to increment count
    public synchronized void increment() {
        count++;
    }

    // Method without synchronization
    public void decrement() {
        count--;
    }

    // Synchronized block to manipulate count
    public void addTen() {
        synchronized (this) {
            count += 10;
        }
    }

    // Method to retrieve count
    public int getCount() {
        return count;
    }
}

public class Synchronization {
    private static final Logger logger = LogManager.getLogger(Synchronization.class);

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create multiple threads to manipulate the counter concurrently
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                    counter.decrement();
                    counter.addTen();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Print the final count
        logger.info("Final count: " + counter.getCount()); // Expected output: 5000
    }
}
