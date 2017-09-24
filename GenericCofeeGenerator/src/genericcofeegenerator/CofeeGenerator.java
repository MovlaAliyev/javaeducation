package genericcofeegenerator;

import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CofeeGenerator 
       implements Generator<Cofee>, Iterable<Cofee>{

    
    private Class[] types = {Latte.class, Mocha.class, Americano.class};
    private Random rand   = new Random(47);

    public CofeeGenerator() {
    }
    
    private int size = 0;
    
    public CofeeGenerator(int size){
        this.size = size;
    }
    
    @Override
    public Cofee next() {
        try {
            return (Cofee)
                    types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(CofeeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CofeeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    class CofeeIterator implements Iterator<Cofee>{
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Cofee next() {
            count--;
            return CofeeGenerator.this.next();
        }
        
    }

    @Override
    public Iterator<Cofee> iterator() {
       return new CofeeIterator();    
    }
    
    public static void main(String[] args) {
        CofeeGenerator cg = new CofeeGenerator();
        for(int i = 0; i < 5; i++)
            System.out.println(cg.next());
        
        for(Cofee c : new CofeeGenerator(5))
            System.out.println(c);
    }
    
}
