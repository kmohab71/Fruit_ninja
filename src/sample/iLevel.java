package sample;

public interface iLevel {
    public double speed();
    public double noOfFruits();
}


class EASY implements iLevel{
//lol
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
//lol
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
// lol
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
