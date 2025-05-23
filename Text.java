import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Text()
    {
        String text = "Click space to start";
        int fontSize = 60;
        Color textColor = Color.WHITE;
        Font font = new Font("Sauber Script", fontSize);
        GreenfootImage image = new GreenfootImage(text, fontSize, textColor, null);
        image.setFont(font);
        setImage(image);
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
