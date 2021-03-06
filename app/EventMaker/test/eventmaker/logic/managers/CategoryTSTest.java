/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.managers;

import eventmaker.logic.transactionScripts.CategoryTransactionScripts;
import eventmaker.logic.transactionScripts.AuthorizationTransactionScripts;
import eventmaker.data.Category;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.repository.exceptions.RepositoryException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dsvma_000
 */
public class CategoryTSTest {
    
    public CategoryTSTest() throws RepositoryException, UserAuthorizationException {
        new AuthorizationTransactionScripts().Login("admin", "admin");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class CategoryManager.
     */
    @Test
    public void testCreate() throws Exception, RepositoryException {
        System.out.println("create");
        String name = "";
        CategoryTransactionScripts instance = new CategoryTransactionScripts();
        Category expResult = new Category("category");
        Category result = instance.create("category");
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of get method, of class CategoryManager.
     */
    @Test
    public void testGet() throws Exception, RepositoryException {
        System.out.println("get");
        Integer id = 1;
        CategoryTransactionScripts instance = new CategoryTransactionScripts();
        Category expResult = new Category("conference");
        Category result = instance.get(id);
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of getList method, of class CategoryManager.
     */
    @Test
    public void testGetList() throws Exception, RepositoryException {
        System.out.println("getList");
        CategoryTransactionScripts instance = new CategoryTransactionScripts();
        List<Category> expResult = new ArrayList<Category>();
        List<Category> result = instance.getList();
        assertTrue(result.size() > 0);
    }
    
}
