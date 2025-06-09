import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    public static boolean spaceHandled = false;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        setBackground("images/title screen.jpg");
        Person person = new Person();
        addObject(person,189,339);
        OldLady oldLady = new OldLady();
        addObject(oldLady, 631, 341);
        
    }
    
     public void act()
    {
        if (Greenfoot.isKeyDown("space") && !spaceHandled)
        {
            Greenfoot.setWorld(new MyWorld());
            spaceHandled = true;
        }
        if (!Greenfoot.isKeyDown("space")) {
            spaceHandled = false; 
        }
        
    }
    
    
}
