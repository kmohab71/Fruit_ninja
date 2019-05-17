package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class View extends BasicGameState {

    int timePassed,time;
    Image worldmap;


//float Speed= (float) 0.8;
   GameObject cut;


    GameObject gameObject;
    List<GameObject> gameObjects;
    Controller c;



    boolean isSliced = false;


    public int getID() {
        return 1;
    }


    public View(int state){ }



    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        worldmap = new Image("res/City2.png");
        gameObject = new GameObject();
        gameObjects = new ArrayList<>();
        c=new Controller();

        c.newGame(HARD.getInstance());


        gameContainer.setMouseCursor(new Image("res/sword22.png"),0,0);

    }


    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        worldmap.draw(0,0);

           g.drawString("Number of fruits"+gameObjects.size(),100,150);
           DrawHearts(c.Hearts,g);
           DrawFruits(gameObjects);



         g.drawString("Time:"+time/1000,100,100);
         g.drawString("Score:"+c.getScore(),100,130);

    }




    public void DrawHearts(int n,Graphics g) throws SlickException{
        for(int f=0;f<n;f++)
            g.drawImage(new Image("res/heart.png"),550+20*f,50);
    }









  public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        timePassed+=i/2;
        time+=i;
        c.timePassed+=i/2;

     FruitFall(3,gameObjects,i);
    //c.GameOver(stateBasedGame,cut);



    }







    






    public void FruitFall(int NumOfFruits,List<GameObject> sample,int i )throws SlickException{


        for(int f=0;f<gameObjects.size();f++){
            gameObjects.get(f).setYPos(gameObjects.get(f).getYPos()+(c.speed()*(i)));
            c.Loss(sample,cut);
             }


            if(timePassed>300){
                timePassed=0;
                c.timePassed=0;


                for(int k=0;k<NumOfFruits;k++)
                c.AddObject(gameObject,gameObjects);

            }

        }



   //DRAWS THE FRUITS IN THEIR UPDATED POSITION
    public void DrawFruits(List<GameObject> gameObjects) throws SlickException{

        for(int f=0;f<gameObjects.size();f++){
            gameObjects.get(f).animation.draw(gameObjects.get(f).getXPos(), (float) gameObjects.get(f).getYPos());


        }}



        //TO SEE SLICING
        public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        for(int f=0;f<gameObjects.size();f++){
            if(oldx> gameObjects.get(f).getXPos() &&newx<gameObjects.get(f).getXPos()+60&&
                    oldy> gameObjects.get(f).getYPos() && newy<gameObjects.get(f).getYPos()+75){
                isSliced=true;
                cut = gameObjects.get(f);
                try {
                    c.Slice(cut);
                } catch (SlickException e) {
                    e.printStackTrace();
                }
            }}}



}




