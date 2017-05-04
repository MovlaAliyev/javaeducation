package darksouls;

public abstract class Set {

    String description = "default";

    public String getDescription() {
        return description;
    }

    public abstract int physicalDefense();

    public abstract int elementDefense();

    public abstract int resistance();

    public abstract int poise();

    public abstract int durability();

    public abstract int weight();

    public abstract int framptSouls();
}
