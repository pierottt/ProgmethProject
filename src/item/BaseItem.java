package item;

import usage.purchaseable;

public class BaseItem implements purchaseable {
    private String name;
    private int price;


    BaseItem(String name, int price){
        this.setName(name);
        this.setPrice(price);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
