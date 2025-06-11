import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BetweenTwoWorld2 is a transition screen between stages of the gae
 * contains player and OldLady character
 * lets player space to begin next part of the game
 * 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetweenTwoWorld2 extends World
{
    public static boolean spaceHandled = false;
    public BetweenTwoWorld2()
    {    
        super(1000, 400, 1); 
        setBackground("images/title screen.jpg");
        Person person = new Person();
        addObject(person,189,339);
        OldLady oldLady = new OldLady();
        addObject(oldLady, 631, 341);
    }
    
    /**
     * Watches for space key press to transition to next level
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space") && !spaceHandled)
        {
            Greenfoot.setWorld(new Thanks());
            spaceHandled = true;
        }
        if (!Greenfoot.isKeyDown("space")) {
            spaceHandled = false; 
        }
    }
}
