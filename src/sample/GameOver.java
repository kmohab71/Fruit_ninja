package sample;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;


public class GameOver extends BasicGameState {
    int xpos,ypos;
    public int getID() {
        return 2;
    }
    public GameOver(int state){ }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
         g.setColor(Color.black);
         g.drawImage(new Image("res/textGameOver.png"),120,50);
        g.drawImage(new Image("res/newgamebutton1.png"),120,150);
        g.drawImage(new Image("res/exitbutton1.png"),120,250);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        xpos = Mouse.getX();
        ypos = Math.abs(gameContainer.getHeight() - Mouse.getY());

        Input input = gameContainer.getInput();
        if(input.isMouseButtonDown(0)){
            if ((xpos > 120 && xpos < 420) && (ypos > 150 && ypos < 330))
                stateBasedGame.enterState(1);


            if ((xpos > 120 && xpos < 420) && (ypos > 250 && ypos < 330))
                System.exit(0);
        }

    }

}
