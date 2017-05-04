package darksouls;

public class ArmorOfTheGlorious extends Armor {

    Set set;

    public ArmorOfTheGlorious(Set set) {
        this.set = set;
    }

    @Override
    public int physicalDefense() {
       return set.physicalDefense() + addEquipimentPower(set.physicalDefense(), 47);
    }

    @Override
    public int elementDefense() {
        return set.elementDefense()+ addEquipimentPower(set.elementDefense(), 31);
    }

    @Override
    public int resistance() {
        return set.resistance()+ addEquipimentPower(set.resistance(), 28);
    }

    @Override
    public int poise() {
        return set.poise()+ addEquipimentPower(set.poise(), 20);
    }

    @Override
    public int durability() {
        return 500;
    }

    @Override
    public int weight() {
        return set.weight()+ addEquipimentPower(set.weight(), 13);
    }

    @Override
    public int framptSouls() {
        return 100;
    }

    @Override
    public String getDescription() {
        return 
    }

    public int addEquipimentPower(int a, int b) {
        if(a < b)
            return b - a;
        else
            return a - b;
    }

}
