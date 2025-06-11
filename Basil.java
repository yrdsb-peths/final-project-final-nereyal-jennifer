import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Basil is a reward object that moves down the screen
 * If collected or reaches the bottom, it is removed and the world is notified
 * 
 * @author Nereyal & Jennifer
 * @version June 2025
 */
public class Basil extends Actor
{
    int speed = 1;
    /**
     * Constructor sets the basil image and scales it
     */
    public Basil(){
        GreenfootImage image = new GreenfootImage("images/basil.png");
        image.scale(30,30);
        setImage(image);
    }
    
    /**
     * Moves the basil down each frame
     * If it reaches the bottom of the screen, game over 
     * and the world is signaled
     */
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
    
    /**
     * increases the speed of the basil
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}

