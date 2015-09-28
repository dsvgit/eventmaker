/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.managers;

import eventmaker.logic.transactionScripts.AuthorizationTransactionScripts;
import eventmaker.data.Company;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.models.VCompany;
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
public class CompanyManagerTest {
    
    public CompanyManagerTest() throws RepositoryException, UserAuthorizationException {
        new AuthorizationTransactionScripts().Login("admin", "admin");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class CompanyManager.
     */
    @Test
    public void testCreate() throws Exception, RepositoryException {
        System.out.println("create");
        String name = "company";
        String description = "";
        CompanyManager instance = new CompanyManager();
        Company expResult = new Company();
        expResult.setName("company");
        Company result = instance.create(name, description);
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of get method, of class CompanyManager.
     */
    @Test
    public void testGet() throws Exception, RepositoryException {
        System.out.println("get");
        Integer id = 1;
        CompanyManager instance = new CompanyManager();
        Company expResult = new Company();
        expResult.setName("Coca-cola");
        Company result = instance.get(id);
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of getList method, of class CompanyManager.
     */
    @Test
    public void testGetList() throws Exception, RepositoryException {
        System.out.println("getList");
        CompanyManager instance = new CompanyManager();
        List<VCompany> expResult = null;
        List<VCompany> result = instance.getList();
        assertTrue(result.size() > 0);
    }

    /**
     * Test of getListCurrent method, of class CompanyManager.
     */
    @Test
    public void testGetListCurrent() throws Exception, RepositoryException, UserAuthorizationException {
        System.out.println("getListCurrent");
        CompanyManager instance = new CompanyManager();
        List<VCompany> expResult = null;
        List<VCompany> result = instance.getListCurrent();
        assertTrue(result.size() > 0);
    }
    
}
