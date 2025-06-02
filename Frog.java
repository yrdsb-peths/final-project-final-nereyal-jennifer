import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author Nereyal
 * @version May 2025
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
        MyWorld world= (MyWorld) getWorld();
        if(getX() <= 0)
        {
            world.removeObject(this);
        }
        
        else if(isTouching(Person.class))
        {
            world.removeObject(this);
            //game over screen!
            
        }
        
    }
    
    public void spawnFrog()
    {
        setLocation(600, 300);
        hasSpawnedNextFrog = false;
    }
}
