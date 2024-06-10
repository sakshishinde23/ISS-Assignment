import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Person {
    //Different access modifiers
    private String name;     // private access
    int age;                 // default access
    protected String gender; // protected access
    public String nationality; // public access

    // Constructor
    public Person(String name, int age, String gender, String nationality) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
    }

    // Private method
    //private String displayPrivateInfo() {
     //   return name;
    //}

    // Default method
    int displayDefaultInfo() {
        return age;
    }

    // Protected method
    protected String displayProtectedInfo() {
       return gender;
    }

    // Public method
    public String displayPublicInfo() {
       return nationality;
    }
}

class Employee extends Person {
    // Constructor
    public Employee(String name, int age, String gender, String nationality) {
        super(name, age, gender, nationality);
    }

    // Method to demonstrate access to protected members
    public void displayEmployeeInfo() {
        displayProtectedInfo(); // Accessing protected method from parent class
    }
}


    public class ModifierTypes {

        // Creating a Logger instance
        private static final Logger logger = LogManager.getLogger(ModifierTypes.class);
        
        public static void main(String[] args) {
        	// Creating a Person object
            Person person = new Person("John Doe", 30, "Male", "American");
            
            // Accessing public method
            person.displayPublicInfo();

            // Accessing default method
            person.displayDefaultInfo();
            
            // Creating an Employee object
            Employee employee = new Employee("Jane Doe", 28, "Female", "Canadian");

            // Accessing protected method through subclass
            employee.displayEmployeeInfo();
            
            // Attempting to access private method (will result in a compilation error if uncommented)
            // String privateInfo = person.displayPrivateInfo(); // Uncommenting this line will cause an error
        	
        }
    }