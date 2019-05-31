package sample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



    public class MainMenu extends StateBasedGame {
        public static final int menu = 0;
        public static final int play = 1;
        public static final int gameover = 2;




        public MainMenu(String name) {
            super(name);
            this.addState(new MainView(menu));
            this.addState(new View(play));
            this.addState(new GameOver(gameover));




        }

        public void initStatesList(GameContainer gameContainer) throws SlickException {
            this.getState(menu).init(gameContainer,this);
            this.getState(play).init(gameContainer,this);
            this.getState(gameover).init(gameContainer,this);
            this.enterState(menu);
        }




    }


