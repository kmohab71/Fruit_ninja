package sample;

public class WizradProjectile extends Projectile {


    public WizradProjectile(int x, int y, double dir) {
        super(x, y, dir);
        range = 200;
        damage = 20;
        rateOfFall = 15;
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);

    }

  protected void update (){
        move();
  }
  protected void move()
  {

  }
}