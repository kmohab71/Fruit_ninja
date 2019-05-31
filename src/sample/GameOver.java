package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


public class GameOver extends BasicGameState {
    int xpos,ypos;

    public int getID() {
        return 2;
    }
    public GameOver(int state){ }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)  {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
         g.setColor(Color.black);
        g.drawImage(new Image("res/background.png"),0,0);
         g.drawImage(new Image("res/gameover3.png"),100,10);
         g.drawImage(new Image("res/newgame.png"),20,200);
         g.drawImage(new Image("res/exit2.png"),30,270);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        xpos = Mouse.getX();
        ypos = Math.abs(gameContainer.getHeight() - Mouse.getY());

        Input input = gameContainer.getInput();
        if(input.isMouseButtonDown(0)){
            if ((xpos > 20 && xpos < 420) && (ypos > 200 && ypos < 260)){
                Controller c=Controller.getInstance();
                Invoker invoker = new Invoker();
                resetGameCommand rgc = new resetGameCommand(c);
                invoker.setC(rgc);
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
                stateBasedGame.enterState(0);}
            if ((xpos > 30 && xpos < 280) && (ypos > 270 && ypos < 330))
                System.exit(0);
        }
    }
}
