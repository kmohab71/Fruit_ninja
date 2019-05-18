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

public interface Command {
    public void execute() throws SlickException, TransformerException, ParserConfigurationException;
}
    class AddObjectCommand implements Command {
        private Controller c;
        private GameObject go;
        private List<GameObject> list;

        public AddObjectCommand(Controller c, GameObject go, List<GameObject> list) {
            this.c = c;
            this.go = go;
            this.list = list;
        }

        @Override
        public void execute() throws SlickException {
            c.AddObject(go, list);
        }
    }

    class GameOverCommand implements Command {
        private StateBasedGame sbg;
        private GameObject gameObject;
        private Controller c;

        public GameOverCommand(StateBasedGame sbg, GameObject gameObject, Controller c) {
            this.sbg = sbg;
            this.gameObject = gameObject;
            this.c = c;
        }

        @Override
        public void execute() throws SlickException {
            c.GameOver(sbg, gameObject);
        }
    }

    class getScoreCommand implements Command {
        private Controller c;

        public getScoreCommand(Controller c) {
            this.c = c;
        }

        @Override
        public void execute() {
            c.getScore();
        }
    }

    class Invoker {
        Command c;

        public Invoker() {
        }

        public void setC(Command c) {
            this.c = c;
        }

        public double Action() throws TransformerException, SlickException, ParserConfigurationException {
            c.execute();
            return 0;
        }
    }

    class LossCommand implements Command {
        private List<GameObject> gameObjects;
        private GameObject gameObject;
        private Controller c;

        public LossCommand(List<GameObject> gameObjects, GameObject gameObject, Controller c) {
            this.gameObjects = gameObjects;
            this.gameObject = gameObject;
            this.c = c;
        }

        @Override
        public void execute() throws SlickException {
            c.Loss(gameObjects, gameObject);
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
        public void execute() throws SlickException {
            c.newGame(level);
        }
    }

    class noofFruitsCommand implements Command {
        private Controller c;

        public noofFruitsCommand(Controller c) {
            this.c = c;
        }

        @Override
        public void execute() throws SlickException {
            c.noOfFruits();
        }
    }



    class saveCommand implements Command {
        private Controller c;

        public saveCommand(Controller c) {
            this.c = c;
        }

        @Override
        public void execute() throws SlickException, TransformerException, ParserConfigurationException {
            c.save();
        }
    }

    class setScoreCommand implements Command {
        private Controller c;

        public setScoreCommand(Controller c) {
            this.c = c;
        }

        @Override
        public void execute() throws SlickException {
            c.getScore();
        }
    }

    class SliceCommand implements Command {
        private Controller c;
        private GameObject  go;

        public SliceCommand(Controller c, GameObject go) {
            this.c = c;
            this.go = go;
        }
        @Override
        public void execute() throws SlickException {
            c.Slice(go);
        }
    }

