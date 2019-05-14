package CommandPattern;

public class resetGameCommand implements Command {

    private GameActions GA;

    public resetGameCommand(GameActions GA) {
        this.GA = GA;
    }

    @Override
    public void execute() {
        GA.ResetGame();

    }
}
