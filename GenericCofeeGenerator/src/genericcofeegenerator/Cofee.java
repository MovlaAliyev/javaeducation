package genericcofeegenerator;


public class Cofee {
    private static long counter = 0;
    private final  long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
    
}
