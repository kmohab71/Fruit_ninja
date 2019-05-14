package CommandPattern;

import Factory.Fruit;
import GUI.Fruits;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class sliceObjectsCommand implements Command {

    private GameContainer gc;
    private StateBasedGame sbg;
    private Graphics g;
    private Fruit fruit;
    private GameActions GA;

    public sliceObjectsCommand(GameContainer gc, StateBasedGame sbg, Graphics g, Fruit fruit, GameActions GA) {
        this.gc = gc;
        this.sbg = sbg;
        this.g = g;
        this.fruit = fruit;
        this.GA = GA;
    }

    @Override
    public void execute() throws SlickException {
        GA.sliceObjects(gc, sbg, g, fruit);
    }

}
