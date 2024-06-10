import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionSet {
    // Creating a Logger instance
    private static final Logger logger = LogManager.getLogger(CollectionSet.class);

    public static void main(String[] args) {
        // 1. HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Orange");
        hashSet.add("Banana");
        hashSet.add("Grapes");
        logger.info("HashSet Elements: ");
        for (String fruit : hashSet) {
            logger.info(fruit);
        }

        // 2. LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Grapes");
        logger.info("LinkedHashSet Elements: ");
        for (String fruit : linkedHashSet) {
            logger.info(fruit);
        }

        // 3. TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Banana");
        treeSet.add("Grapes");
        logger.info("TreeSet Elements: ");
        for (String fruit : treeSet) {
            logger.info(fruit);
        }
    }
}
