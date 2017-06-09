package rickyguitar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }
    
    public void addGuitar(String seralNumber, String backWood, 
                  String topWood,     String builder, 
                  String model,       String type,
                  double price){
        
        Guitar guitar = new Guitar(seralNumber, backWood, topWood, builder, 
                                   model, type, price);
        guitars.add(guitar);
    }
    
    public Guitar getGuitar(String serialNumber){
        for(Iterator i = guitars.iterator(); i .hasNext();){
            Guitar guitar = (Guitar)i.next();
            if(guitar.getSeralNumber().equals(serialNumber))
                return guitar;
        }
        return null;
    }
    
    public Guitar search(Guitar searchGuitar){
        for(Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar = (Guitar)i.next();
            String builder = searchGuitar.getBuilder();
            if((builder != null) && (!builder.equals("")) &&
                (!builder.equals(guitar.getBuilder())))
                break;
            String model = searchGuitar.getModel();
            if((model != null) && (!model.equals("")) &&
                (!model.equals(guitar.getModel())))
                break;
            String type = searchGuitar.getType();
            if((type != null) && (!type.equals("")) &&
                (!type.equals(guitar.getType())))
                break;
            String backWood = searchGuitar.getBackWood();
            if((backWood != null) && (!backWood.equals("")) &&
                (!backWood.equals(guitar.getBackWood())))
                break;
            String topWood = searchGuitar.getTopWood();
            if((topWood != null) && (!topWood.equals("")) &&
                (!topWood.equals(guitar.getTopWood())))
                break;
            else
                return guitar;
        }
        
        return null;
    }
    
}
