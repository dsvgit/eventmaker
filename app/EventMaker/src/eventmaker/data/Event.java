/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.data;

/**
 *
 * @author dsvma_000
 */
public class Event extends Entity {
    private String id;

    @Override
    Object getIdentifier() {
        return id;
    }
    
}
