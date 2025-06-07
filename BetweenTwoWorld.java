import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BetweenTwoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetweenTwoWorld extends World
{

    /**
     * Constructor for objects of class BetweenTwoWorld.
     * 
     */
    public BetweenTwoWorld()
    {    
        super(1000, 400, 1); 
        setBackground("images/title screen.jpg");
        Person person = new Person();
        addObject(person,189,339);
        OldLady oldLady = new OldLady();
        addObject(oldLady, 631, 341);
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            NextGame gameWorld = new NextGame();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
