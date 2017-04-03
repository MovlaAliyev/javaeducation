package overriding;


public class Animal {
    int height      = 15;
    static int size = 10;
    
    public void eat(){
        System.out.println("Animal eating..");
    }
    
    static void breathe(){
            System.out.println("Animal breathing");
    }
}
