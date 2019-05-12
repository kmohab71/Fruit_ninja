package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Oranges extends Fruits{

    public Oranges(float xpos, float ypos) throws SlickException {
        super(xpos, ypos);
        images=this.getImages();
        animation=new Animation(images,duration);
    }

    public Image[] getImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/orange.png"),new Image("res/orange.png")};

        return apple;
    }

    public Image getSlicedImage() throws SlickException{
        Image slicedApples = new Image("res/orange1.png");
        return slicedApples;
    }

    public Image getSlicedImage2() throws SlickException{
        Image slicedApples = new Image("res/orange2.png");
        return slicedApples;
    }
}
