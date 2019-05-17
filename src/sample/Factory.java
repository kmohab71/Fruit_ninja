package sample;

import org.newdawn.slick.SlickException;

public class Factory {
public static GameObject FactoryGameObj(int x) throws SlickException {
    switch (x){
        case 1:
            return new Bananas();
        case 2:
            return new Apples();
        case 3:
            return new Special_One();
        case 4:
            return new Special_Two();
        case 5:
            return new Oranges();
        case 6:
            return new Bomb1();
        case 7:
            return new Nuclear_Bomb();

        default:
            return null;
    }

}

}
