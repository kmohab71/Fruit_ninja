package sample;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface Command {
    void execute() throws SlickException, TransformerException, ParserConfigurationException, IOException, SAXException;
}

class GameOverCommand implements Command {
    private StateBasedGame sbg;
    private Controller c;

    public GameOverCommand(StateBasedGame sbg,Controller c) {
        this.sbg = sbg;
        this.c = c;
    }

    @Override
    public void execute() {
        c.GameOver(sbg,c.cut);
    }
}

class Invoker {
    Command c;

    public Invoker() {
    }

    public void setC(Command c) {
        this.c = c;
    }

    public double Action() throws TransformerException, SlickException, ParserConfigurationException, IOException, SAXException {
        c.execute();
        return 0;
    }
}

class LossCommand implements Command {
    private GameObject gameObject;
    private Controller c;

    public LossCommand(GameObject gameObject, Controller c) {
        this.gameObject = gameObject;
        this.c = c;
    }


    @Override
    public void execute() throws SlickException {
        c.Loss(gameObject);
    }
}

class NewGameCommand implements Command {
    private Controller c;
    private iLevel level;

    public NewGameCommand(Controller c,iLevel level) {
        this.c = c;
        this.level=level;
    }


    @Override
    public void execute() throws ParserConfigurationException, SAXException, IOException {
        c.newGame(level);
    }
}

class SliceCommand implements Command {
    private Controller c;

    public SliceCommand(Controller c) {
        this.c = c;
    }


    @Override
    public void execute() throws SlickException {
        c.Slice();
    }
}

class displayCommand implements Command {
    private Controller c;

    public displayCommand(Controller c) {
        this.c = c;
    }


    @Override
    public void execute(){
        c.display();
    }
}

class updateHSCommand implements Command {
    private Controller c;

    public updateHSCommand(Controller c) {
        this.c = c;
    }



    @Override
    public void execute() throws SlickException, TransformerException, ParserConfigurationException, IOException, SAXException {
        c.UpdateHighScore();
    }
}


class resetGameCommand implements Command {
    private Controller c;


    public resetGameCommand(Controller c) {
        this.c = c;
    }

    @Override
    public void execute(){
        c.resetGame();
    }
}

