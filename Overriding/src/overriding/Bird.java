package overriding;


public class Bird extends Animal{
    int height      = 3;
    static int size = 5;

    @Override
    public void eat() {
        System.out.println("Bird eating");
    }
    
    static void breathe(){
        System.out.println("Bird breathing");
    }
    
    public void fly(){
        System.out.println("Bird is flying");
    }
    
    
}
