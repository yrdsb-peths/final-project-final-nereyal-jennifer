import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mushroom is a reward object that moves left across the screen
 * If collected or moved off screen, it is removed and the world is told
 * 
 * @author Nereyal & Jennifer
 * @version June 2025
 */
public class Mushroom extends Actor
{
    /**
     * Constructor sets the mushroom image and scales it 
     */
    public Mushroom()
    {
        GreenfootImage image = new GreenfootImage("images/mushroom2.png");
        image.scale(50, 50);
        setImage(image);
    }
    
    /**
     * Moves the mushroom left each frame
     * if it reaches the left edge of the screen, it is removed,
     * and the world is signaled to reset the reward
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX() - 1, getY());
        MyWorld world= (MyWorld) getWorld();
        if(getX() <= 0) 
        {
            world.removeObject(this);
            world.resetReward();
        }
    }
    
            
}
        


    

