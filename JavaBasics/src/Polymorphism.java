import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Base class
class Book{
	protected static final Logger logger = LogManager.getLogger(Book.class);
	
	private String title;
	private String author;
	private double price;
	
	//Constructor
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	//Method to display book information
	public void display() {
		logger.info("Title: {}", title);
        logger.info("Author: {}", author);
        logger.info("Price: Rs{}", price);
	}
}

//Subclass Fiction
class Fiction extends Book{
	//Constructor
	public Fiction(String title, String author, double price) {
		super(title, author, price);
	}
	
	//Override display method
	@Override
	public void display() {
		super.display();
		logger.info("Genre: Fiction");
	}
	
}
//Subclass NonFiction
class NonFiction extends Book {
 // Constructor
 public NonFiction(String title, String author, double price) {
     super(title, author, price); // Call the constructor of the base class
 }

 // Override display method to add genre information
 @Override
 public void display() {
     super.display(); // Call the base class method
     logger.info("Genre: Non-Fiction");
 }
}
public class Polymorphism{
    private static final Logger logger = LogManager.getLogger(Polymorphism.class);

    public static void main(String[] args) {
        // Creating instances of different book types
        Book fictionBook = new Fiction("To Kill a Mockingbird", "Harper Lee", 1299);
        Book nonFictionBook = new NonFiction("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 1550);

        // Displaying information about each book
        logger.info("Displaying details of a fiction book:");
        fictionBook.display();

        logger.info("\nDisplaying details of a non-fiction book:");
        nonFictionBook.display();
    }
}
