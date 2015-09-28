/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.managers;

import eventmaker.logic.transactionScripts.UserTransactionScripts;
import eventmaker.logic.transactionScripts.AuthorizationTransactionScripts;
import eventmaker.data.User;
import eventmaker.logic.identity.UserAuthorizationException;
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
public class UserTSTest {
    
    public UserTSTest() throws RepositoryException, UserAuthorizationException {
        new AuthorizationTransactionScripts().Login("admin", "admin");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class UserManager.
     */
    @Test
    public void testCreate() throws Exception, RepositoryException {
        System.out.println("create");
        String firstName = "";
        String lastName = "";
        String login = "admin";
        String info = "";
        UserTransactionScripts instance = new UserTransactionScripts();
        User expResult = new User();
        expResult.setLogin("admin");
        User result = instance.create(firstName, lastName, login, info);
        assertEquals(expResult.getLogin(), result.getLogin());
    }

    /**
     * Test of get method, of class UserManager.
     */
    @Test
    public void testGet() throws Exception, RepositoryException {
        System.out.println("get");
        Integer id = 1;
        UserTransactionScripts instance = new UserTransactionScripts();
        User expResult = null;
        User result = instance.get(id);
        assertTrue(result != null);
    }

    /**
     * Test of getUserByName method, of class UserManager.
     */
    @Test
    public void testGetUserByName() throws Exception, RepositoryException {
        System.out.println("getUserByName");
        String name = "admin";
        UserTransactionScripts instance = new UserTransactionScripts();
        User expResult = null;
        User result = instance.getUserByName(name);
        assertTrue(result != null);
    }

    /**
     * Test of getList method, of class UserManager.
     */
    @Test
    public void testGetList() throws Exception, RepositoryException {
        System.out.println("getList");
        UserTransactionScripts instance = new UserTransactionScripts();
        List<User> expResult = null;
        List<User> result = instance.getList();
        assertTrue(result.size() > 0);
    }
    
}
