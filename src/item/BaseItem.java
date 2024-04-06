package item;

public class BaseItem {
    private String name;
    private int price;

    private int amount;
    BaseItem(String name, int price,int amount){
        this.setName(name);
        this.setPrice(price);
        this.setAmount(amount);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
