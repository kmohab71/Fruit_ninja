package sample;


import org.newdawn.slick.tests.xml.Entity;

public abstract class Projectile extends Entity {
    protected final int xOrigin;
    protected final int yOrigin;
    protected double angle;
    protected double nx,ny;
    protected double speed, rateOfFall, range , damage;


    public Projectile(int x, int y , double dir) {
        xOrigin = x;
        yOrigin =y;
        angle = dir;

    }

}
