package sample;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainView extends BasicGameState {
    int xpos;
    int ypos;
    Image playGame,MenuButton,Easy,Medium,Hard;
    //Image MenuButton;

    public MainView(int state){

    }

    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        playGame = new Image("res/City2.png");
        MenuButton = new Image("res/textGetReady.png");
        Easy=new Image("res/easy.png");
        Medium=new Image("res/medium.png");
        Hard = new Image("res/hard.png");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawString("Welcome To Fruit Ninja!",100,50);
        playGame.draw(0,0);
        MenuButton.draw(100,50);
        Easy.draw(10,150);
        Medium.draw(330,150);
        Hard.draw(180,250);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        xpos = Mouse.getX();
        ypos = Math.abs(gameContainer.getHeight() - Mouse.getY());

        Input input = gameContainer.getInput();
        if(input.isMouseButtonDown(0)) {
            if ((xpos > 10 && xpos < 310) && (ypos > 150 && ypos < 230)) {
                Controller.getInstance().setLevel(new EASY());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
            if ((xpos > 330 && xpos < 630) && (ypos > 150 && ypos <230)){
                Controller.getInstance().setLevel(new INTERMEDIATE());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());

            }
            if ((xpos > 180 && xpos < 480 ) && (ypos > 250 && ypos <330)){
                Controller.getInstance().setLevel(new HARD());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());

            }
        }
    }
}