package rickyguitar;

public class Guitar {

    private String serialNumber;
    private Builder builder;
    private Wood backWood;
    private Wood topWood;
    private String model;
    private Type type;
    
    private double price;

    public Guitar(String serialNumber, Builder builder, 
                  Wood backWood, Wood topWood, String model, 
                  Type type, double price) {
        this.serialNumber = serialNumber;
        this.backWood    = backWood;
        this.topWood     = topWood;
        this.builder     = builder;
        this.model       = model;
        this.price       = price;
        this.type        = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Builder getBuilder() {
        return builder;
    }

   

    public Wood getBackWood() {
        return backWood;
    }

    
    public Wood getTopWood() {
        return topWood;
    }

    

    public String getModel() {
        return model;
    }

   
    public Type getType() {
        return type;
    }

    
    public double getPrice() {
        return price;
    }

   


}
