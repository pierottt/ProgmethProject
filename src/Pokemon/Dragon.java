package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Dragon extends BasePokemon{
    public Dragon() {
        super("Dragon", 3500, 400, 200, 8000, Element.FIRE);
        Image pokemon = new Image("DragonLeft.png");
        Image enemy = new Image("DragonRight.png");
        Image skill = new Image("DragonSkillLeft.png");
        Image circle = new Image("DragonCircle.png");
        Image pokemonAttacked = new Image("DragonAttacked.png");
        Image enemyAttacked = new Image("DragonAttackedRight.png");
        ImageView pokemonImg = new ImageView(pokemon);
        ImageView enemyImg = new ImageView(enemy);
        ImageView skillImg = new ImageView(skill);
        ImageView cirlceImg = new ImageView(circle);
        ImageView pokemonImgAttacked = new ImageView(pokemonAttacked);
        ImageView enemyImgAttacked = new ImageView(enemyAttacked);
        ImageView playerPokemonGif = new ImageView("dragonGif.gif");
        ImageView enemyPokemonGif = new ImageView("dragonGifRight.gif");
        this.setPokemonImg(pokemonImg);
        this.setEnemyImg(enemyImg);
        this.setSkillImg(skillImg);
        this.setCircleImg(cirlceImg);
        this.setEnemyImgAttacked(enemyImgAttacked);
        this.setPokemonImgAttacked(pokemonImgAttacked);
        this.setHeight(500);
        this.setWidth(500);
        this.setTranslateY(-35);
        this.setPlayerGif(playerPokemonGif);
        this.setEnemyGif(enemyPokemonGif);
        Path skillPath = new Path();
        skillPath.getElements().add(new MoveTo(-150,-50));
        skillPath.getElements().add(new LineTo(400,200));
        this.setSkillPath(skillPath);
    }

    public void attack(BasePokemon pokemon) {
        pokemon.decreaseHp(getAtk() - pokemon.getDef());
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        if(pokemon.getElement()==Element.FIRE) {
            pokemon.decreaseHp(getAtk()+2000);
        } else if (pokemon.getElement()==Element.POISON || pokemon.getElement()==Element.ICE) {
            pokemon.decreaseHp((getAtk()+2000)*1.5);
        } else {
            pokemon.decreaseHp((getAtk()+2000)*0.5);
        }
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Dragon){
            return true;
        }
        return false;
    }
}
