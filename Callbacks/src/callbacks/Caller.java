package callbacks;

public class Caller {
    private Incrementable callbackreferance;

    public Caller(Incrementable cbh) {
        callbackreferance = cbh;
    }
    
    void go(){callbackreferance.increment();}
}
