package rickyguitar;

public class GuitarSpec {

    private Type type;
    private Builder builder;
    private Wood backWood;
    private Wood topWood;
    private String model;

    public GuitarSpec(Type type, Builder builder, Wood backWood, Wood topWood, String model) {
        this.type = type;
        this.builder = builder;
        this.backWood = backWood;
        this.topWood = topWood;
        this.model = model;
    }

    public Type getType() {
        return type;
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

}
