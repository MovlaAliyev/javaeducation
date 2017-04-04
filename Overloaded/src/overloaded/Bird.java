package overloaded;

public class Bird extends Animal {

    @Override
    public void eat() {         // override 
        System.out.println("Bird eat override");
    }

    
    public void eat(String s) { // overloade
        System.out.println("Bird eat " + s);
    }
    
    public void eat(Bird b){
        System.out.println("Bird eat");
    }

}
