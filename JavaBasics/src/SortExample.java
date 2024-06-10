import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person1 implements Comparable<Person1> {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person1 other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person1{name='" + name + "', age=" + age + '}';
    }
}

public class SortExample {
    private static final Logger logger = LogManager.getLogger(SortExample.class);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        Collections.sort(numbers);  // Natural ordering
        logger.info("Sorted numbers: " + numbers);

        List<Person1> people = new ArrayList<>();
        people.add(new Person1("John", 25));
        people.add(new Person1("Alice", 23));
        people.add(new Person1("Bob", 30));
        Collections.sort(people);  // Uses Comparable's compareTo method
        logger.info("Sorted people by age (Comparable): " + people);

        // Sorting using Comparator (by name)
        Comparator<Person1> nameComparator = new Comparator<Person1>() {
            @Override
            public int compare(Person1 p1, Person1 p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
        Collections.sort(people, nameComparator);
        logger.info("Sorted people by name (Comparator): " + people);
    }
}
