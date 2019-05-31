package sample;

import org.newdawn.slick.*;
class Oranges extends Fruits{

    public Oranges() throws SlickException {

        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/orange.png"),new Image("res/orange.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/orange11.png"), new Image("res/orange11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }

}


public class Fruits extends GameObject {






    public Fruits () throws SlickException {




    }



    public int Points(){
        return 100;
    }





}
class Bananas extends Fruits {

    public Bananas() throws SlickException {


        animation=new Animation(images,duration);
    }

    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/banana.png"),new Image("res/banana.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/banana11.png"), new Image("res/banana11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }






}



class Apples extends Fruits{



    public Apples() throws SlickException {


        animation=new Animation(images,duration);
    }



    public Image[] getImages() throws SlickException{
        return images;
    }


    public Image[] getFullImages() throws SlickException {
        Image[] apple = new Image[]{new Image("res/apple.png"),new Image("res/apple.png")};

        return apple;
    }

    public Animation getSlicedImage() throws SlickException{
        Image[] sliced = new Image[]{new Image("res/apple11.png"), new Image("res/apple11.png")};
        Animation animation = new Animation(sliced,duration);

        return animation;
    }





}
