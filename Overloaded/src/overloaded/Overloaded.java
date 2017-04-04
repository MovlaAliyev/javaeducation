package overloaded;

public class Overloaded {

    public static void main(String[] args) {
        Animal a  = new Animal();
        Animal ab = new Bird();
        Bird b    = new Bird();
        Sum  s    = new Sum();
        
        a.eat();
        a.eat("overloaded");
        a.eat(a);
        
        b.eat();
        b.eat("test");
        b.eat(b);
        
        ab.eat();
        ab.eat("overloaded");
        ab.eat(ab); // animal's eat method will called
        
        System.out.println(s.getSum(3, 5));    // int 
        System.out.println(s.getSum(5.5, 20)); // double

    }

}
