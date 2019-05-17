package sample;

public interface iLevel {
    public double speed();
    public double noOfFruits();
}
class setLevel {
    private iLevel chosenLevel;
    public setLevel(iLevel chosenLevel) {
        this.chosenLevel=chosenLevel;
    }
    public double speed(){return chosenLevel.speed();}
    public double noOfFruits(){return chosenLevel.noOfFruits();}
}

class EASY implements iLevel{

    @Override
    public double speed() {
        return 0;
    }

    @Override
    public double noOfFruits() {
        return 0;
    }
}

class INTERMEDIATE implements iLevel{

    @Override
    public double speed() {
        return 0;
    }

    @Override
    public double noOfFruits() {
        return 0;
    }
}

class HARD implements iLevel{

    @Override
    public double speed() {
        return 0;
    }

    @Override
    public double noOfFruits() {
        return 0;
    }
}
