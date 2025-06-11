import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class reward2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basil extends Actor
{
    int speed = 1;
    /**
     * Act - do whatever the Insect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Basil(){
        GreenfootImage image = new GreenfootImage("images/basil.png");
        image.scale(30,30);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
        NextGame world= (NextGame) getWorld();
        setLocation(getX(), getY() + speed);
        if (getY() >= getWorld().getHeight() - 1)
        {
            Greenfoot.setWorld(new GameOver());
            world.removeObject(this);
        }
        
        
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}

