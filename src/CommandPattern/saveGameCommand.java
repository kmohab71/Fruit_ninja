package CommandPattern;

public class saveGameCommand implements Command {

    private  GameActions GA;

    public saveGameCommand(GameActions GA) {
        this.GA = GA;
    }

    @Override
    public void execute() {
        GA.saveGame();
    }
}
