package darksouls;

public class BootsOfTheExplorer extends Armor {

    public BootsOfTheExplorer() {
        description = "Boots Of The Explorer";
    }

    @Override
    public int physicalDefense() {
        return 14;
    }

    @Override
    public int elementDefense() {
        return 10;
    }

    @Override
    public int resistance() {
        return 8;
    }

    @Override
    public int poise() {
        return 6;
    }

    @Override
    public int durability() {
        return 500;
    }

    @Override
    public int weight() {
        return 4;
    }

    @Override
    public int framptSouls() {
        return 100;
    }

}
