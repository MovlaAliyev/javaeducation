package rickyguitar;

public class Guitar {

    private String serialNumber;

    GuitarSpec SPEC;

    private double price;

    public Guitar(String serialNumber, Builder builder,
            Wood backWood, Wood topWood, String model,
            Type type, double price) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.SPEC = new GuitarSpec(type, builder, backWood, topWood, model);

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
