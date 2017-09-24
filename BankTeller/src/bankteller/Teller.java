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
public class Teller {

    private static long counter = 1;
    private final long id = counter++;

    public Teller() {
    }
    
    public String toString() { return "Teller " + id; }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            public Teller next(){return new Teller();}
        };
    }
}
