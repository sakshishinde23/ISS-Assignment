import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringsAndArrays {
    private static final Logger logger = LogManager.getLogger(StringsAndArrays.class);

    public static void main(String[] args) {
        // String operations
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "Sakshi";

        // String length
        logger.info("Length of str1: {}", str1.length());

        // String concatenation
        String strConcat = str1 + " " + str2;
        logger.info("Concatenated string: {}", strConcat);

        // String comparison
        boolean isEqual = str1.equals(str3);
        logger.info("str1 equals str3: {}", isEqual);

        // String to uppercase
        String strUpper = str1.toUpperCase();
        logger.info("str1 in uppercase: {}", strUpper);

        // Substring
        String strSub = str1.substring(1, 4);
        logger.info("Substring of str1 from index 1 to 4: {}", strSub);

        // Character at a specific index
        char charAt = str1.charAt(2);
        logger.info("Character at index 2 in str1: {}", charAt);

        // Array operations
        int[] intArray = {1, 2, 3, 4, 5};

        // Array length
        logger.info("Length of intArray: {}", intArray.length);

        // Accessing array elements
        for (int i = 0; i < intArray.length; i++) {
            logger.info("Element at index {}: {}", i, intArray[i]);
        }

        // Array modification
        intArray[2] = 10;
        logger.info("Modified element at index 2: {}", intArray[2]);

        // Multi-dimensional array
        int[][] multiArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Accessing multi-dimensional array elements
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                logger.info("Element at index [{}, {}]: {}", i, j, multiArray[i][j]);
            }
        }
    }
}
