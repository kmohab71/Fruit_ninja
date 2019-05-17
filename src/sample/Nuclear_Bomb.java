package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Nuclear_Bomb extends Bombs {




    public Nuclear_Bomb() throws SlickException {
        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/nbomb.png"),new Image("res/nbomb.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/abomb11.png"), new Image("res/abomb11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }






}
