package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Special_Two extends SpecialFruits {
   // Image[] images;

    //Animation animation;


    public Special_Two() throws SlickException {


        animation=new Animation(images,duration);
    }



    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/spp.png"),new Image("res/spp.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/spp11.png"), new Image("res/spp11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }


}
