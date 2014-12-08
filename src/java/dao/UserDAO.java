package dao;

import java.sql.SQLException;
import model.User;

/**
 *
 * @author Reza Harli
 */
public class UserDAO extends DAO{

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
                user.setStatus(rs.getString("status"));
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

}