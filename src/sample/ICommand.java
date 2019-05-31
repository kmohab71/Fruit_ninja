package sample;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface ICommand {

    public void Slice() throws SlickException;
    public int getScore();
    public void setScore(int score);
    public void GameOver(StateBasedGame sbg,GameObject cut);
    public void Loss(GameObject gameObject) throws SlickException;
    public void save() throws ParserConfigurationException, TransformerException;
    public void newGame(iLevel level) throws IOException, SAXException, ParserConfigurationException;
    public GameObject AddObject(GameObject gameObject, List<GameObject> sample) throws SlickException;
    public int noOfFruits();
    public void UpdateHighScore();
    public boolean isBomb(GameObject cut);
    public void load() throws ParserConfigurationException, IOException, SAXException;
    public void resetGame();
    public void setLevel(iLevel level);
    public int getTimePassed();
    public void setTimePassed(int timePassed);
    public void setHearts(int hearts);
    public iLevel getLevel();
    public double speed();
    public  void display();

}
