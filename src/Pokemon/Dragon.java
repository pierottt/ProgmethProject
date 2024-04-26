package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dragon extends BasePokemon{
    public Dragon() {
        super("Dragon", 3500, 400, 200, 10000, Element.FIRE);
        Image pokemon = new Image("DragonLeft.png");
        Image enemy = new Image("DragonRight.png");
        Image skill = new Image("DragonSkillRight.png");
        Image circle = new Image("DragonCircle.png");
        Image pokemonAttacked = new Image("DragonAttacked.png");
        Image enemyAttacked = new Image("DragonAttackedRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        ImageView pokemonImgAttacked = new ImageView(pokemonAttacked);
        ImageView enemyImgAttacked = new ImageView(enemyAttacked);
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
        this.setEnemyImgAttacked(enemyImgAttacked);
        this.setPokemonImgAttacked(pokemonImgAttacked);
        this.setHeight(500);
        this.setWidth(500);
        this.setTranslateY(-35);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.FIRE) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.POISON || pokemon.getElement()==Element.ICE) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(2000);
    }
    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Dragon){
            return true;
        }
        return false;
    }
}
