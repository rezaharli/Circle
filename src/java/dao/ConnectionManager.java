package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    static Connection connection;
    static String url = "jdbc:mysql://localhost:3306/circle";
    static String user = "root";
    static String password = "";
    static String className = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return connection;
    }

}
