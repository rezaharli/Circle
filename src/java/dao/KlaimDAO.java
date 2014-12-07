/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.connection;
import java.sql.SQLException;
import model.Klaim;

/**
 *
 * @author Reza Harli
 */
public class KlaimDAO extends DAO{
    
    public static boolean insert(Klaim klaim) {
        String sql
                = "INSERT INTO `klaim` "
                + "(`tanggal`, `username`) VALUES "
                + "('" + klaim.getTanggal()+ "', '" + klaim.getUsername() + "');";
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
