package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.List;

public class Controller {
   // GameContainer gc;
    //StateBasedGame sbg;
    //Graphics g;
    int timePassed=0;
    boolean clear=false;


    public void Slice(GameContainer gc,StateBasedGame sbg,Graphics g,Fruits sample) throws SlickException {


        sample.getSlicedImage().draw(300,300);
        sample.getSlicedImage2().draw(360,300);
        if(clear){
            sample.getSlicedImage2().draw(300,300, Color.transparent);
            g.drawString("HELLO",50,50);}


    }

    public void Timer(GameContainer gc,StateBasedGame sbg,int i,Fruits sample) throws SlickException {

        timePassed+=i;

        if(timePassed>500)
            clear=true;


    }





}