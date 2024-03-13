package item;

import item.usage.Cookable;
import item.usage.CookState;

import java.util.HashMap;

public class Meat extends BaseItem implements Cookable {
    private CookState cookState;
    private final HashMap<CookState, Integer> RECOVER_PT;

    public Meat(CookState cookState){
        super("Meat",20);
        this.cookState = cookState;
        RECOVER_PT = new HashMap<>();
        RECOVER_PT.put(CookState.RAW,5);
        RECOVER_PT.put(CookState.COOKED,20);
        RECOVER_PT.put(CookState.BURNT,-10);
    }

    public int getRecoverPoint(){return RECOVER_PT.get(cookState);}

    @Override
    public CookState getCookState() {
        return cookState;
    }

    @Override
    public void setCookState(CookState cookState) {
        this.cookState = cookState;
    }
}
