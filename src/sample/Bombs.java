package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bombs extends GameObject{
    int [] bombtimer={200,200,200,200};
   // Animation smokeAnimation;

    public Bombs() throws SlickException {
    }
}

class Bomb1 extends Bombs {



    public Bomb1() throws SlickException {
        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/bomb.png"),new Image("res/bomb.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/bomb11.png"), new Image("res/bomb11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }


}
