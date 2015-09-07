/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.data.exceptions;

import eventmaker.data.shared.Entity;

/**
 *
 * @author dsvma_000
 */
public class DifferentObjectInIdentityMapException extends Throwable {
    public DifferentObjectInIdentityMapException(Object identifier, Entity entity, Entity entityInMap) {
        super(entity + " with identifier " + identifier + " different with " + entityInMap);
    }
}
