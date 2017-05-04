package darksouls;

public class HelmOfTheWise extends Armor {

    public HelmOfTheWise() {
        description = "Helm of the Wise";
    }

    @Override
    public int physicalDefense() {
        return 18;
    }

    @Override
    public int elementDefense() {
        return 12;
    }

    @Override
    public int resistance() {
        return 11;
    }

    @Override
    public int poise() {
        return 8;
    }

    @Override
    public int durability() {
        return 500;
    }

    @Override
    public int weight() {
        return 5;
    }

    @Override
    public int framptSouls() {
        return 100;
    }

}
