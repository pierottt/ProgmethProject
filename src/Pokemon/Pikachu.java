package Pokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Pikachu extends BasePokemon{

    public Pikachu() {
        super("Pikachu", 1000, 150, 50, 100, Element.ELECTRIC);
        Image pokemon = new Image("PikachuLeft.png");
        Image enemy = new Image("PikachuRight.png");
        Image skill = new Image("PikachuSkill.png");
        Image circle = new Image("PikachuCircle.png");
        Image mySkill = new Image("PikachuSkill.png");
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
        this.setHeight(200);
        this.setWidth(200);
        this.setTranslateY(65);
    }

    public void attack(BasePokemon pokemon) {
        if(pokemon.getElement()==Element.ELECTRIC) {
            pokemon.decreaseHp(getAtk() - pokemon.getDef());
        } else if (pokemon.getElement()==Element.FIRE || pokemon.getElement()==Element.ICE) {
            pokemon.decreaseHp(getAtk()*1.5 - pokemon.getDef());
        } else {
            pokemon.decreaseHp(getAtk()*0.5 - pokemon.getDef());
        }
    }

    @Override
    public void useSkill(BasePokemon pokemon){
        pokemon.decreaseHp(100);
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public boolean equals(BasePokemon pokemon) {
        if(pokemon instanceof Pikachu) {
            return true;
        }
        return false;
    }
}
