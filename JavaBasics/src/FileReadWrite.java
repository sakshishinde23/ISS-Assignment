import java.io.*;
import java.util.logging.*;

public class FileReadWrite {

    private static final Logger logger = Logger.getLogger(FileReadWrite.class.getName());

    public static void main(String[] args) {
        String inputFile = "src/files/input.txt";   // Name of the file to read from
        String outputFile = "src/files/output.txt"; // Name of the file to write to


        // Try-with-resources to auto-close the streams
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            // Read from input.txt and write to output.txt line by line
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a new line after each line in the output file
            }
            logger.info("File read and write operation successful!");

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage(), e);
        }
    }
}
