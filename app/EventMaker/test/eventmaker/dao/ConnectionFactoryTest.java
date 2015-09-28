/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dsvma_000
 */
public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getConnection method, of class ConnectionFactory.
     */
    @Test
    public void testGetConnection() throws SQLException {
        System.out.println("getConnection");
        ConnectionFactory instance = ConnectionFactory.getInstance();
        Connection result = instance.getConnection();
        assertTrue(result != null);
    }
    
}
