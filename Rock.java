import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Rock class is an obstacle that moves left across the screen
* If it hits the player (Person), the game ends
* If it goes off screen, it resets to the right side
 * 
 * @author Jennifer and Nereyal
 * @version June 2025
 */
public class Rock extends Actor
{
    /**
     * Constructor sets the image of the rock and scales it
     */
    public Rock()
    {
        GreenfootImage rockImage = new GreenfootImage("images/rock.png");
        rockImage.scale(50, 40);
        setImage(rockImage);
        
    }
    /**
     * Moves the rock left
     * Resets its position if it touches the player (Person)
     */
    
    public void act()
    {
        move(-1);
        
        //If rock goes off the left edge, reposition it
        if (getX() <= 0)
        {
            resetRock();
        }
        //If rock touches the player and they aren't jumping over it, end teh game
        else if (isTouching(Person.class))
        {
            getWorld().removeObject(this);
            GameOver gameOver = new GameOver();
            Greenfoot.setWorld(gameOver);
        }
        
    }
    /**
     * Resets the rock's position to the right side of the screen
     */
    public void resetRock()
    {
        setLocation(1000, 300);
    }
    
}
