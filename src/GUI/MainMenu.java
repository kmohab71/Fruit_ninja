package GUI;


import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;


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
        SoundStore.get().setMaxSources(32);


        this.getState(menu).init(gameContainer, this);
        this.getState(play).init(gameContainer, this);
        this.enterState(menu);
    }
}






