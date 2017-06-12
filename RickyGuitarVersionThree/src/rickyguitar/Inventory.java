package rickyguitar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }
    
    public void addGuitar(String serialNumber, double price,
            	          Builder builder,     String model,
            		  Type type, Wood backWood, Wood topWood){
        
        Guitar guitar = new Guitar(serialNumber, builder, backWood, topWood, model, type, price);
        
        guitars.add(guitar);
    }
    
    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }
    
    public List search(GuitarSpec searchGuitar){
        List matchingGuitars = new LinkedList();
        for(Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar = (Guitar)i.next();
            GuitarSpec spec = guitar.getSPEC();
            if (searchGuitar.getBuilder() != spec.getBuilder())
	        continue;
	    String model = searchGuitar.getModel().toLowerCase();
	    if ((model != null) && (!model.equals("")) &&
	       (!model.equals(spec.getModel().toLowerCase())))
	        continue;
	    if (searchGuitar.getType() != spec.getType())
	        continue;
	    if (searchGuitar.getBackWood() != spec.getBackWood())
	        continue;
	    if (searchGuitar.getTopWood() != spec.getTopWood())
	        continue;
	      matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
    
}
