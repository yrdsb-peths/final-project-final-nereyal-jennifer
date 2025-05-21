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
        setImage("images/yellow-draught.png");
    }
    
    public void act()
    {
        // Add your action code here.
        move(-1);
        if (getX() <= 0)
        {
            resetReward();
        }
        

    }
    public void resetReward()
    {
        int num = Greenfoot.getRandomNumber(2);
        if (num==0)
        {
            setLocation(500,150);
        } else {
            setLocation(500,300);
        }
        
    }
}
