package sample;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public interface IModel {

    public Image[] getImages() throws SlickException;
    public Image getImage() throws SlickException;
    public Image getSlicedImage() throws SlickException;
    public Image getSlicedImage2() throws SlickException;

    public void Slice();
}
