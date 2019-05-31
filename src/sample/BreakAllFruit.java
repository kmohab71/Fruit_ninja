package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BreakAllFruit extends GameObject {


    public BreakAllFruit() throws SlickException {
        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/BreakAll.png"),new Image("res/BreakAll.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/BreakAll1.png"), new Image("res/BreakAll1.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }
}
