import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reward extends Actor
{
    /**
     * Act - do whatever the Reward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Reward()
    {
        GreenfootImage image = new GreenfootImage("images/mushroom2.png");
        image.scale(50, 50);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
        setLocation(getX() - 3, getY());
        MyWorld world= (MyWorld) getWorld();
        if(getX() <= 0) 
        {
            world.removeObject(this);
            world.resetReward();
        }
    }
    
            
}
        


    

