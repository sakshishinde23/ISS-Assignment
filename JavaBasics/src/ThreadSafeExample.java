import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

class ThreadSafeCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private static final Logger logger = Logger.getLogger(ThreadSafeCounter.class.getName());

    public void increment() {
        lock.lock();
        try {
            int currentCount = count;
            logger.info("Current count: " + currentCount);
            try {
                Thread.sleep(100); // Simulate some processing delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count = currentCount + 1;
            logger.info("Incremented count to: " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class ThreadSafeExample {
    private static final Logger logger = Logger.getLogger(ThreadSafeExample.class.getName());

    public static void main(String[] args) {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        logger.info("Final count (thread-safe): " + counter.getCount());
    }
}
