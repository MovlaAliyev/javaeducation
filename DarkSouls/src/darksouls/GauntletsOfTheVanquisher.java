package darksouls;

public class GauntletsOfTheVanquisher extends Armor {

    public GauntletsOfTheVanquisher() {
        description = "Gauntlets Of The Vanquisher";
    }

    @Override
    public int physicalDefense() {
        return 11;
    }

    @Override
    public int elementDefense() {
        return 7;
    }

    @Override
    public int resistance() {
        return 6;
    }

    @Override
    public int poise() {
        return 4;
    }

    @Override
    public int durability() {
        return 500;
    }

    @Override
    public int weight() {
        return 3;
    }

    @Override
    public int framptSouls() {
        return 100;
    }

}
