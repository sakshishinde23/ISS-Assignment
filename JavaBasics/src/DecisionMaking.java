import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DecisionMaking {
    private static final Logger logger = LogManager.getLogger(DecisionMaking.class);

    public static void main(String[] args) {
        // Score and grade demonstration using if, if-else, if-else-if
        int score = 85;
        char grade;

        // if statement
        if (score >= 90) {
            grade = 'A';
        }
        // if-else statement
        else if (score >= 80) {
            grade = 'B';
        }
        // if-else-if statement
        else if (score >= 70) {
            grade = 'C';
        }
        else if (score >= 60) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        logger.info("Score: {}, Grade: {}", score, grade);

        // Switch statement demonstration
        int day = 3; // 1 for Monday, 2 for Tuesday, ..., 7 for Sunday
        String dayName;

        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        logger.info("Day number: {}, Day name: {}", day, dayName);

        // Ternary operator demonstration
        int age = 11;
        String eligibility = (age >= 18) ? "Eligible to vote" : "Not eligible to vote";
        logger.info("Age: {}, Eligibility: {}", age, eligibility);
    }
}
