package CONTROLER;

import MODEL.RequesterModel;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RequesterControler {

    Connection connection;
    PreparedStatement pstm;
    public ResultSet rs;
    ArrayList<RequesterModel> list = new ArrayList();

    public RequesterControler() {
    }

    public RequesterControler(RequesterModel requesterModel) {
    }

    public void Insert(RequesterModel requesterModel) {

        connection = new ConnectionBD().ConnectBD();
        String sql = "INSERT INTO requester (name, code) VALUES (?, ?);";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, requesterModel.getName());
            pstm.setString(2, requesterModel.getCode());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "successfully registered product");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "This product code is not available" + e);
        }
    }

    public void search(RequesterModel requesterModel) throws SQLException {

        this.connection = new ConnectionBD().ConnectBD();
        String sql = ("SELECT * FROM requester where  name like ? ORDER BY name");

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, requesterModel.getName() + "%");
            rs = pstm.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "search Controler" + e);
        }
    }

    public ArrayList<RequesterModel> read() {

        this.connection = new ConnectionBD().ConnectBD();
        String sql = ("SELECT * FROM requester ORDER BY name");

        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                RequesterModel requesterModel = new RequesterModel();
                requesterModel.setIdRequester(rs.getInt("idrequester"));
                requesterModel.setCode(rs.getString("code"));
                list.add(requesterModel);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "read Controler" + e);

        }
        return list;
    }

    public void delete(RequesterModel requesterModel) {

        connection = new ConnectionBD().ConnectBD();
        String sql = "DELETE FROM requester WHERE idrequester = ?;";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, requesterModel.getIdRequester());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "User deleted succesfully");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void update(RequesterModel requesterModel) {
        connection = new ConnectionBD().ConnectBD();
        String sql = "UPDATE requester SET name= ?, code=? WHERE idrequester=?;";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, requesterModel.getName());
            pstm.setString(2, requesterModel.getCode());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "successfully update user");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO" + e);
        }
    }
}
