package table;

import Pokemon.BasePokemon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Grave {
    private ImageView picture;

    public Grave(String pic, boolean IsEnemy, BasePokemon pokemon) {
        Image graveImg = new Image(pic);
        ImageView grave = new ImageView(graveImg);
        grave.setFitHeight(300);
        grave.setFitWidth(300);
        if(IsEnemy){
            grave.setTranslateX(300);
        }
        else {
            grave.setTranslateX(-300);
        }
        grave.setTranslateY(pokemon.getTranslateY());

        this.setPicture(grave);
    }

    public ImageView getPicture() {
        return picture;
    }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }
}


