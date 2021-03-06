/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.managers;

import eventmaker.logic.transactionScripts.AuthorizationTransactionScripts;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.repository.exceptions.RepositoryException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dsvma_000
 */
public class AuthorizationTSTest {
    
    public AuthorizationTSTest() throws RepositoryException, UserAuthorizationException {
        new AuthorizationTransactionScripts().Login("admin", "admin");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Login method, of class AuthorizationManager.
     */
    @Test
    public void testLogin() throws Exception, RepositoryException, UserAuthorizationException {
        System.out.println("Login");
        String login = "admin";
        String password = "admin";
        AuthorizationTransactionScripts instance = new AuthorizationTransactionScripts();
        instance.Login(login, password);
        
    }

    /**
     * Test of AdminLogin method, of class AuthorizationManager.
     */
    @Test
    public void testAdminLogin() throws Exception, RepositoryException, UserAuthorizationException {
        System.out.println("AdminLogin");
        String login = "admin";
        String password = "admin";
        AuthorizationTransactionScripts instance = new AuthorizationTransactionScripts();
        instance.AdminLogin(login, password);
        
    }
    
}
