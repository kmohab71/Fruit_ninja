package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bombs extends GameObject{
    int [] bombtimer={200,200,200,200};
   // Animation smokeAnimation;

    public Bombs() throws SlickException {
    }

   /* public Animation Smoke() throws SlickException{

        Image[] smoke = new Image[]{new Image("res/00.png"), new Image("res/01.png"),
                new Image("res/02.png"),new Image("res/03.png")};
        Animation smokeAnimation = new Animation(smoke,bombtimer);
        return smokeAnimation;
    }*/


}
