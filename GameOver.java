import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        GreenfootImage bg = new GreenfootImage("cemetery1.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        GreenfootImage textBox = new GreenfootImage(400, 120);
        textBox.setColor(new Color(255, 255, 255, 230)); 
        textBox.fill();
        textBox.setColor(Color.BLACK);
        textBox.drawRect(0, 0, 399, 119); 
        Font font = new Font("Monaco", true, false, 24);
        textBox.setFont(font);
        textBox.setColor(Color.BLACK);
        textBox.drawString("You Lose!", 140, 45);
        textBox.drawString("Press Enter to Restart", 50, 85);
        int x = (bg.getWidth() - textBox.getWidth()) / 2;
        int y = (bg.getHeight() - textBox.getHeight()) / 2;
        bg.drawImage(textBox, x, y);
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
        
    }
}
