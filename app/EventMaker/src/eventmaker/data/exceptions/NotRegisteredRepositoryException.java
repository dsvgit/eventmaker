/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.data.exceptions;

import eventmaker.data.Entity;

/**
 *
 * @author dsvma_000
 */
public class NotRegisteredRepositoryException extends Throwable{
    public NotRegisteredRepositoryException(Entity entity) {
        super("this entity " + entity + " non registered");
    }
}
