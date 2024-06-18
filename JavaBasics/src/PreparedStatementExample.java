import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreparedStatementExample {
    private static final Logger logger = Logger.getLogger(PreparedStatementExample.class.getName());

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/testdb";
        String user = "root";
        String password = "";
          
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Attempt to connect
            Connection con = DriverManager.getConnection(url, user, password);
            
            if (con != null) {
                logger.log(Level.INFO, "Connected to the database successfully!");
                
                // Example PreparedStatement query
                String query = "SELECT * FROM users WHERE country = ?";
                
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, "USA");
                    
                    ResultSet rs = pst.executeQuery();
                    
                    while (rs.next()) {
                        logger.log(Level.INFO, "ID: {0}", rs.getInt("id"));
                        logger.log(Level.INFO, "Name: {0}", rs.getString("name"));
                        logger.log(Level.INFO, "Email: {0}", rs.getString("email"));
                        logger.log(Level.INFO, "Country: {0}", rs.getString("country"));
                    }
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "SQL Exception while executing PreparedStatement", ex);
                }
                
            } else {
                logger.log(Level.SEVERE, "Failed to connect to the database.");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Exception occurred: ", ex);
        }
    }
}
