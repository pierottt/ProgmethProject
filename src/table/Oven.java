package table;

import item.BaseItem;
import item.usage.CookState;
import item.usage.Cookable;

public class Oven{
    private String name;
    public Oven(){
        setName("oven");
    }
    public String interact(BaseItem item){
        if(item instanceof Cookable){
            if(((Cookable) item).getCookState() == CookState.RAW){
                ((Cookable) item).setCookState(CookState.COOKED);
                return "Cooking succeed";
            }
            if(((Cookable) item).getCookState() == CookState.COOKED){
                ((Cookable) item).setCookState(CookState.BURNT);
                return "Your food gone black for some reason";
            }
            if(((Cookable) item).getCookState() == CookState.BURNT){
                return "Your food cannot be cooked anymore";
            }
        }
        return "This item cannot be cooked";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
