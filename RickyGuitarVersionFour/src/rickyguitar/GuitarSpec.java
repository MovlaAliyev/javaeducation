package rickyguitar;

public class GuitarSpec {

    private Type type;
    private Builder builder;
    private Wood backWood;
    private Wood topWood;
    private String model;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, 
                      Type type,int numStrings, 
                      Wood backWood, Wood topWood) {
        
        this.type = type;
        this.builder = builder;
        this.backWood = backWood;
        this.topWood = topWood;
        this.model = model;
        this.numStrings = numStrings;
        
    }

    public int getNumStrings() {
        return numStrings;
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
    
    public boolean matches(GuitarSpec otherSpec) {
	if (builder != otherSpec.builder)
	    return false;
	if ((model != null) && (!model.equals("")) &&
	   (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
	    return false;
	if (type != otherSpec.type)
	    return false;
	if (numStrings != otherSpec.numStrings)
	    return false;
	if (backWood != otherSpec.backWood)
	    return false;
	if (topWood != otherSpec.topWood)
	    return false;
	    return true;
	}
}
