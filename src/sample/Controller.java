package sample;

import org.newdawn.slick.Animation;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller implements ICommand {
    private static Controller obj;
    private boolean clear=false;
    private boolean GameOver=false;
    private int score=0;
    private int Hearts=3;
    private iLevel level;
    private Random random;
    private int timePassed=0;
    public int count=0;
    public GameObject cut;
    public List<GameObject> gameObjects=new ArrayList<>();

    private Controller() {
    }


    public static Controller getInstance()
    {
        if (obj==null)
            obj=new Controller();
        return obj;
    }
    public void setLevel(iLevel level) {
        this.level = level;
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

        //count++;
        cut=sample;
        sample.isSliced=true;




        if(sample instanceof Nuclear_Bomb)
            GameOver=true;
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
    public void GameOver(StateBasedGame sbg) {
        if(GameOver)
            sbg.enterState(2,new FadeOutTransition(),new FadeInTransition());
    }


    public void Loss(GameObject gameObject) throws SlickException{
            if(gameObject.getYPos()>290 && !gameObject.isSliced){
                gameObjects.remove(gameObject);
                Hearts--;}

                else if(gameObject.getYPos()>290 && gameObject.isSliced)
                    gameObjects.remove(gameObject);

        if(gameObject instanceof Bomb1)
            Hearts--;

    }

    public int getHearts() {
        if(Hearts==0)
            GameOver=true;
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

    public void resetGame (){
       Hearts=3;
       score=0;
     // cut.animation=new Animation(cut.images,cut.duration);
       gameObjects.clear();
       GameOver=false;
       cut=null;


    }



    @Override
    public int noOfFruits() {
        return level.noOfFruits();
    }

    public static Controller getObj() {
        return obj;
    }

    public boolean isClear() {
        return clear;
    }

    public iLevel getLevel() {
        return level;
    }

    public Random getRandom() {
        return random;
    }

    public double speed(){
        return level.speed();
    }



    
}
