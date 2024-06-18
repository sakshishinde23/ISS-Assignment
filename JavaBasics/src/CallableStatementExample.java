import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CallableStatementExample {
    private static final Logger logger = Logger.getLogger(CallableStatementExample.class.getName());

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/testdb";
        String user = "root";
        String password = "";
        String country = "USA"; // Example country parameter for the stored procedure

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            con = DriverManager.getConnection(url, user, password);
            logger.log(Level.INFO, "Connected to the database successfully.");

            // Prepare the SQL call to the stored procedure
            String call = "{call get_users_by_country(?)}";
            cstmt = con.prepareCall(call);
            
            // Set the parameter for the stored procedure
            cstmt.setString(1, country);

            // Execute the stored procedure
            rs = cstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String countryResult = rs.getString("country");

                // Log the retrieved data
                logger.log(Level.INFO, "ID: {0}, Name: {1}, Email: {2}, Country: {3}",
                        new Object[]{id, name, email, countryResult});
            }

        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Exception occurred: ", ex);
        } finally {
            // Close resources in finally block to ensure they're always closed
            try {
                if (rs != null) rs.close();
                if (cstmt != null) cstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Exception occurred while closing resources: ", ex);
            }
        }
    }
}
