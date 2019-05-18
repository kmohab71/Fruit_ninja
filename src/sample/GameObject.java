package sample;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameObject implements IModel {


    int points=0;
    float xpos=50;
    double ypos=0;



    int [] duration = {100,100};
    Image[] images=getFullImages();
    public Animation animation;



    public GameObject () throws SlickException {

    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public int Points() {
        return 0;
    }

    @Override
    public void Slice() {

    }

    public List<GameObject> getGameObjects() throws SlickException {
       List<GameObject> gameObjects=new ArrayList<>();

       for (int i=1;i<8;i++)
           gameObjects.add(Factory.FactoryGameObj(i));




        return gameObjects;

    }

    public GameObject getRandomGameObject() throws SlickException {

        return getGameObjects().get(new Random().nextInt(getGameObjects().size()));

    }

    public float getXPos() {
        return xpos;
    }

    public void setXPos(float xpos) {
        this.xpos = xpos;
    }

    public double getYPos() {
        return ypos;
    }

    public void setYPos(double ypos) {
        this.ypos = ypos;
    }

    public Image[] getImages() throws SlickException {
        return images;
    }

    public void setImages(Image[] images){
        this.images=images;
    }

    public Image[] getFullImages() throws SlickException {
        return null;
    }




    public Animation getSlicedImage() throws SlickException {
        return null;
    }









}



