import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionHandling {

    // Creating a Logger instance 
    private static final Logger logger = LogManager.getLogger(ExceptionHandling.class);

    public static void main(String[] args) {
        // Handling ArrayIndexOutOfBoundsException
        try {
            int[] a = new int[2];
            logger.info("Access element three: " + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Exception thrown: ", e);
        } finally {
            int[] a = new int[2];
            a[0] = 6;
            logger.info("First element value: " + a[0]);
            logger.info("The finally statement is executed");
        }

        // Handling FileNotFoundException and IOException
        FileInputStream file = null;
        String fileName = "test.txt";
        try {
            file = new FileInputStream(fileName);
            int x = file.read();
            logger.info("First byte of the file: " + x);
        } catch (FileNotFoundException f) {
            logger.error("FileNotFoundException: ", f);
        } catch (IOException i) {
            logger.error("IOException: ", i);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException i) {
                    logger.error("IOException while closing the file: ", i);
                }
            }
        }
    }
}

