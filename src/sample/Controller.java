package sample;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Random;

public class Controller implements ICommand {
    private static Controller obj;
    boolean clear=false;
    int score=0;
    int Hearts=3;
    iLevel level;
    Random random;
    int timePassed=0;


    private Controller() {}

    public static Controller getInstance()
    {
        if (obj==null)
            obj = new Controller();
        return obj;
    }


    public int getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }



    @Override
    public void Slice(GameObject sample) throws SlickException {
        sample.animation=sample.getSlicedImage();
        setScore(score+=sample.Points());
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score=score;
    }

    @Override
    public void GameOver(StateBasedGame sbg, GameObject gameObject) {
        if(Hearts==0 || gameObject instanceof Nuclear_Bomb)
            sbg.enterState(2,new FadeOutTransition(),new FadeInTransition());
    }

    @Override
    public void Loss(List<GameObject> gameObjects, GameObject gameObject) {
        for(int f=0;f<gameObjects.size();f++){
            if(gameObjects.get(f).getYPos()>290){
                Hearts--;
                gameObjects.remove(f);
            }
        }
        if(gameObject instanceof Bomb1) {
            Hearts--;

        }
    }

    public int getHearts() {
        return Hearts;
    }
    @Override
    public void save() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("Game");
        doc.appendChild(rootElement);

        Element myscore = doc.createElement("score");
        rootElement.appendChild(myscore);
        myscore.setTextContent(Integer.toString(score));

        Element diff = doc.createElement("difficulty");
        rootElement.appendChild(diff);


        Element mylives = doc.createElement("lives");
        rootElement.appendChild(mylives);
        mylives.setTextContent(Integer.toString(Hearts));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("game.xml"));
        transformer.transform(source, result);

    }

    @Override
    public void newGame(iLevel level) {
        this.level=level;
    }

    @Override
    public GameObject AddObject(GameObject gameObject, List<GameObject> sample) throws SlickException {
        random = new Random();
        GameObject object = gameObject.getRandomGameObject();
        sample.add(object);
        object.setXPos(random.nextInt(500));
        return object;
    }

    double speed=level.speed();
    public double getSpeed() {
        return speed;
    }

    @Override
    public double noOfFruits() {
        return level.noOfFruits();
    }
}
