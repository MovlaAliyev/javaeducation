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
public class Customer {

    private static long counter = 1;
    private final long id = counter++;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            public Customer next(){ return new Customer();}
        };
    }

}
