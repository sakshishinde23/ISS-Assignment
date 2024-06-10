import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadPool {
    private static final Logger logger = LogManager.getLogger(ThreadPool.class);

    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with fixed-size pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            Runnable task = new Task(i);
            executor.submit(task);
        }

        // Shutdown the executor after all tasks are completed
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            logger.info("Task {} is executing by {}", taskId, Thread.currentThread().getName());
            // Simulate task execution by sleeping for a random duration
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                logger.error("Task {} interrupted", taskId, e);
            }
            logger.info("Task {} completed.", taskId);
        }
    }
}
