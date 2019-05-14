import Factory.*;
import GUI.*;
import CommandPattern.*;
import Strategy.*;




public class Main {

    public static void main(String[] args) {
        GameActions controller= new GameActions(new Fruit(), new Bomb(), new View() );

        controller.Display();
    }
}
