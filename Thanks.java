import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thanks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thanks extends World
{

    public Thanks()
    {    
        super(1000, 400, 1); 
        // "thank you for playing, click space to play again"
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
