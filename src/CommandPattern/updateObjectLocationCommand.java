package CommandPattern;

public class updateObjectLocationCommand implements Command {
    private GameActions GA;

    public updateObjectLocationCommand(GameActions GA) {
        this.GA = GA;
    }

    @Override
    public void execute() {
        GA.updateObjectsLocations();

    }
}
