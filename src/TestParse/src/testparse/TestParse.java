/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testparse;

import java.util.Scanner;

/**
 *
 * @author dsv_admin
 */
public class TestParse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print(">>Input id: ");
        Scanner s = new Scanner(System.in);
        String inputId = s.nextLine();
        
        UserRepository userRep = new UserRepository();
        CustomerRepository customerRep = new CustomerRepository();
        OrderRepository orderRep = new OrderRepository();
        
        int user = userRep.Get(inputId);
        int customer = customerRep.Get(inputId);
        int order = orderRep.Get(inputId);
        
        System.out.print(">>Input id: user");
        System.out.print(">>Input id: customer");
        System.out.print(">>Input id: order");
    }
    
}
