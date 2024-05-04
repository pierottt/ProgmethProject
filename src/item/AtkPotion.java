package item;


import usage.atkBuffable;

public class AtkPotion extends BaseItem implements atkBuffable {
    private final int ATT_BUFF;
    private final int BUFF_TURN;

    public AtkPotion() {
        super("AtkPotion", 1000);
        this.ATT_BUFF = 1000;
        this.BUFF_TURN = 5;
    }

    @Override

    public int getATT_BUFF() {
        return ATT_BUFF;
    }

@Override
    public int getBUFF_TURN() {
        return BUFF_TURN;
    }


}
