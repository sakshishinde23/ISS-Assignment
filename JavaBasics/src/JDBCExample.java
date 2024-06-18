import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCExample {

    
    private static final Logger logger = Logger.getLogger(JDBCExample.class.getName());

    // Database configuration
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/testdb";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    // Establish database connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Database connection established.");
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Failed to establish database connection.", e);
        }
        return connection;
    }

    // User model
    public static class User {
        private int id;
        private String name;
        private String email;
        private String country;

        public User(int id, String name, String email, String country) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.country = country;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    // CRUD operations
    public static class CRUDOperations {

        // CREATE
        public void addUser(String name, String email, String country) {
            String sql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, country);
                statement.executeUpdate();
                logger.info("User added: " + name);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to add user: " + name, e);
            }
        }

        // READ
        public List<User> getAllUsers() {
            List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM users";
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id, name, email, country));
                }
                logger.info("Retrieved all users.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to retrieve users.", e);
            }
            return users;
        }

        // UPDATE
        public void updateUser(int id, String name, String email, String country) {
            String sql = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, country);
                statement.setInt(4, id);
                statement.executeUpdate();
                logger.info("User updated: ID = " + id);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to update user: ID = " + id, e);
            }
        }

        // DELETE
        public void deleteUser(int id) {
            String sql = "DELETE FROM users WHERE id = ?";
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                logger.info("User deleted: ID = " + id);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to delete user: ID = " + id, e);
            }
        }
    }

    // Main method to test CRUD operations
    public static void main(String[] args) {
    	CRUDOperations operation = new CRUDOperations();

        // Create
    	operation.addUser("John Doe", "john.doe@example.com", "USA");
    	operation.addUser("Jane Smith", "jane.smith@example.com", "UK");

        // Read
        logger.info("All Users:");
        for (User user : operation.getAllUsers()) {
            logger.info(user.toString());
        }

        // Update
        operation.updateUser(1, "John Doe Jr.", "john.doe.jr@example.com", "USA");

        // Read
        logger.info("All Users after update:");
        for (User user : operation.getAllUsers()) {
            logger.info(user.toString());
        }

        // Delete
        operation.deleteUser(2);

        // Read
        logger.info("All Users after delete:");
        for (User user : operation.getAllUsers()) {
            logger.info(user.toString());
        }
    }
}
