import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LibraryParser {
    private static final Logger logger = Logger.getLogger(LibraryParser.class.getName());

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/simple_library.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            logger.log(Level.INFO, "Root element: {0}", doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("book");
            logger.info("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                logger.log(Level.INFO, "\nCurrent Element: {0}", nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = eElement.getElementsByTagName("author").item(0).getTextContent();
                    String year = eElement.getElementsByTagName("year").item(0).getTextContent();
                    String price = eElement.getElementsByTagName("price").item(0).getTextContent();

                    logger.log(Level.INFO, "Title: {0}", title);
                    logger.log(Level.INFO, "Author: {0}", author);
                    logger.log(Level.INFO, "Year: {0}", year);
                    logger.log(Level.INFO, "Price: {0}", price);
                }
            }
        } catch (ParserConfigurationException e) {
            logger.log(Level.SEVERE, "ParserConfigurationException occurred", e);
        } catch (SAXException e) {
            logger.log(Level.SEVERE, "SAXException occurred", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException occurred", e);
        }
    }
}
