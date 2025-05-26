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
    private int jumpStage = 0;
    private int originalY;
    private int jumpTimer = 0;
    GreenfootImage[] jumping = new GreenfootImage[7];
    SimpleTimer animationTimer = new SimpleTimer();
    public Person()
    {
        for (int i = 1; i < jumping.length + 1; i++)
        {
            jumping[i] = new GreenfootImage("images/jump_jump" + i + ".png");
            animationTimer.mark();
            
        }
        for (int i = 0; i < jumping.length; i++)
        {
            //find pictures of the same person walking/jumping
        }

    }
    
    public void act()
    {
        if (getY() == 300 || (isTouching(Wall1.class)))
        {
            jumpUp(); 
            
        }
        jumpUp();
        if(!(isTouching(Wall1.class)))
        {
            comeDown();
        }
        eat();
    }
    public void jumpUp()
    {
        if (jumpStage == 0 && Greenfoot.isKeyDown("space"))
        {
            originalY = getY();
            setLocation(getX(), originalY - 100); 
            // jump up
            jumpStage = 1;
            jumpTimer = 10;
        }
    }
    public void comeDown()
    {
        if (jumpStage == 1)
        {
            jumpTimer--;
            if (jumpTimer <= 0)
            {
                setLocation(getX(), originalY); 
                // come back down
                jumpStage = 0;
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