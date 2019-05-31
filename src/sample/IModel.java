package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public interface IModel {

    public Image[] getImages() throws SlickException;
    public Image[] getFullImages() throws SlickException;

    public Animation getSlicedImage() throws SlickException;
    public GameObject getRandomGameObject() throws SlickException ;
    public float getXPos();

    public void setXPos(float xpos);

    public double getYPos();

    public void setYPos(double ypos);


    public Boolean hasMovedOffScreen();
    public int Points();

    public void Slice();
}
