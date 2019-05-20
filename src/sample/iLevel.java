package sample;

import java.util.Random;

public interface iLevel {
    public double speed();
    public int noOfFruits();

}


class EASY implements iLevel{

    public EASY(){}
    Random random=new Random();

    @Override
    public double speed() {
        return 0.25;
    }



    @Override
    public int noOfFruits() {
       return 2;
       // return 1+random.nextInt(1);
    }
}

class INTERMEDIATE implements iLevel{

    public INTERMEDIATE(){}
    Random random=new Random();

    @Override
    public double speed() {
        return 0.4;
    }



    @Override
    public int noOfFruits() {
        return 3;
    }
}

class HARD implements iLevel{

    public HARD(){}
    Random random=new Random();

    public int Time_Remaining() {
        return 60000;
    }

    @Override
    public double speed() {
        return 0.55;
    }

    @Override
    public int noOfFruits() {
        return 4;
    }
}
