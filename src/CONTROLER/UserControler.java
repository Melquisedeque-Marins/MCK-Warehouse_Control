package CONTROLER;

import MODEL.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class UserControler implements CrudMethods {

    Connection connection;
    PreparedStatement pstm;
    public ResultSet rs;
    ArrayList<UserModel> list = new ArrayList();

    public UserControler(UserModel usermodel) {

    }

    public UserControler() {

    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void create(UserModel usermodel) {

        connection = new ConnectionBD().ConnectBD();
        String sql = "INSERT INTO teste (name, user, password, aut_password, perfil) VALUES (?, ?, ?, ?, ?);";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, usermodel.getName());
            pstm.setString(2, usermodel.getUser());
            pstm.setString(3, usermodel.getPassword());
            pstm.setString(4, usermodel.getAutPassword());
            pstm.setString(5, usermodel.getPerfil());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "successfully registered user");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO");
        }
    }

    @Override
    public ArrayList<UserModel> read() {

        this.connection = new ConnectionBD().ConnectBD();
        String sql = ("SELECT * FROM teste ORDER BY name");

        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                UserModel usermodel = new UserModel();
                usermodel.setId(rs.getInt("id"));
                usermodel.setName(rs.getString("name"));
                usermodel.setUser(rs.getString("user"));
                usermodel.setPassword(rs.getString("password"));
                usermodel.setAutPassword(rs.getString("aut_password"));
                usermodel.setPerfil(rs.getString("perfil"));

                list.add(usermodel);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "read Controler" + e);

        }
        return list;

    }

    public void search(UserModel usermodel) throws SQLException {

        this.connection = new ConnectionBD().ConnectBD();
        String sql = ("SELECT * FROM teste where  name like ? ORDER BY name");

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, usermodel.getName() + "%");
            rs = pstm.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "search Controler" + e);
        }

    }

 
    public void update(UserModel usermodel) {
        connection = new ConnectionBD().ConnectBD();
        String sql = "UPDATE teste SET name = ?, user=?, password=? , aut_password=?, perfil=? WHERE id=?;";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, usermodel.getName());
            pstm.setString(2, usermodel.getUser());
            pstm.setString(3, usermodel.getPassword());
            pstm.setString(4, usermodel.getAutPassword());
            pstm.setString(5, usermodel.getPerfil());
            pstm.setInt(6, usermodel.getId());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "successfully update user");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO" + e);
        }

    }

    public void delete(UserModel usermodel) {

        connection = new ConnectionBD().ConnectBD();
        String sql = "DELETE FROM teste WHERE id = ?;";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, usermodel.getId());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "User deleted succesfully");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet autenticationUser(UserModel user) {
        this.connection = new ConnectionBD().ConnectBD();

        String sql = ("SELECT * FROM teste WHERE user = ? AND password = ? ");

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUser());
            pstm.setString(2, user.getPassword());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    
    public ResultSet autorizationUser(UserModel user) {
        this.connection = new ConnectionBD().ConnectBD();

        String sql = ("SELECT * FROM teste WHERE user = ? AND aut_password = ? ");

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUser());
            pstm.setString(2, user.getAutPassword());
            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    
    
    
    
    
    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
