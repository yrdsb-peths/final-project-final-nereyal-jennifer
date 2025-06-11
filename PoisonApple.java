import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PoisonApple is a harmful object that falls from the top of the screen
 * If it touches the player, the game ends.
 * If it reaches the ground, it is removed and replaced by another apple
 * 
 * @author Jennifer and Nereyal 
 * @version June 2025
 */
public class PoisonApple extends Actor
{
    //initial speed apple falls down
    int speed = 1;
    /**
     * Constructor sets the apple image and scales ti to a smaller size
     */
    public PoisonApple(){
        GreenfootImage image = new GreenfootImage("images/poisonApple.png");
        image.scale(30,30);
        setImage(image);
    }
    
    /**
     * Called automatically by Greenfoot on each game tick
     * Handles movement, collision, and out of bounds items
     */
    public void act()
    {
        // Get a reference to the world (NextGame)
        NextGame world= (NextGame) getWorld();
        
        //move poison apple downward by speed pixels
        setLocation(getX(), getY() + speed);
        
        //if apple touches the player, trigger game over
        if (isTouching(Person.class))
        {
            
            Greenfoot.setWorld(new GameOver());
        }
        
        //if apple reaces the bottom of the screen, remove apple and spawn another
         if(getY() == world.getHeight() - 1)
        {
            world.removeObject(this);
            world.spawnApple();
        }
    }
    
    /**
     * Control fall speed fo the apple
     * @param spd the new speed balue
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
