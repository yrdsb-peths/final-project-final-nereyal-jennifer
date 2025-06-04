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

    private int jumpHeight = 100;
    private boolean isJumping = false;
    private int gravity = 2;
    private int groundLevel = 260;
    private int yVelocity = 0;
    
    GreenfootImage[] running = new GreenfootImage[8];
    GreenfootImage[] jumping = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    public int runIndex = 0;
    public int jumpIndex = 0;
    public boolean wasJumping = false;
    public Person()
    {
        for (int i = 0; i < running.length; i++)
        {
            running[i] = new GreenfootImage("images/running/run" + i + ".png");
            running[i].scale(80, 100);
        }
        for (int i = 0; i < jumping.length; i++)
        {
            jumping[i] = new GreenfootImage("images/jumping/jump" + i + ".png");
            jumping[i].scale(120, 120);
        }
        setImage(running[0]);
    }
    public void animatePerson()
    {
        if (animationTimer.millisElapsed() < 100) { 
            return;
        }
        animationTimer.mark();
        
        if (isJumping || yVelocity < 0) {
            setImage(jumping[jumpIndex]);
            jumpIndex = (jumpIndex + 1) % jumping.length;
            if (!wasJumping) {
                runIndex = 0;
            }
        } 
        else {
            setImage(running[runIndex]);
            runIndex = (runIndex + 1) % running.length;
            if (wasJumping)
            {
                jumpIndex = 0;
            }
        }
    }
    public void act()
    {
        
        
        checkKeys();
        gravity();
        eat();
        animatePerson();

    }

    public void checkKeys()
    {
        World currentWorld = getWorld();

        if (currentWorld instanceof TitleScreen) {
        
            if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 2, getY());
            }
            if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 2, getY());
            }
        } 
        else if (currentWorld instanceof MyWorld) {
        
            if (Greenfoot.isKeyDown("space") && !isJumping && getY() >= groundLevel) {
                yVelocity = -jumpHeight;
                isJumping = true;
                jumpIndex = 0;
            }
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

