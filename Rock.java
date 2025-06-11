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
        GreenfootImage rockImage = new GreenfootImage("images/rock.png");
        rockImage.scale(50, 40);
        setImage(rockImage);
        
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
            GameOver gameOver = new GameOver();
            Greenfoot.setWorld(gameOver);
        }
        
    }
    
    public void resetRock()
    {
        setLocation(700, 300);
    }
    
}
