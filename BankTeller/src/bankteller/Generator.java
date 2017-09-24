/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankteller;

/**
 *
 * @author Javatarr
 */
public interface Generator<T> {
    public <T> T next();
}
