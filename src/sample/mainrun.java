package sample;

import org.newdawn.slick.SlickException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class mainrun {
    public static void main(String[] args) throws SlickException, ParserConfigurationException, IOException, SAXException, TransformerException {
        Invoker rem = new Invoker();
        Controller c;
        c=Controller.getInstance();
        displayCommand dc = new displayCommand(c);
        rem.setC(dc);
        rem.Action();
    }
}
