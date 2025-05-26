import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Person is the main playable character
 * 
 * @author Nereyal
 * @version May 2025
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int originalY;
    private int jumpTimer = 0;
    private boolean currentlyJumping = false;
    
    public Person()
    {
        setImage("images/man01.png");
    }
    public void act()
    {
        boolean onGround = getY() == 300;
        boolean onWall = isTouching(Wall1.class);
        
        if (Greenfoot.isKeyDown("space") &&!currentlyJumping 
        && (onGround || onWall))
        {
                jumpUp();
            
        }
        if(currentlyJumping)
        {
            jumpTimer--;
            
            if(jumpTimer <= 0 && !onWall)
            {
                comeDown();
            }
            
            if (onWall)
            {
                currentlyJumping = false;
            }
            
        }
        if(!currentlyJumping && !onWall && !onGround)
        {
            setLocation(getX(), 300);
        }
    }
    public void jumpUp()
    {
        originalY = getY();
        setLocation(getX(), originalY - 100); 
        // jump up
        currentlyJumping = true;
        jumpTimer = 20;
    }
    public void comeDown()
    {
        if (!isTouching(Wall1.class))
        {
            setLocation(getX(), 300);
        }
        currentlyJumping = false;
        
        

    }
    
     public void eat()
    {
        if(isTouching(Reward.class))
        {
            removeTouching(Reward.class);
            MyWorld world = (MyWorld) getWorld();
            world.resetReward();
            world.increaseScore();
        }
    }
    
}
