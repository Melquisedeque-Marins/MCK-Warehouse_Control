package CONTROLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

    Connection connection;

    public Connection ConnectBD() {

        try {
            String server = "localhost";
            String port = "3306";
            String user = "root";
            String password = "1234";
            String database = "warehousecontrol";
            String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
            return DriverManager.getConnection(url, user, password);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       
    }

}
