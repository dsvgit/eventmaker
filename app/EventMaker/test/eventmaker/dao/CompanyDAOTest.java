/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.dao;

import eventmaker.data.Company;
import eventmaker.data.User;
import eventmaker.repository.exceptions.RepositoryException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dsvma_000
 */
public class CompanyDAOTest {
    
    public CompanyDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getListCurrent method, of class CompanyDAO.
     */
    @Test
    public void testGetListCurrent() {
        System.out.println("getListCurrent");
        User user = new User();
        user.setId(5);
        CompanyDAO instance = new CompanyDAO();
        List<Company> expResult = null;
        List<Company> result = instance.getListCurrent(user);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of get method, of class CompanyDAO.
     */
    @Test
    public void testGet() throws Exception, RepositoryException {
        System.out.println("get");
        Integer identifier = 1;
        CompanyDAO instance = new CompanyDAO();
        Company expResult = null;
        Company result = instance.get(identifier);
        assertTrue(result != null);
    }

    /**
     * Test of getList method, of class CompanyDAO.
     */
    @Test
    public void testGetList() throws Exception, RepositoryException {
        System.out.println("getList");
        CompanyDAO instance = new CompanyDAO();
        List<Company> expResult = null;
        List<Company> result = instance.getList();
        assertTrue(result.size() > 0);
    }
}
