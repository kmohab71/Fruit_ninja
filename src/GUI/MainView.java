package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainView extends BasicGameState {
    int xpos;
    int ypos;
    Image playGame;
    Image MenuButton;

    public MainView(int state){

    }

    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        playGame = new Image("res/City2.png");
        MenuButton = new Image("res/textGetReady.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawString("Welcome To Fruit Ninja!",100,50);
        playGame.draw(0,0);
        MenuButton.draw(100,100);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        xpos = Mouse.getX();
        ypos = Math.abs(gameContainer.getHeight() - Mouse.getY());

        Input input = gameContainer.getInput();
        if((xpos>100 && xpos<500)&& (ypos>100 && ypos<173)){
            if(input.isMouseButtonDown(0)){
                stateBasedGame.enterState(1);}
        }
    }
}
