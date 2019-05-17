package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.List;
import java.util.Random;

public class Controller {
    int timePassed=0;
    boolean clear=false;
    int score=0;
    int Hearts=3;
     iLevel level;
    //static setLevel currentLEVEL = new setLevel(my_level);
    Random random;


    /*public static void setMy_level(iLevel my_level) {
        Controller.my_level = my_level;
    }*/

    public void newGame(iLevel level) {
        this.level=level;

    }

    public void Slice(GameObject sample) throws SlickException {
//timePassed+=;

       sample.animation=sample.getSlicedImage();
       setScore(score+=sample.Points());

      /* if (sample instanceof Bombs){
           while (timePassed<300){
               ((Bombs) sample).Smoke().draw(sample.getXPos(),sample.getYPos());
           }
       }*?




    }

    /*public void Timer(int i,GameObject sample) throws SlickException {

        timePassed+=i;

        if(timePassed>500){
        clear=true;}*/

    }



    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score=score;
    }

    public void GameOver(StateBasedGame sbg,GameObject gameObject){
        if(Hearts==0 || gameObject instanceof Nuclear_Bomb)
            sbg.enterState(2,new FadeOutTransition(),new FadeInTransition());
    }


    public void Loss(List<GameObject> gameObjects,GameObject gameObject){



        for(int f=0;f<gameObjects.size();f++){
            if(gameObjects.get(f).getYPos()>290){
                Hearts--;
                gameObjects.remove(f);
            }
        }

        if(gameObject instanceof Bomb1)
            Hearts--;


    }


    public GameObject AddObject(GameObject gameObject, List<GameObject> sample) throws SlickException{


        random = new Random();
        GameObject object = gameObject.getRandomGameObject();
        sample.add(object);
        object.setXPos(random.nextInt(500));
        return object;

    }



    public double speed() {
        return level.speed();
    }

    public double noOfFruits() {
        return level.noOfFruits();
    }
}