package rickyguitar;

public class RickyGuitar {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initInventory(inventory);
        
        Guitar whatErinLikes = new Guitar("10", "backWood10", "topWood1", "builder1", "model1", "type1", 22);
        Guitar guitar        = inventory.search(whatErinLikes);
        if(guitar != null){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
    public static void initInventory(Inventory inventory){
        inventory.addGuitar("1", "backWood1", "topWood1", "builder1", "model1", "type1", 22);
        inventory.addGuitar("2", "backWood2", "topWood2", "builder2", "model2", "type2", 4);
        inventory.addGuitar("3", "backWood3", "topWood3", "builder3", "model3", "type3", 242);
        inventory.addGuitar("4", "backWood4", "topWood4", "builder4", "model4", "type4", 25);
    }
}
