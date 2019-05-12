package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Fruits extends BasicGameState implements IModel {
    float xpos,ypos;
    int [] duration = {100,100};
    Fruits fruits;
    Image[] images;
    boolean isSliced=false;
    Animation animation;

    public Fruits (float xpos,float ypos) throws SlickException {
        images=this.getImages();
        animation=new Animation(this.images,duration);
        this.xpos=xpos;
        this.ypos=ypos;
    }
    public int getID() {
        return 1;
    }

    public void Move() {

    }
    public Image[] getImages() throws SlickException {
        return null;
    }
    public Image getImage() throws SlickException{
        return null;
    }

    public Image getSlicedImage() throws SlickException {
        return null;
    }

    public Image getSlicedImage2() throws SlickException {
        return null;
    }



    public void setImages(Image[] images){
        this.images=images;
    }

    public void Slice() {

    }

    public float getXPos() {
        return xpos;
    }

    public void setXPos(float xpos) {
        this.xpos = xpos;
    }

    public float getYPos() {
        return ypos;
    }

    public void setYPos(float ypos) {
        ypos = ypos;
    }


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }


}
