/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.util.List;
import java.util.Map;


public class LimitOfInference {
    static void f(Map<Person, List<? extends Pet>> getPeople){}

    public static void main(String[] args) {
        f(New.map());
    }
}
