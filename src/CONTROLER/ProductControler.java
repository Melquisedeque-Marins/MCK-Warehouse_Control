package CONTROLER;


import MODEL.ProductModel;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductControler {
    
    Connection connection;
    PreparedStatement pstm;
    public ResultSet rs;
    ArrayList<ProductModel> list = new ArrayList();

    public ProductControler(ProductModel productmodel) {
    }
    
     public ProductControler() {
    }
     public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Insert(ProductModel productmodel) {

        connection = new ConnectionBD().ConnectBD();
        String sql = "INSERT INTO products (code, name, type, manufactor, barcod, amount) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, productmodel.getCode());
            pstm.setString(2, productmodel.getName());
            pstm.setString(3, productmodel.getType());
            pstm.setString(4, productmodel.getManufactor());
            pstm.setString(5, productmodel.getBarCode());
            pstm.setInt(6, productmodel.getAmount());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "successfully registered product");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO" + e);
        }
    }
    
    public void search(ProductModel productmodel) throws SQLException {

        this.connection = new ConnectionBD().ConnectBD();
        String sql = ("SELECT * FROM products where  name like ? ORDER BY name");

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, productmodel.getName() + "%");
            rs = pstm.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "search Controler" + e);
        }

    }
    
     public ArrayList<ProductModel> read() {

        this.connection = new ConnectionBD().ConnectBD();
        String sql = ("SELECT * FROM products ORDER BY name");

        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                ProductModel productmodel = new ProductModel();
                productmodel.setIdProducts(rs.getInt("idproducts"));
                productmodel.setCode(rs.getString("code"));
                productmodel.setName(rs.getString("name"));
                productmodel.setType(rs.getString("type"));
                productmodel.setManufactor(rs.getString("manufactor"));
                productmodel.setBarCode(rs.getString("barcod"));
                productmodel.setAmount(parseInt(rs.getString("amount")));

                list.add(productmodel);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "read Controler" + e);

        }
        return list;

    }
     
      public void delete(ProductModel productmodel) {

        connection = new ConnectionBD().ConnectBD();
        String sql = "DELETE FROM products WHERE idproducts = ?;";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, productmodel.getIdProducts());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "User deleted succesfully");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      
      public void update(ProductModel productmodel) {
        connection = new ConnectionBD().ConnectBD();
        String sql = "UPDATE products SET code = ?, name=?, type=? , manufactor=?, barcod=?, amount=? WHERE idproducts=?;";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, productmodel.getCode());
            pstm.setString(2, productmodel.getName());
            pstm.setString(3, productmodel.getType());
            pstm.setString(4, productmodel.getManufactor());
            pstm.setString(5, productmodel.getBarCode());
            pstm.setInt(6, productmodel.getAmount());
            pstm.setInt(7, productmodel.getIdProducts());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "successfully update user");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO" + e);
        }

    }
}
