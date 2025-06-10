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
    public DialogueBox dialogueBox;
    public int messageTimer = 240;
    public boolean cleared = false;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        setBackground("images/thanks background.jpg");
        Person person = new Person();
        addObject(person,189,339);
        OldLady oldLady = new OldLady();
        addObject(oldLady, 631, 341);
        dialogueBox = new DialogueBox("Welcome to the game \nyour first mission is find the \nold lady and approach to her \nIgnore the hint below for now");
        addObject(dialogueBox, getWidth()/2, 100);
    }
    
     public void act()
    {
        if (messageTimer > 0) {
            messageTimer--;
        } 
        else if (!cleared) {
            setBackground(new GreenfootImage("images/title screen.jpg")); 
            removeObject(dialogueBox); 
            cleared = true;
        }
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
