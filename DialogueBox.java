import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The DialogueBox displayes lines of dialogue on the screen
 * It handles multi line text, adds padding, semi-transparent background
 * and displays a hint to press ENTER to continue
 * 
 * @author Jennifer
 * @version June 2025
 */
public class DialogueBox extends Actor
{
    /**
     * constructor initializes the dialogue box with the given text
     * @param text The dialogue text to display
     */
    public DialogueBox(String text)
    {
        setText(text);
    }
    
    
    /**
     * Updates the displayed text in the dialogue box
     * handles the multiline text, sets font, styles the box
     * @param text The new text to display
     */
    public void setText(String text)
    {
        //split the text into lines using this character (based on Greenfoot guide)
        String[] lines = text.split("\n");
        
        //spacing between lines
        int lineHeight = 33; 
        //padding around text
        int padding = 10; 
        //box width is fixed
        int width = 250;
        //calculate box height based on lines, spacing, and padding
        int height = (lines.length * lineHeight) + padding * 3 + 20;
        //create image with specified width and height
        GreenfootImage image = new GreenfootImage(width, height);
        
        //set background colour with transparency (white, semi transparent)
        image.setColor(new Color(255, 255, 255, 220)); 
        image.fill();
        
        //draw a black border around the dialogue box
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, width - 1, height - 1);
        
        
        //set font
        Font main = new Font("Monaco", 12);
        image.setFont(main);
        
        //draw each line of text at the appropriate position
        for (int i = 0; i < lines.length; i++) {
            image.drawString(lines[i], padding, padding + (i + 1) * lineHeight);
        }
        
            //add a hint at the bottom of the dialogue box
            String hint = "Hit Enter -->";
            Font hintFont = new Font("Monaco", 12);
            image.setFont(hintFont);
            image.drawString(hint, padding, height - 5);
        
            //set final image as this image
            setImage(image);
        
        
    }
    }

