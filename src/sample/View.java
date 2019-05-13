package sample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class View extends BasicGameState {
    int timePassed,time,time1;
    Image worldmap;
    List<Circle> circles,circles1;

    Random random;
    Apples apples;
    Bananas bananas;
    Oranges oranges;
    Controller c;
    boolean check=false;
    boolean isSliced = false;



    /*private static final View view = new View();
    private View(){}
    public static View getInstance(){
        return view;}*/



    public int getID() {
        return 1;
    }


    public View(int state){ }



    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        worldmap = new Image("res/City2.png");
        circles=new ArrayList<>();
        apples = new Apples(0,0);
        bananas = new Bananas(0,0);
        oranges = new Oranges(0,0);
        c=new Controller();
        random = new Random();
        gameContainer.setMouseCursor(new Image("res/sword22.png"),0,0);
    }


    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        worldmap.draw(0,0);


        for(Circle f : circles){
           DrawFruits(apples,circles);
           //DrawFruits(bananas,circles);
          // DrawFruits(oranges,circles);

        }









        if(isSliced)
            c.Slice(gameContainer,stateBasedGame,g,bananas);

         g.drawString("Time:"+time/1000,100,100);
        // g.drawString("Score:"+c.getScore(),100,130);

    }









                 public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        timePassed+=i/2;
        time+=i;
        time1+=i/2;
        for(Circle f : circles){
            f.setCenterY(f.getCenterY()+(i/2)); }
        FruitFall(circles,timePassed);

        for(Circle f : circles1){
            f.setCenterY(f.getCenterY()+(i/2)); }
        FruitFall(circles1,time1);


    }





        //if(isSliced)
           // c.Timer(gameContainer,stateBasedGame,i, bananas);
    




    public void FruitFall(List<Circle> sample,int time ){
        if(time>500){
            int j=0;
            timePassed=0;
            sample.add(new Circle(random.nextInt(600),0,30));
            if(sample.get(j).getCenterY()>290){
                sample.remove(j);}

            j++;
        } }

        public void DrawFruits(Fruits sample,List<Circle> circles){
     for(Circle f : circles){
         sample.setXPos(f.getCenterX());
         sample.setYPos(f.getCenterY());
         sample.animation.draw(f.getCenterX(),f.getCenterY());}} 


    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        for(Circle f: circles){
            if(oldx> f.getCenterX()-30 &&newx<f.getCenterX()+30&& oldy> f.getCenterY()-30 && newy<f.getCenterX()+30){
                isSliced=true;
                check=true;}}

        //for(Circle f :)
    }



}




