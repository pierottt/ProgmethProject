package item;

public class DefPotion extends BaseItem{
    private final int DEF_BUFF;
    private final int BUFF_TURN;
    public DefPotion(){
        super("DefPotion", 500);
        this.DEF_BUFF = 30;
        this.BUFF_TURN = 5;
    }

    public int getDEF_BUFF() {
        return DEF_BUFF;
    }

    public int getBUFF_TURN() {
        return BUFF_TURN;
    }
}
