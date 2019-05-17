package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Oranges extends Fruits{

    public Oranges() throws SlickException {

        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/orange.png"),new Image("res/orange.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/orange11.png"), new Image("res/orange11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }

}
