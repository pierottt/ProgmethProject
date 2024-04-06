package Pokemon;

import item.usage.Evolable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class BasePokemon implements Evolable {
    private String name;
    private double maxHp;
    private double hp;
    private double atk;
    private double def;
    private Element element;
    private ImageView PokemonImg;
    private ImageView enemyImg;
    private ImageView skillImg;
    private int price;

    //Abstact
    public abstract int getPrice();


    public BasePokemon(String name,double MaxHp, double atk, double def, int price,Element element) {
        setName(name);
        setMaxHp(MaxHp);
        setHp(MaxHp);
        setAtk(atk);
        setDef(def);
        setElement(element);
        setPrice(price);
    }

    public boolean isDead() {
        if(hp<=0) return true;
        else return false;
    }

    public void decreaseHp (double amount) {
        if(amount < 0) amount = 0;
        setHp(getHp()-amount);
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > maxHp) {
            this.hp = maxHp;
        } else this.hp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    @Override
    public boolean getIsEvoled() {
        return false;
    }

    @Override
    public void setIsEvoled(boolean bool) {

    }

    public ImageView getPokemonImg() {
        return PokemonImg;
    }

    public void setPokemonImg(ImageView pokemonImg) {
        PokemonImg = pokemonImg;
    }

    public ImageView getEnemyImg() {
        return enemyImg;
    }

    public void setEnemyImg(ImageView enemyImg) {
        this.enemyImg = enemyImg;
    }

    public ImageView getSkillImg() {
        return skillImg;
    }

    public void setSkillImg(ImageView skillImg) {
        this.skillImg = skillImg;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public abstract void attack(BasePokemon pokemon);
    public abstract void useSkill(BasePokemon pokemon);
}
