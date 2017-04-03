package overriding;

public class Overriding {

    
    public static void main(String[] args) {
      Animal a = new Animal();
      Animal b = new Bird();
      Bird   c = new Bird();
      
      a.eat();
      b.eat();
      c.eat();
      
      a.breathe();
      b.breathe(); // cant override static methods
      c.breathe();
      
      c.fly();
      
      System.out.println(a.height + " " + a.size);
      System.out.println(b.height + " " + b.size);
      System.out.println(c.height + " " + c.size);
    }
    
}
