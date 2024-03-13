package item;

public class HealPotion extends BaseItem{
    private final int HEAL;
    public HealPotion(){
        super("HealPotion",500);
        this.HEAL = 300;
    }

    public int getHEAL() {
        return HEAL;
    }
}
