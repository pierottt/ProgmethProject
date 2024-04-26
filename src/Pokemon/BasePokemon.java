package Pokemon;

import item.usage.Evolable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public abstract class BasePokemon implements Evolable {
    private String name;
    private double maxHp;
    private double hp;
    private double atk;
    private double def;
    private Element element;
    private ImageView PokemonImg;

    private ImageView PokemonImgAttacked;
    private ImageView enemyImg;



    private ImageView enemyImgAttacked;
    private ImageView skillImg;
    private ImageView circleImg;
    private int height;
    private int width;
    private int translateY;
    private int price;
    private Path skillPath;
    //Abstact
    public abstract int getPrice();

    public abstract boolean equals(BasePokemon pokemon);


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

    public ImageView getPokemonImgAttacked() {
        return PokemonImgAttacked;
    }

    public void setPokemonImgAttacked(ImageView pokemonImgAttacked) {
        PokemonImgAttacked = pokemonImgAttacked;
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

    public ImageView getEnemyImgAttacked() {
        return enemyImgAttacked;
    }

    public void setEnemyImgAttacked(ImageView enemyImgAttacked) {
        this.enemyImgAttacked = enemyImgAttacked;
    }

    public ImageView getCircleImg() {
        return circleImg;
    }

    public void setCircleImg(ImageView circleImg) {
        this.circleImg = circleImg;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getTranslateY() {
        return translateY;
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
    }

    public Path getSkillPath() {
        return skillPath;
    }

    public void setSkillPath(Path skillPath) {
        this.skillPath = skillPath;
    }
}
