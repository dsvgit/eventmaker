package testparse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsv_admin
 */
public class OrderRepository {
    public static int Get(String id) {
        try {
            Integer.parseInt(id);
        } catch(Exception ex) {
            return 0;
        }
        return 1;
    }
}
