package sample;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller implements ICommand {
    //
    // Variables
    //
    private static Controller obj;
    private boolean clear=false;
    public boolean GameOver=false;
    private int score=0;
    public int Hearts=3;
    private iLevel level;
    private Random random;
    private int timePassed=0;
    public  int count=0;
    public static GameObject cut;
    public List<GameObject> gameObjects=new ArrayList<>();
    public int HighScore;
    public static final String gamename = "Fruit Ninja";




    //
    //
    // Setters and Getters
    //
    //

    public static GameObject getCut() {
        return cut;
    }

    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }
    @Override
    public void setLevel(iLevel level) {
        this.level = level;
    }

    @Override
    public int getTimePassed() {
        return timePassed;
    }
    @Override
    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
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
    public void setHearts(int hearts){
        this.Hearts=hearts;
    }
    @Override
    public iLevel getLevel() {
        return level;
    }


    //
    //
    // Singleton
    //
    //
    private Controller() {
    }
    //
    ///
    ////
    public static Controller getInstance() throws SlickException {
        if (obj==null)
            obj=new Controller();
        cut=new GameObject();
        return obj;
    }
    //
    //
    // Game Engine Methods
    //
    //
    @Override
    public void Slice() throws SlickException {
        cut.animation=cut.getSlicedImage();
        cut.isSliced=true;
        if(cut instanceof Bomb1)
            Hearts--;

        if(cut instanceof BonusFruit)
           Hearts=3;

        if(cut instanceof BreakAllFruit){
            for(int i=0;i<gameObjects.size();i++) {
                gameObjects.get(i).animation = gameObjects.get(i).getSlicedImage();
                count++;
            }

        }
        try {
            this.save();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
    //
    //
    //
    //
    //
    @Override
    public void GameOver(StateBasedGame sbg,GameObject cut) {
        if(cut instanceof Nuclear_Bomb || Hearts==0){
            sbg.enterState(2,new FadeOutTransition(),new FadeInTransition());}
    }
    //
    //
    //
    //
    //
    @Override
    public void Loss(GameObject cut) throws SlickException {

        for(int f=0;f<gameObjects.size();f++)
        {
            if(gameObjects.get(f).getYPos()>290){
                if(!gameObjects.get(f).isSliced && !isBomb(gameObjects.get(f))){
                    gameObjects.remove(gameObjects.get(f));
                    Hearts--;
                }
                else gameObjects.remove(gameObjects.get(f));
            }
        }
    }
    //
    //
    //
    //
    //
    @Override
    public void save() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("Game");
        doc.appendChild(rootElement);

        Element myhs = doc.createElement("HighScore");
        rootElement.appendChild(myhs);
        myhs.setTextContent(Integer.toString(this.getHighScore()));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("game.xml"));
        transformer.transform(source, result);
    }
    //
    //
    //
    //
    //
    @Override
    public void newGame(iLevel level) throws IOException, SAXException, ParserConfigurationException {
        this.level=level;
        load();
    }
    //
    //
    //
    //
    //
    @Override
    public GameObject AddObject(GameObject gameObject, List<GameObject> sample) throws SlickException {
        random = new Random();
        GameObject object = gameObject.getRandomGameObject();
        sample.add(object);
        object.setXPos(random.nextInt(500));
        return object;
    }
    //
    //
    //
    //
    //
    @Override
    public void resetGame(){
        Hearts=3;
        count=0;
        gameObjects.clear();
        GameOver=false;
        cut=null;
    }
    //
    //
    //
    //
    //
    @Override
    public int noOfFruits() {
        return level.noOfFruits();
    }
    //
    //
    //
    //
    //
    @Override
    public void load() throws ParserConfigurationException, IOException, SAXException {

        File inputFile = new File("game.xml");
        if (inputFile == null) {
            return ;
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList hs = doc.getElementsByTagName("HighScore");
        for(int i=0;i<hs.getLength();i++)
        {
            Node node = hs.item(i);
            this.setHighScore(Integer.parseInt(node.getTextContent()));
        }

    }
    //
    //
    //
    //
    //

    //
    //
    //
    //
    //

    //
    //
    //
    //
    //
    @Override
    public double speed(){
        return level.speed();
    }
    //
    //
    //
    //
    //
    @Override
    public boolean isBomb(GameObject cut){
        if(cut instanceof Fruits || cut instanceof SpecialFruits)
            return false;
        else return true;

    }
    //
    //
    //
    //
    //

    //
    //
    //
    //
    //
    @Override
    public void UpdateHighScore(){
        if(count>=HighScore)
            this.setHighScore(count);
    }
    //
    //
    //
    //
    //
    int getnoOfFruits()
    {
        return this.noOfFruits();
    }

    @Override
    public  void display(){
        MainView.display();
    }
    //
    //
    // Observer
    //
    //
    public void Update(int count,GameObject object) {
        for(int i =0;i<count;i++)
            setScore(score+=object.Points());
    }
    //
    //
    //
    //
    //
    public static Controller getObj() {
        return obj;
    }
}
