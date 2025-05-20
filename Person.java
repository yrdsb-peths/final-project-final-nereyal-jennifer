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
    public void act()
    {
        if (jumpStage == 0 && Greenfoot.isKeyDown("space"))
        {
            originalY = getY();
            setLocation(getX(), originalY - 150); 
            // jump up
            jumpStage = 1;
            jumpTimer = 35;
        }
        else if (jumpStage == 1)
        {
            jumpTimer--;
            if (jumpTimer <= 0)
            {
                setLocation(getX(), originalY); 
                // come back down
                jumpStage = 0;
            }
        }
        
        /**
         * while (person is touching (ground) || wall1 || wall2)
         * if (jump clicked)
         * {
         *     jump up
    
         * if(personIsTouching(ground || wall1 || wall2)){
            don't come back down
            
        }
         else {
             come back down
         }
        }
         */
    }
}
