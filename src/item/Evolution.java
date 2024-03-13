package item;

public class Evolution extends BaseItem{
    private final int ATT_BUFF;
    private final int DEF_BUFF;
    private final int HP_BUFF;
    public Evolution(){
        super("Evolution",5000);
        this.ATT_BUFF = 100;
        this.DEF_BUFF = 100;
        this.HP_BUFF = 1000;
    }

    public int getATT_BUFF() {
        return ATT_BUFF;
    }

    public int getDEF_BUFF() {
        return DEF_BUFF;
    }

    public int getHP_BUFF() {
        return HP_BUFF;
    }
}
