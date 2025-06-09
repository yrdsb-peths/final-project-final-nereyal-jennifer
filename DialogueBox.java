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
        String[] lines = text.split("\n");

        int lineHeight = 33; 
        int padding = 10; 
        int width = 250;
        int height = (lines.length * lineHeight) + padding * 3 + 20;

        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(new Color(255, 255, 255, 220)); 
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, width - 1, height - 1);
    
        Font main = new Font("Monaco", 12);
        image.setFont(main);
        for (int i = 0; i < lines.length; i++) {
            image.drawString(lines[i], padding, padding + (i + 1) * lineHeight);
        }
    
        
        String hint = "Enter → Next, Space → Start game";
        Font hintFont = new Font("Monaco", 12);
        image.setFont(hintFont);
        image.drawString(hint, padding, height - 5);
    
        setImage(image);
    }
        
        
        /**GreenfootImage image = new GreenfootImage(100, 50);
        image.setColor(new Color(255, 255, 255, 220));
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 199, 49);
        image.setFont(new Font("Monaco", 16));
        image.drawString(text, 10, 30);
        setImage(image);
        */
    }

