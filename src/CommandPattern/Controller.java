package CommandPattern;
import Factory.GameObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import GUI.*;
public interface Controller {
    public GameObject createGameObject();
    public void updateObjectsLocations();
    /*
    * it is used to slice fruits located in your swiping region
    This method can take your swiping region as parameters (they
    depend on how you calculate it).
    */



    public void sliceObjects(GameContainer gc, StateBasedGame sbg, Graphics g, Fruits sample) throws SlickException;
    /*
     *saves the current state of the game
     */
    public void saveGame();
    /*
     *loads the last saved state of the game
     */
    public void loadGame();
    /*
     *resets the game to its initial state
     */
    public void ResetGame();
}
