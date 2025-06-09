import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    public static boolean spaceHandled = false;
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
        int boxWidth = 500;
        int boxHeight = 150;
        int x = (getWidth() - boxWidth) / 2;
        int y = (getHeight() - boxHeight) / 2;

        bg.setColor(new Color(255, 255, 255, 230));
        bg.fillRect(x, y, boxWidth, boxHeight);
        bg.setColor(Color.BLACK);
        bg.drawRect(x, y, boxWidth, boxHeight);

        
        bg.setColor(Color.BLACK);
        bg.setFont(new Font("Monaco", 24));
        bg.drawString("You lose!", x + 200, y + 60);
        bg.drawString("Click space to play again", x + 80, y + 110);
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space") && !spaceHandled)
        {
            Greenfoot.setWorld(new TitleScreen());
            spaceHandled = true;
        }
        if (!Greenfoot.isKeyDown("space")) {
            spaceHandled = false; 
        }
        
    }
}
