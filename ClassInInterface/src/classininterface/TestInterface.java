/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classininterface;

/**
 *
 * @author Javatarr
 */
public interface TestInterface {
    void howdy();
    public class Test implements TestInterface{

        @Override
        public void howdy() {
            System.out.println("Howdy");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
