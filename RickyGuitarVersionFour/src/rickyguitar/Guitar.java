package rickyguitar;

public class Guitar {

    private String serialNumber;

    GuitarSpec SPEC;

    private double price;

    public Guitar(String serialNumber, double price, GuitarSpec SPEC) {
        this.serialNumber = serialNumber;
        this.price        = price;
        this.SPEC         = SPEC;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public GuitarSpec getSPEC() {
        return SPEC;
    }

    public double getPrice() {
        return price;
    }
    
    

}
