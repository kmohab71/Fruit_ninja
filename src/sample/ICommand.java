package sample;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import sample.GameObject;
import sample.iLevel;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public interface ICommand {

    public void Slice() throws SlickException;
    public int getScore();
    public void setScore(int score);
    public void GameOver(StateBasedGame sbg,GameObject cut);
    public void Loss(GameObject gameObject) throws SlickException;
    public void save() throws ParserConfigurationException, TransformerException;
    public void newGame(iLevel level);
    public GameObject AddObject(GameObject gameObject, List<GameObject> sample) throws SlickException;
    public int noOfFruits();
}
