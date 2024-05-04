package item;

import usage.defBuffable;

public class DefPotion extends BaseItem implements defBuffable {
    private final int DEF_BUFF;
    private final int BUFF_TURN;
    public DefPotion(){
        super("DefPotion", 500);
        this.DEF_BUFF = 500;
        this.BUFF_TURN = 5;
    }
@Override
    public int getDEF_BUFF() {
        return DEF_BUFF;
    }
@Override
    public int getBUFF_TURN() {
        return BUFF_TURN;
    }


}
