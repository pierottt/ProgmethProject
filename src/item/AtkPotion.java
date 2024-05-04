package item;

public class AtkPotion extends BaseItem{
    private final int ATT_BUFF;
    private final int BUFF_TURN;
    public AtkPotion(){
        super("AtkPotion", 1000);
        this.ATT_BUFF = 1000;
        this.BUFF_TURN = 5;
    }

    public int getATT_BUFF() {
        return ATT_BUFF;
    }

    public int getBUFF_TURN() {
        return BUFF_TURN;
    }
}
