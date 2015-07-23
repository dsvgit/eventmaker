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
public class UserRepository {
    public int Get(String id) {
        try {
            Integer.parseInt(id);
        } catch(Exception ex) {
            return 0;
        }
        doSomeCoolAction();
        return 1;
    }
    
    public int GetSomething(String id, String anothorId) {
        try {
            Integer.parseInt(id);
            Integer.parseInt(anothorId);
        } catch(Exception ex) {
            return 0;
        }
        doSomeCoolAction();
        return 1;
    }
    
    private void doSomeCoolAction() {
        
    } 
}
