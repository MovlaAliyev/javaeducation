package bankteller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves" + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> q = new LinkedList<>();
        Generators.fill(q, Customer.generator(), 15);

        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator(), 4);

        for (Customer c : q) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }

}
