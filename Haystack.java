import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Haystack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haystack extends Actor
{
    /**
     * Act - do whatever the Haystack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Haystack(){
        GreenfootImage image = getImage();  
        image.scale(image.getWidth() - 15, image.getHeight() - 15);  
        setImage("images/hay stack.png");
    }
    public void act()
    {
        move(-1);
        // Add your action code here.
    }
}
