package CommandPattern;

public class loadGameCommand implements Command {

    private GameActions GA;

    public loadGameCommand(GameActions GA) {
        this.GA = GA;
    }

    @Override
    public void execute() {
        GA.loadGame();
    }
}
