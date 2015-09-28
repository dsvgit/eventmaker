/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.managers;

import eventmaker.logic.transactionScripts.AuthorizationTransactionScripts;
import eventmaker.logic.transactionScripts.EventTransactionScripts;
import eventmaker.data.Event;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.repository.exceptions.RepositoryException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dsvma_000
 */
public class EventManagerTest {
    
    public EventManagerTest() throws RepositoryException, UserAuthorizationException {
        new AuthorizationTransactionScripts().Login("admin", "admin");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class EventManager.
     */
    @Test
    public void testCreate() throws Exception, RepositoryException {
        System.out.println("create");
        String name = "event";
        Integer categoryId = 1;
        Date eventDate = null;
        String description = "";
        ApproveRule approveRule = null;
        PaymentRule paymentRule = null;
        Availability availability = null;
        BigDecimal cost = null;
        Integer companyId = 1;
        EventTransactionScripts instance = new EventTransactionScripts();
        Event expResult = new Event();
        expResult.setName("event");
        Event result = instance.create(name, categoryId, eventDate, description, approveRule, paymentRule, availability, cost, companyId);
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of get method, of class EventManager.
     */
    @Test
    public void testGet() throws Exception, RepositoryException {
        System.out.println("get");
        Integer id = 1;
        EventTransactionScripts instance = new EventTransactionScripts();
        Event expResult = null;
        Event result = instance.get(id);
        assertFalse(result == null);
    }

    /**
     * Test of getList method, of class EventManager.
     */
    @Test
    public void testGetList() throws Exception, RepositoryException {
        System.out.println("getList");
        EventTransactionScripts instance = new EventTransactionScripts();
        List<Event> expResult = null;
        List<Event> result = instance.getList();
        assertTrue(result.size() > 0);
    }

    /**
     * Test of getListByCompany method, of class EventManager.
     */
    @Test
    public void testGetListByCompany() throws Exception, RepositoryException {
        System.out.println("getListByCompany");
        Integer id = 1;
        EventTransactionScripts instance = new EventTransactionScripts();
        List<Event> expResult = null;
        List<Event> result = instance.getListByCompany(id);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of getListOpened method, of class EventManager.
     */
    @Test
    public void testGetListOpened() {
        System.out.println("getListOpened");
        EventTransactionScripts instance = new EventTransactionScripts();
        List<Event> expResult = null;
        List<Event> result = instance.getListOpened();
        assertTrue(result.size() > 0);
    }
    
}
