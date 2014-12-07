package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import model.Dokter;

/**
 *
 * @author Reza Harli
 */
public class DokterDAO extends DAO {

    /**
     *
     * @param idKlaim
     * @return
     */
    public static LinkedList<Dokter> selectAllByIdKlaim(String idKlaim) {
        String sql = "select * from dokter where id_klaim = " + idKlaim;
        connection = ConnectionManager.getConnection();
        LinkedList<Dokter> dokters = new LinkedList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                dokters.add(new Dokter(rs.getString("id"), rs.getString("nama"), rs.getString("harga")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            reset();
        }
        return dokters;
    }

}
