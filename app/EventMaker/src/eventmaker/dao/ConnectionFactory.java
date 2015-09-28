package eventmaker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    
    private static ConnectionFactory instance;
    
    private ConnectionFactory() {
    };
     
    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            String url = "jdbc:derby://localhost:1527/events";
            String name = "root";
            String password = "root";
            
            conn = DriverManager.getConnection(url, name, password);
            System.out.println("есть подключение к БД");
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
