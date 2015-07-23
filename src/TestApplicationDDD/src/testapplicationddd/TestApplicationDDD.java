/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplicationddd;

import Models.Airport;
import Models.Entity;

/**
 *
 * @author dsv_admin
 */
public class TestApplicationDDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Airport a1 = new Airport("1", "Pulkovo");
        Airport a2 = new Airport("1", "Domodedovo");
        
        boolean check = a1.equals(a2);
        
        System.out.println(check);
    }
    
}
