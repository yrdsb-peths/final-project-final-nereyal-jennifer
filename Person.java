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
    GreenfootImage[] running = new GreenfootImage[8];
    GreenfootImage[] jumping = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    public Person()
    {
        for (int i = 0; i < running.length; i++)
        {
            running[i] = new GreenfootImage("images/running/run" + i + ".png");
            running[i].scale(100, 100);
        }
        for (int i = 0; i < jumping.length; i++)
        {
            jumping[i] = new GreenfootImage("images/jumping/jump" + i + ".png");
            jumping[i].scale(100, 100);
        }
        animationTimer.mark();
        setImage(running[0]);
        
        
    }
    int imageIndex = 0;
    public void animatePerson()
    {
        if (animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if (Greenfoot.isKeyDown("space"))
        {
            setImage(jumping[imageIndex]);
            imageIndex = (imageIndex + 1) % jumping.length;
        }
        else
        {
            setImage(running[imageIndex]);
            imageIndex = (imageIndex + 1) % running.length;
        }
    }
    public void act()
    {
        boolean onGround = getY() == 300;
        boolean onWall = isTouching(Wall1.class);
        
        if (Greenfoot.isKeyDown("space") && !currentlyJumping && (onGround || onWall))
        {
                jumpUp();
            
        }
        if (currentlyJumping)
        {
            jumpTimer--;
            
            if(jumpTimer <= 0)
            {
                currentlyJumping = false;
            }
            
            if(!onWall)
            {
                comeDown();
            }
        }
        if(!currentlyJumping && !onWall && !onGround) 
        {
            comeDown();
        }
        
        eat();
        animatePerson();
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

