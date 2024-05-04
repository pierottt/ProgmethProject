package item;

import usage.healable;

public class HealPotion extends BaseItem implements healable {
    private final int HEAL;
    public HealPotion(){
        super("HealPotion",500);
        this.HEAL = 500;
    }
@Override
    public int getHEAL() {
        return HEAL;
    }
}
