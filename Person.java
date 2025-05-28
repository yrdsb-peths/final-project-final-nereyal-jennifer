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

    private int jumpHeight = 50;
    private boolean isJumping = false;
    private int gravity = 2;
    private int groundLevel = 300;
    private int yVelocity = 0;
    GreenfootImage[] running = new GreenfootImage[8];
    GreenfootImage[] jumping = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    public int imageIndex = 0;
    public int totalJumpFrames = 8;
    public int jumpDuration = 0;
    public int totalJumpTime;
    public boolean wasJumping = false;
    public Person()
    {
        totalJumpTime = (int)(Math.sqrt(2 * jumpHeight / gravity)) * 1000;
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
        
        
        
    }
    public void animatePerson()
    {
        if (isJumping || yVelocity < 0) {
            
            int frame = (int)((float)jumpDuration / totalJumpTime * totalJumpFrames);
            frame = Math.min(frame, totalJumpFrames - 1);
            setImage(jumping[frame]);
            jumpDuration += 16;
        } else {
            
            if (animationTimer.millisElapsed() > 100) {
                animationTimer.mark();
                imageIndex = (imageIndex + 1) % running.length;
                setImage(running[imageIndex]);
            }
        }
    }
    public void act()
    {
        checkKeys();
        gravity();
        checkWall();
        eat();
        animatePerson();
        wasJumping = isJumping;
    }

    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("space") && !isJumping && getY() >= groundLevel)
        {
            yVelocity = -jumpHeight;
            isJumping = true;
            imageIndex = 0;
        }
    }
    public void gravity()
    {
        yVelocity += gravity;
        setLocation(getX(), getY() + yVelocity/10);
        if (getY() >= groundLevel)
        {
            setLocation(getX(), groundLevel);
            yVelocity = 0;
            isJumping = false;
            jumpDuration = 0;
        }
    }
    public void checkWall()
    {
        if (isTouching(Wall1.class))
        {
            if (Greenfoot.isKeyDown("space"))
            {
                yVelocity = -jumpHeight;
                isJumping = true;
                jumpDuration = 0;
            }
        }
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

