package CommandPattern;

import Factory.Bomb;
import Factory.Fruit;
import GUI.View;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import GUI.Fruits;
import Factory.GameObject;

public class GameActions implements Controller{

    private Fruit fruit;
    private Bomb bomb;
    private View view;

    public GameActions(Fruit fruit, Bomb bomb, View view) {
        this.fruit = fruit;
        this.bomb = bomb;
        this.view = view;
    }

    public void Display()
    {
        view.mainMenu();
    }

    @Override
    public GameObject createGameObject() {
        return null;
    }

    @Override
    public void updateObjectsLocations() {

    }

    @Override
    public void sliceObjects(GameContainer gc, StateBasedGame sbg, Graphics g, Fruits sample) throws SlickException {

    }

    int timePassed=0;
    boolean clear=false;


    public void sliceObjects(GameContainer gc, StateBasedGame sbg, Graphics g, Fruit sample) throws SlickException {
        sample.getSlicedImage().draw(300,300);
        sample.getSlicedImage2().draw(360,300);
        if(clear){
            sample.getSlicedImage2().draw(300,300, Color.transparent);
            g.drawString("HELLO",50,50);}

    }
    public void Timer(GameContainer gc,StateBasedGame sbg,int i,Fruits sample) throws SlickException
    {
        timePassed+=i;
        if(timePassed>500)
            clear=true;
    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void ResetGame() {

    }
}
