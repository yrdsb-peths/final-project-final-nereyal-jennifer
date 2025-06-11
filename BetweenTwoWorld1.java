import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BetweenTwoWorld1 is a transition screen between stages of the game
 * Contains the player and the OldLady character
 * lets player press space to begin the next part of the game (next world)
 * 
 * This screen  is used after completing an earlier challenge and before 
 * starting the next one (falling basil level)
 * 
 * @author (Nereyal and Jennifer
 * @version June 2025
 */
public class BetweenTwoWorld1 extends World
{

    /**
     * Constructor for objects of class BetweenTwoWorld.
     * sets the world size and background, and places hte player character 
     * and OldLady in the scene
     * 
     */
    public BetweenTwoWorld1()
    {
        
        super(1000, 400, 1); 
        
        //set background image
        setBackground("images/title screen.jpg");
        Person person = new Person();
        addObject(person,189,339);
        OldLady oldLady = new OldLady();
        addObject(oldLady, 631, 341);
    }
    /**
     * watches for space key press ot transition to next level (gameWorld)
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            NextGame gameWorld = new NextGame();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
