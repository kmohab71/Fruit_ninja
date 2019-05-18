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

    public EASY(){}


    @Override
    public double speed() {
        return 0.25;
    }

    @Override
    public double noOfFruits() {
        return 0;
    }
}

class INTERMEDIATE implements iLevel{

    public INTERMEDIATE(){}

    @Override
    public double speed() {
        return 0.4;
    }

    @Override
    public double noOfFruits() {
        return 0;
    }
}

class HARD implements iLevel{

    public HARD(){}


    @Override
    public double speed() {
        return 0.55;
    }

    @Override
    public double noOfFruits() {
        return 0;
    }
}
