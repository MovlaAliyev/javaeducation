package rickyguitar;

public class Guitar {

    private String seralNumber;
    private String backWood;
    private String topWood;
    private String builder;
    private String model;
    private String type;
    
    private double price;

    public Guitar(String seralNumber, String backWood, 
                  String topWood,     String builder, 
                  String model,       String type,
                  double price) {
        
        this.seralNumber = seralNumber;
        this.backWood    = backWood;
        this.topWood     = topWood;
        this.builder     = builder;
        this.price       = price;
        this.model       = model;
        this.type        = type;
    }

    public double getPrice() {
        return price;
    }

    public String getSeralNumber() {
        return seralNumber;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

}
