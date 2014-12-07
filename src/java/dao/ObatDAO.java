package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import model.Obat;

/**
 *
 * @author Reza Harli
 */
public class ObatDAO extends DAO {

    /**
     *
     * @return
     */
    public static LinkedList<Obat> selectAllByIdKlaim(String idKlaim) {
        String sql = "select * from obat where id_klaim = " + idKlaim;
        connection = ConnectionManager.getConnection();
        LinkedList<Obat> obats = new LinkedList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                obats.add(new Obat(rs.getString("id"), rs.getString("nama"), rs.getString("harga"), rs.getString("id_klaim")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            reset();
        }
        return obats;
    }
    
    public static boolean insert(Obat obat) {
        String sql
                = "INSERT INTO `obat` "
                + "(`nama`, `harga`, `id_klaim`) VALUES "
                + "('" + obat.getNama()+ "', " + obat.getHarga()+ ", " + obat.getIdKlaim()+ ");";
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
