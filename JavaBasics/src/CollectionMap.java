import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CollectionMap {
    // Creating a Logger instance
    private static final Logger logger = LogManager.getLogger(CollectionMap.class);

    public static void main(String[] args) {
        // 1. HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Apple");
        hashMap.put(3, "Orange");
        hashMap.put(2, "Banana");
        hashMap.put(4, "Grapes");
        logger.info("HashMap Elements: ");
        hashMap.forEach((key, value) -> logger.info("Key: " + key + ", Value: " + value));

        // 2. LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Apple");
        linkedHashMap.put(3, "Orange");
        linkedHashMap.put(2, "Banana");
        linkedHashMap.put(4, "Grapes");
        logger.info("LinkedHashMap Elements: ");
        linkedHashMap.forEach((key, value) -> logger.info("Key: " + key + ", Value: " + value));

        // 3. TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Apple");
        treeMap.put(3, "Orange");
        treeMap.put(2, "Banana");
        treeMap.put(4, "Grapes");
        logger.info("TreeMap Elements: ");
        treeMap.forEach((key, value) -> logger.info("Key: " + key + ", Value: " + value));
    }
}
