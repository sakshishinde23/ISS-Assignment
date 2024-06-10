import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//Demonstrate Checked Exception
class CheckedExceptionDemo {

private static final Logger logger = LogManager.getLogger(CheckedExceptionDemo.class);

 public void readFile(String fileName) throws FileNotFoundException {
     File file = new File(fileName);
     FileReader fr = new FileReader(file);
     logger.info("File found and opened: " + fileName);
 }
}
//Demonstrate Unchecked Exception
class UncheckedExceptionDemo {

 private static final Logger logger = LogManager.getLogger(UncheckedExceptionDemo.class);

 public void divide(int a, int b) {
     int result = a / b;
     logger.info("Result: " + result);
 }
}
//Demonstrate Error
class ErrorDemo {

 private static final Logger logger = LogManager.getLogger(ErrorDemo.class);

 public void generateStackOverflowError() {
     generateStackOverflowError(); // Recursive call to cause StackOverflowError
 }
}

public class Exception {

    private static final Logger logger = LogManager.getLogger(Exception.class);

    public static void main(String[] args) {
        // Checked Exception Demo
        CheckedExceptionDemo checkedDemo = new CheckedExceptionDemo();
        try {
            checkedDemo.readFile("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            logger.error("Checked Exception: File not found", e);
        }

        // Unchecked Exception Demo
        UncheckedExceptionDemo uncheckedDemo = new UncheckedExceptionDemo();
        try {
            uncheckedDemo.divide(10, 0);
        } catch (ArithmeticException e) {
            logger.error("Unchecked Exception: Division by zero", e);
        }

        // Error Demo
        ErrorDemo errorDemo = new ErrorDemo();
        try {
            errorDemo.generateStackOverflowError();
        } catch (StackOverflowError e) {
            logger.error("Error: StackOverflowError", e);
        }
    }
}
