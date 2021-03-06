/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import model.Klaim;

/**
 *
 * @author Reza Harli
 */
public class KlaimDAO extends DAO {

    /**
     *
     * @param klaim
     * @return
     */
    public static String insert(Klaim klaim) {
        String sql
                = "INSERT INTO `klaim` "
                + "(`tanggal`, `username`) VALUES "
                + "('" + klaim.getTanggal() + "', '" + klaim.getUsername() + "');";
        System.out.println(sql);
        connection = ConnectionManager.getConnection();
        String idKlaim = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idKlaim = rs.getString(1);
            }
        } catch (SQLException ex) {
        } finally {
            reset();
        }
        return idKlaim;
    }

    public static LinkedList<Klaim> selectAllByUsername(String username) {
        String sql = "select * from klaim where username = '" + username + "'";
        connection = ConnectionManager.getConnection();
        LinkedList<Klaim> klaims = new LinkedList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                klaims.add(new Klaim(rs.getString("id"), rs.getString("tanggal"), rs.getString("username"), (rs.getString("status").equals("")) ? "waiting" : rs.getString("status")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            reset();
        }
        return klaims;
    }

    public static LinkedList<Klaim> selectAll() {
        String sql = "select * from klaim";
        connection = ConnectionManager.getConnection();
        LinkedList<Klaim> klaims = new LinkedList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                klaims.add(new Klaim(rs.getString("id"), rs.getString("tanggal"), rs.getString("username"), (rs.getString("status").equals("")) ? "waiting" : rs.getString("status")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            reset();
        }
        return klaims;
    }

    /**
     *
     * @param idKlaim
     * @return
     */
    public static boolean delete(String idKlaim) {
        String sql = "DELETE FROM klaim where id = " + idKlaim + ";";
        connection = ConnectionManager.getConnection();
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
        } finally {
            reset();
        }
        return true;
    }

    public static boolean editStatus(String idKlaim, String status) {
        String sql = "UPDATE `circle`.`klaim` SET `status` = '" + status + "' WHERE `klaim`.`id` = " + idKlaim + ";";
        connection = ConnectionManager.getConnection();
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
        } finally {
            reset();
        }
        return true;
    }

}
