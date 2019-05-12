package sample;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



    public class MainMenu extends StateBasedGame {
        public static final String gamename = "Fruit Ninja";
        public static final int menu = 0;
        public static final int play = 1;

        public MainMenu(String name) {
            super(name);
            this.addState(new MainView(menu));
            this.addState(new View(play));


        }

        public void initStatesList(GameContainer gameContainer) throws SlickException {
            this.getState(menu).init(gameContainer,this);
            this.getState(play).init(gameContainer,this);
            this.enterState(menu);
        }



        public static void main(String[] args) {
            AppGameContainer apg;
            try {
                apg = new AppGameContainer(new sample.MainMenu(gamename));
                apg.setDisplayMode(640,360,false);
                apg.setTargetFrameRate(500);
                apg.start();
            }catch (SlickException e){e.printStackTrace();}
        }
    }


