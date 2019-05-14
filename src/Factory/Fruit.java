package Factory;

import CommandPattern.GameActions;
import GUI.Fruits;
import GUI.IModel;
import GUI.View;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Fruit implements GameObject {
    @Override
    public int getXlocation() {
        return 0;
    }

    @Override
    public int getYlocation() {
        return 0;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }

    @Override
    public int getInitialVelocity() {
        return 0;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        return null;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

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

}
/*
import GUI.IModel;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

    class Fruits extends BasicGameState implements IModel {
        float xpos,ypos;
        int [] duration = {100,100};
        GUI.Fruits fruits;
        Image[] images;
        boolean isSliced=false;
        Animation animation;

        public Fruits () throws SlickException {
            images=this.getImages();
            animation=new Animation(this.images,duration);
            this.xpos=(float) Math.random()*640;
            this.ypos=0;
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

*/
