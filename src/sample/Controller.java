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
    public boolean GameOver=false;
    private int score=0;
    public int Hearts=3;
    private iLevel level;
    private Random random;
    private int timePassed=0;
    public  int count=0;
    public static GameObject cut;
    public List<GameObject> gameObjects=new ArrayList<>();
    public int HighScore=20;

    private Controller() {
    }


    public static Controller getInstance() throws SlickException {
        if (obj==null)
            obj=new Controller();
            cut=new GameObject();
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
    public void Slice() throws SlickException {
        cut.animation=cut.getSlicedImage();
        cut.isSliced=true;




       if(cut instanceof Bomb1)
            Hearts--;
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
    public void GameOver(StateBasedGame sbg,GameObject cut) {
        if(cut instanceof Nuclear_Bomb || Hearts==0){
           sbg.enterState(2,new FadeOutTransition(),new FadeInTransition());}

    }


    public void Loss(GameObject cut) {

           for(int f=0;f<gameObjects.size();f++){
            if(gameObjects.get(f).getYPos()>290){
                if(!gameObjects.get(f).isSliced && !isBomb(gameObjects.get(f))){
                gameObjects.remove(gameObjects.get(f));
                Hearts--;}

                else gameObjects.remove(gameObjects.get(f));}}



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
       count=0;
       gameObjects.clear();
       GameOver=false;
       cut=null;
    }



    @Override
    public int noOfFruits() {
        return level.noOfFruits();
    }




    public iLevel getLevel() {
        return level;
    }



    public double speed(){
        return level.speed();
    }

    public boolean isBomb(GameObject cut){
        if(cut instanceof Fruits || cut instanceof SpecialFruits)
            return false;
       else return true;

    }

    public void UpdateHighScore(){
        if(count>=HighScore)
            HighScore=count;
    }






    
}
