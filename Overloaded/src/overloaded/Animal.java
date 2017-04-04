package overloaded;

public class Animal {
   
    public void eat(){
        System.out.println("Animal-eat");
    }
    
    public void eat(String s){
        System.out.println("Animal-eat " + s);
    }
    
    public void eat(Animal a){
        System.out.println("Animal eat animal");
    }
    
}
