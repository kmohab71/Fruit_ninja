package CommandPattern;

public class createGameObjectCommand implements Command {

    private GameActions GA;

    public createGameObjectCommand(GameActions GA)
    {
        this.GA=GA;
    }
    @Override
    public void execute() {
        GA.createGameObject();
    }
}
