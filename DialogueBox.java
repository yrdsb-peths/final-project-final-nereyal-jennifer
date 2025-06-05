import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogueBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueBox extends Actor
{
    public DialogueBox(String text)
    {
        setText(text);
    }

    public void setText(String text)
    {
        GreenfootImage image = new GreenfootImage(200, 50);
        image.setColor(new Color(255, 255, 255, 220));
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 199, 49);
        image.setFont(new Font("SansSerif", 16));
        image.drawString(text, 10, 30);
        setImage(image);
    }
}
