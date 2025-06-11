import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * TitleScreen sets up openng screen of game
 * shows instructions, and gives players first objective to go through game
 * 
 * @author Jennifer and Nereyal
 * @version June 2025
 */
public class TitleScreen extends World
{
    //prevents spacebar from triggering multiple times
    public static boolean spaceHandled = false;
    
    //displays game intro text
    public DialogueBox dialogueBox;
    //controls how long the dialogue box is shown
    public int messageTimer = 240;
    
    //tracks whether dialogue has been cleared
    public boolean cleared = false;
    /**
     * Constructor for objects of class TitleScreen.
     * sets background and person/oldlady and dialogue box
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
        dialogueBox = new DialogueBox("GRANDMA'S DISH \n Welcome to the game \nyour first mission is find the \nold lady and approach her \nIgnore the hint below for now");
        addObject(dialogueBox, getWidth()/2, 100);
    }
    /**
     * Act - waits to move to next world (MyWorld) when space key pressed
     */
    public void act()
    {
        //let message disappears
        if (messageTimer > 0) {
            messageTimer--;
        } 
        else if (!cleared) {
            setBackground(new GreenfootImage("images/title screen.jpg")); 
            removeObject(dialogueBox); 
            cleared = true;
        }
        //once space key is pressed, move to next world
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
