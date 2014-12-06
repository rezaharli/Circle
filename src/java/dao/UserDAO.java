package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 *
 * @author Reza Harli
 */
public class UserDAO {

    static Connection connection = null;
    static ResultSet rs = null;
    static Statement statement = null;

    /**
     *
     * @param user
     * @return
     */
    public static User login(User user) {
        String sql = "select * from user where username='" + user.getUsername() + "' AND password='" + user.getPassword() + "'";
        connection = ConnectionManager.getConnection();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
            } else {
                user = null;
            }
        } catch (SQLException ex) {
            user = null;
        } finally {
            reset();
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     */
    public static boolean register(User user) {
        String sql
                = "INSERT INTO `user` "
                + "(`fullname`, `username`, `password`, `email`) VALUES "
                + "('" + user.getFullname() + "', '" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "');";
        connection = ConnectionManager.getConnection();
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            return false;
        } finally {
            reset();
        }
        return true;
    }

    private static void reset() {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
            rs = null;
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
            }
            statement = null;
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }

            connection = null;
        }
    }

}