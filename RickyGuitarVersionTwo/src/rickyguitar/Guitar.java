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

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public void setTopWood(Wood topWood) {
        this.topWood = topWood;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    


}
