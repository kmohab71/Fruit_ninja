package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Apples extends Fruits{
    float xpos,ypos;

        Image[] images;

    Animation animation;


   public Apples (float xpos,float ypos) throws SlickException {
       super(xpos, ypos);
       images=this.getImages();
      animation=new Animation(images,duration);
   }



    public void Move(){
   }


    public Image[] getImages() throws SlickException {
       Image[] apple = new Image[]{new Image("res/apple.png"),new Image("res/apple.png")};

        return apple;
    }





    public Image getSlicedImage() throws SlickException{
        Image slicedApples = new Image("res/apple1.png");
return slicedApples;
    }



    public Image getSlicedImage2() throws SlickException{
        Image slicedApples = new Image("res/apple2.png");
        return slicedApples;
    }





    public void Slice(){

    }



    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
   }



    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {}

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {}


}
