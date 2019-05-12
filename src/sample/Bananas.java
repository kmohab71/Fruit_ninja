package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bananas extends Fruits {

    Image[] images;

    Animation animation;


    public Bananas(float xpos, float ypos) throws SlickException {
        super(xpos, ypos);
        images=this.getImages();
        animation=new Animation(images,duration);
    }

    public Image[] getImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/banana.png"),new Image("res/banana.png")};

        return apple;
    }

    public Image getSlicedImage() throws SlickException{
        Image slicedApples = new Image("res/banana1.png");
        return slicedApples;
    }

    public Image getSlicedImage2() throws SlickException{
        Image slicedApples = new Image("res/banana2.png");
        return slicedApples;
    }




}
