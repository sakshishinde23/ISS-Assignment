import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class CollectionList {
    // Creating a Logger instance
    private static final Logger logger = LogManager.getLogger(CollectionList.class);

    public static void main(String[] args) {
        // 1. ArrayList
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("Cricket"); // List: ["Cricket"]
        arrList.add("Hockey"); // List: ["Cricket", "Hockey"]
        arrList.add(0, "BasketBall");
        logger.info("ArrayList: ");
        for (String str : arrList) {
            logger.info(str);
        }

        // 2. LinkedList
        LinkedList<String> linkList = new LinkedList<>();
        linkList.add("Apple"); // ["Apple"]
        linkList.add("Orange"); // ["Apple", "Orange"]
        linkList.add(0, "Banana"); // ["Banana", "Apple", "Orange"]
        logger.info("LinkedList elements: ");
        Iterator<String> it = linkList.iterator();
        while (it.hasNext()) {
            logger.info(it.next());
        }

        // 3. Vector
        Vector<String> v = new Vector<>();
        v.add("item1"); // ["item1"]
        v.add("item2"); // ["item1", "item2"]
        v.add("item3"); // ["item1", "item2", "item3"]
        v.remove("item2"); // ["item1", "item3"]
        logger.info("Vector Elements: ");
        Iterator<String> it1 = v.iterator();
        while (it1.hasNext()) {
            logger.info(it1.next());
        }

        // 4. Stack
        Stack<String> stack = new Stack<>();
        stack.push("Chaitanya"); // ["Chaitanya"]
        stack.push("Ajeet"); // ["Chaitanya", "Ajeet"]
        stack.push("Hari"); // ["Chaitanya", "Ajeet", "Hari"]
        stack.pop(); // Removes "Hari"
        stack.push("Steve"); // ["Chaitanya", "Ajeet", "Steve"]
        stack.push("Carl"); // ["Chaitanya", "Ajeet", "Steve", "Carl"]
        stack.pop(); // Removes "Carl"

        logger.info("Stack elements: ");
        for (String str : stack) {
            logger.info(str);
        }
    }
}
