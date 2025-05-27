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
    int ySpeed = 0;
    int gravity = 1;
    
    public Person()
    {
        setImage("images/man01.png");
    }
    public void act()
    {
        
        
        if (Greenfoot.isKeyDown("space") && !currentlyJumping)
        {
                currentlyJumping = true;
                jumpTimer = 15;
                ySpeed = -10;
            
        }
        
        ySpeed += gravity;
        setLocation(getX(), getY() + ySpeed);
        
        Actor wall = getOneIntersectingObject(Wall1.class);
        if ((isTouching(Wall1.class)) && ySpeed>=0)
        {
            ySpeed = 0;
            setLocation(getX(), wall.getY() - getImage().getHeight()/2);
        }
        
        eat();
        
        
        /**if (currentlyJumping)
        {
            setLocation(getX(), getY() - 5);
            jumpTimer--;
            if(jumpTimer <= 0)
            {
                currentlyJumping = false;
            } else
            {
                if(!onWall())
                {
                    setLocation(getX(), getY() + 5);
                }
            }
        }
        */
        
       
    }
    private boolean onWall()
    {
        Actor wall = getOneObjectAtOffset(0, getImage().getHeight()/2, Wall1.class);
        return wall != null;
    }
    public void jumpUp()
    {
        originalY = getY();
        setLocation(getX(), originalY - 100); 
        // jump up
        currentlyJumping = true;
        jumpTimer = 15;
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

