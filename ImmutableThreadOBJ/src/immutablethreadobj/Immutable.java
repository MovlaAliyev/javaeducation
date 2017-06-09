package immutablethreadobj;

import java.util.HashSet;
import java.util.Set;

public final class Immutable {

    private final Set<String> stooges = new HashSet<String>();

    public Immutable() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }
    
    public boolean isStooge(String name){
        return stooges.contains(name);
    }

}
