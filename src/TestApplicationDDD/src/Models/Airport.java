/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.apache.commons.lang3.Validate;

/**
 *
 * @author dsv_admin
 */
public class Airport extends Entity{
    private String code;
    private String name;
    
    public Airport(final String code, final String name) {
        Validate.notNull(code, "Code is required");
        Validate.notNull(name, "Name is required");
        
        this.code = code;
        this.name = name;
    }
    
    public String code() {
        return code;
    }
    
    public String name() {
        return name;
    }
    
    public void changeName(String name) {
        this.name = name;
    }

    @Override
    Object getIdentifier() {
        return code;
    }
}
