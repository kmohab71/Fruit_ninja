package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BonusFruit extends GameObject {
    public BonusFruit() throws SlickException {
        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/bonusFruit.png"),new Image("res/bonusFruit.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/BF1.png"), new Image("res/BF1.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }



}
