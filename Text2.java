import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text2 extends Actor
{
    /**
     * Act - do whatever the Text2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Text2()
    {
        String text = "Project name";
        int fontSize = 60;
        Color textColor = Color.BLACK;
        Font font = new Font("Impact.ttf", fontSize);
        GreenfootImage image = new GreenfootImage(text, fontSize, textColor, null);
        image.setFont(font);
        setImage(image);
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
