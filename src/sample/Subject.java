package sample;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int score;

    public int getState() {
        return score;
    }

    public void setState(int score) {
        this.score = score;
        notifyAllObservers();
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}