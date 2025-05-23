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
    public Person()
    {
        setImage("images/man01.png");
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
}
