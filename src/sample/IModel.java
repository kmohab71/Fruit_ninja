package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public interface IModel {

    public Image[] getImages() throws SlickException;
    public Image[] getFullImages() throws SlickException;

    public Animation getSlicedImage() throws SlickException;
    public Boolean hasMovedOffScreen();
    public int Points();

    public void Slice();
}
