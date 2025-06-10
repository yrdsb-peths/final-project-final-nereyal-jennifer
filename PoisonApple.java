import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoisonApple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonApple extends Actor
{
    int speed = 1;
    /**
     * Act - do whatever the Insect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PoisonApple(){
        GreenfootImage image = new GreenfootImage("images/poisonApple.png");
        image.scale(30,30);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
        NextGame world= (NextGame) getWorld();
        setLocation(getX(), getY() + speed);
        if (isTouching(Person.class))
        {
            
            Greenfoot.setWorld(new GameOver());
        }
         if(getY() == world.getHeight() - 1)
        {
            world.removeObject(this);
            world.spawnApple();
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
