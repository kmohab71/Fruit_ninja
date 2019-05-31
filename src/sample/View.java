package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class View extends BasicGameState {

    int timePassed,time;
    Image worldmap;
    Music music;
    TrueTypeFont font1;
    Color hotpink = new Color(232,73,148);
    Input input;






   GameObject gameObject;


    Controller c;
    Invoker invoker;
    public int getID() {
        return 1;
    }


    public View(int state){ }



    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        worldmap = new Image("res/background.png");
        gameObject = new GameObject();
        //music=new Music("res/musicwav.wav");
        java.awt.Font font = new java.awt.Font("Press Start 2P", java.awt.Font.BOLD,18);
        font1 = new TrueTypeFont(font,false);
        input = gameContainer.getInput();
        try {
            c=Controller.getInstance();
            invoker = new Invoker();
            invoker.setC(new NewGameCommand(c,c.getLevel()));
            invoker.Action();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gameContainer.setMouseCursor(new Image("res/sword22.png"),0,0);
    }


    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
           worldmap.draw(0,0);
           DrawHearts(c.Hearts,g);
           DrawFruits(c.gameObjects);
           font1.drawString(40,50,"Time:"+time/1000,hotpink);
           font1.drawString(40,80,"Score:"+c.count,hotpink);
           font1.drawString(40,110,"High Score:"+c.HighScore,hotpink);
           font1.drawString(500,110,"Save(S)",hotpink);
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
      GameOverCommand goc = new GameOverCommand(stateBasedGame,c);
      invoker.setC(goc);
      try {
          invoker.Action();
      } catch (Exception e) {
          e.printStackTrace();
      }
      LossCommand lc = new LossCommand(c.getCut(),c);
      invoker.setC(lc);
      try {
          invoker.Action();
      } catch (Exception e) {
          e.printStackTrace();

      }
      updateHSCommand uhsc = new updateHSCommand(c);
      invoker.setC(uhsc);
      try {
          invoker.Action();
      } catch (Exception e) {
          e.printStackTrace();
      }
      FruitFall(c.getnoOfFruits(),i);
    }

    public void FruitFall(int NumOfFruits,int i )throws SlickException{
        for(int f=0;f<c.gameObjects.size();f++){
            c.gameObjects.get(f).setYPos(c.gameObjects.get(f).getYPos()+(c.speed()*(i)));
        }
        if(timePassed>300){
            timePassed=0;
            c.setTimePassed(0);
            for(int k=0;k<NumOfFruits;k++)
                c.AddObject(gameObject,c.gameObjects);
        }
    }




   //DRAWS THE FRUITS IN THEIR UPDATED POSITION
    public void DrawFruits(List<GameObject> gameObjects){
        for(int f=0;f<gameObjects.size();f++){
            gameObjects.get(f).animation.draw(gameObjects.get(f).getXPos(), (float) gameObjects.get(f).getYPos());
        }
    }
        //TO SEE SLICING
        public void mouseMoved(int oldx, int oldy, int newx, int newy) {
            for (int f = 0; f < c.gameObjects.size(); f++) {

                if (oldx > c.gameObjects.get(f).getXPos() && newx < c.gameObjects.get(f).getXPos() + 60 &&
                        oldy > c.gameObjects.get(f).getYPos() && newy < c.gameObjects.get(f).getYPos() + 75) {

                    c.cut = c.gameObjects.get(f);
                    try {
                        if (!c.cut.isSliced) {
                            if(c.cut instanceof SpecialFruits)
                                c.count+=2;
                            else c.count++;
                            SliceCommand sc = new SliceCommand(c);
                            invoker.setC(sc);
                            try {
                                invoker.Action();
                            } catch (TransformerException e) {
                                e.printStackTrace();
                            } catch (ParserConfigurationException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (SAXException e) {
                                e.printStackTrace();
                            }
                        }
                            else continue;
                    } catch (SlickException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
      }








