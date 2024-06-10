import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Country{
	
	private static final Logger logger = LogManager.getLogger(Country.class);
	
	private String name;
	private int population;
	private String continent;
	
	public Country(String name, int population, String continent) {
		this.name = name;
		this.population = population;
		this.continent = continent;
	}
	
	//Getter and Setter methods
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
 // Method to display country details
    public void displayCountryInfo() {
        logger.info("Country Name: " + name);
        logger.info("Population: " + population);
        logger.info("Continent: " + continent);
    }
}

public class Encapsulation{
	private static final Logger logger = LogManager.getLogger(Encapsulation.class);
	
	public static void main(String[] args) {
        // Creating a Country object
        Country country = new Country("India", 1393409038, "Asia");

        // Displaying initial country details
        System.out.println("Initial country details:");
        country.displayCountryInfo();

        // Modifying country details using setter methods
        country.setName("Bharat");
        country.setPopulation(1400000000);
        country.setContinent("South Asia");

        // Displaying modified country details
        System.out.println("\nModified country details:");
        country.displayCountryInfo();
	}

}