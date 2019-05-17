package sample;

import org.newdawn.slick.*;

public class Apples extends Fruits{



    public Apples() throws SlickException {


        animation=new Animation(images,duration);
    }



    public Image[] getImages() throws SlickException{
        return images;
    }


    public Image[] getFullImages() throws SlickException {
       Image[] apple = new Image[]{new Image("res/apple.png"),new Image("res/apple.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/apple11.png"), new Image("res/apple11.png")};
        Animation animation = new Animation(sliced,duration);

     return animation;
    }





}
