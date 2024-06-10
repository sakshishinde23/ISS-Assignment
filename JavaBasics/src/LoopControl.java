import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoopControl {
    private static final Logger logger = LogManager.getLogger(LoopControl.class);

    public static void main(String[] args) {
        // Calculate factorial using for loop
        int n = 5;
        int factorialFor = 1;
        for (int i = 1; i <= n; i++) {
            factorialFor *= i;
        }
        logger.info("Factorial of {} using for loop: {}", n, factorialFor);

        // Calculate factorial using while loop
        int factorialWhile = 1;
        int j = 1;
        while (j <= n) {
            factorialWhile *= j;
            j++;
        }
        logger.info("Factorial of {} using while loop: {}", n, factorialWhile);

        // Calculate factorial using do-while loop
        int factorialDoWhile = 1;
        int k = 1;
        do {
            factorialDoWhile *= k;
            k++;
        } while (k <= n);
        logger.info("Factorial of {} using do-while loop: {}", n, factorialDoWhile);
    }
}
