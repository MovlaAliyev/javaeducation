/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymous;

/**
 *
 * @author Javatarr
 */
public class Anonymous {

    public Content contents(){
        return new Content(){
              private int i = 2;
              public int value(){
                  return i;
              }
        };
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
