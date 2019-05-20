package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class View extends BasicGameState {

    int timePassed,time;
    Image worldmap;





   GameObject gameObject;


    Controller c;
    Invoker invoker;
    public int getID() {
        return 1;
    }


    public View(int state){ }



    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        worldmap = new Image("res/City2.png");
        gameObject = new GameObject();


        try {
            c=Controller.getInstance();
            invoker = new Invoker();
            invoker.setC(new NewGameCommand(c,c.getLevel()));
            invoker.Action();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }



        gameContainer.setMouseCursor(new Image("res/sword22.png"),0,0);

    }


    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        worldmap.draw(0,0);

          // g.drawString("Number of fruits"+c.gameObjects.size(),100,150);
           DrawHearts(c.Hearts,g);
           DrawFruits(c.gameObjects);


           g.drawImage(new Image("res/arcade.png"),150,170);




           g.drawString("Time:"+time/1000,100,100);
           g.drawString("Score:"+c.count,100,130);
           g.drawString("High Score:"+c.HighScore,100,170);


    }




    public void DrawHearts(int n,Graphics g) throws SlickException{
        for(int f=0;f<n;f++)
            g.drawImage(new Image("res/heart.png"),550+20*f,50);
    }









  public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        timePassed+=i/2;
        time+=i;
        int t=c.getTimePassed();
        t+=i/2;
        c.setTimePassed(t);


     c.GameOver(stateBasedGame,c.cut);
     c.Loss(c.cut);
     c.UpdateHighScore();


      FruitFall(c.noOfFruits(),c.gameObjects,i);



    }


    public void FruitFall(int NumOfFruits,List<GameObject> sample,int i )throws SlickException{


        for(int f=0;f<c.gameObjects.size();f++){
            c.gameObjects.get(f).setYPos(c.gameObjects.get(f).getYPos()+(c.speed()*(i)));
           // c.Loss(c.gameObjects.get(f));
        }




        if(timePassed>300){
            timePassed=0;
            c.setTimePassed(0);


            for(int k=0;k<NumOfFruits;k++)
                c.AddObject(gameObject,c.gameObjects);

        }

    }




   //DRAWS THE FRUITS IN THEIR UPDATED POSITION
    public void DrawFruits(List<GameObject> gameObjects) throws SlickException{

        for(int f=0;f<gameObjects.size();f++){
            gameObjects.get(f).animation.draw(gameObjects.get(f).getXPos(), (float) gameObjects.get(f).getYPos());


        }}



        //TO SEE SLICING
        public void mouseMoved(int oldx, int oldy, int newx, int newy) {
            for (int f = 0; f < c.gameObjects.size(); f++) {

                if (oldx > c.gameObjects.get(f).getXPos() && newx < c.gameObjects.get(f).getXPos() + 60 &&
                        oldy > c.gameObjects.get(f).getYPos() && newy < c.gameObjects.get(f).getYPos() + 75) {

                    c.cut = c.gameObjects.get(f);
                    try {
                        if (!c.cut.isSliced) {
                            c.count++;
                            c.Slice();
                            System.out.println(c.cut);
                            System.out.println(c.Hearts);}

                            else continue;




                    } catch (SlickException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

      }








