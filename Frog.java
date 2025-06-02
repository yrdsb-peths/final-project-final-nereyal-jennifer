import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frog extends Actor
{
    private boolean hasSpawnedNextFrog = false;
    public Frog()
    {
        setImage("images/frog.png");
    }
    public void act()
    {
        // Add your action code here.
        move(-3);
        
        if(getX() <= 10)
        {
            getWorld().removeObject(this);
        }
        
        if(isTouching(Person.class))
        {
            getWorld().removeObject(this);
            //game over screen!
            
        }
    }
    
    public void spawnFrog()
    {
        setLocation(600, 300);
        hasSpawnedNextFrog = false;
    }
}
