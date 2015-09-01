/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.core.repository.exceptions;

/**
 *
 * @author dsvma_000
 */
public class NotFoundException extends Throwable {
    public NotFoundException(Object identifier) {
        super(identifier + " not found");
    }    
}
