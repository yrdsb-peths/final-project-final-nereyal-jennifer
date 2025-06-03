import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rock()
    {
         setImage("images/ezgif-4761526e8cf023.png");
        
    }
    
    public void act()
    {
        // Add your action code here.
        move(-1);
        if (getX() <= 0)
        {
            resetRock();
        }
        else if (isTouching(Person.class))
        {
            getWorld().removeObject(this);
        }
        
    }
    
    public void resetRock()
    {
        setLocation(700, 300);
    }
    
}
