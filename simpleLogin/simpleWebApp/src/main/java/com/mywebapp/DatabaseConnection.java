package com.mywebapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/UserDB?useSSL=false&serverTimezone=UTC";
        String dbUsername = "root"; // replace with your database username
        String dbPassword = ""; // replace with your database password

        LOGGER.log(Level.INFO, "Connecting to database URL: {0}", dbURL);

        Connection connection = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            LOGGER.info("Database connection successfully established.");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Database Driver Class Not Found: ", e);
            throw e;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Exception while establishing connection: ", e);
            throw e;
        }

        return connection;
    }
}
