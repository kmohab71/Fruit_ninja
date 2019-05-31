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
    Image playGame,MenuButton,Easy,Medium,Hard,japan;
    int Time=0;
    public static final String gamename = "Fruit Ninja";


    //Image MenuButton;

    public MainView(int state){

    }
    public static void display() {
        AppGameContainer apg;
        try {
            apg = new AppGameContainer(new sample.MainMenu(gamename));
            apg.setDisplayMode(640,360,false);
            apg.setTargetFrameRate(500);
            apg.start();
        }catch (SlickException e){e.printStackTrace();}
    }

    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        playGame = new Image("res/background.png");
        MenuButton = new Image("res/fruitninja.png");
        Easy=new Image("res/easy8.png");
        Medium=new Image("res/medium8.png");
        Hard = new Image("res/hard8.png");
        japan = new Image("res/japan.png");

        //gameContainer.setTargetFrameRate(15);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawString("Welcome To Fruit Ninja!",100,50);
        playGame.draw(0,0);
        MenuButton.draw(100,10);
        japan.draw(130,100);
        Easy.draw(10,200);
        Medium.draw(250,200);
        Hard.draw(490,200);




    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        xpos = Mouse.getX();
        ypos = Math.abs(gameContainer.getHeight() - Mouse.getY());
        Time+=i/2;



        Easy.rotate(2*i/3);
        Medium.rotate(2*i/3);
        Hard.rotate(2*i/3);



        Input input = gameContainer.getInput();
        if(input.isMouseButtonDown(0)) {
            if ((xpos > 10 && xpos < 160) && (ypos > 200 && ypos < 374)) {
                Controller.getInstance().setLevel(new EASY());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
            if ((xpos > 250 && xpos < 400) && (ypos > 200 && ypos <374)){
                Controller.getInstance().setLevel(new INTERMEDIATE());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());

            }
            if ((xpos > 490 && xpos < 640 ) && (ypos > 200 && ypos <374)){
                Controller.getInstance().setLevel(new HARD());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());

            }
        }









    }











}