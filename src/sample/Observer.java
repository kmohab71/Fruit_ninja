package sample;

public abstract class Observer {
    protected Subject subject;
    abstract void update();
}