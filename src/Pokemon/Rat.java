package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Rat extends BasePokemon{
    public Rat() {
        super("Rat", 2500, 200, 0, 10000,Element.POISON);
        Image pokemon = new Image("RatLeft.png");
        Image enemy = new Image("RatRight.png");
        Image skill = new Image("RatSkill.png");
        Image circle = new Image("RatCircle.png");
        Image mySkill = new Image("RatSkill.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        ImageView mySkillImg = new ImageView(mySkill);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
        this.setMySkillImg(mySkillImg);
        this.setHeight(500);
        this.setWidth(500);
        this.setTranslateY(-35);
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(1500);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.POISON) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.ELECTRIC || pokemon.getElement()==Element.LIGHT) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Rat){
            return true;
        }
        return false;
    }
}
