/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Reza Harli
 */
public class DAO {
    protected static Connection connection = null;
    protected static ResultSet rs = null;
    protected static Statement statement = null;
    
    protected static void reset() {
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
