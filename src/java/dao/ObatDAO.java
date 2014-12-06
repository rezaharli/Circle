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
    public static LinkedList<Obat> selectAll() {
        String sql = "select * from obat";
        connection = ConnectionManager.getConnection();
        LinkedList<Obat> obats = new LinkedList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                obats.add(new Obat(rs.getString("id"), rs.getString("nama"), rs.getString("harga")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            reset();
        }
        return obats;
    }

}
