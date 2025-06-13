import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOver screen is shown when player loses
 * Displays a cemetery background and a textbox with a restart message
 * Pressing Enter will restart the game by returning to TitleScreen
 * 
 * @author Nereyal and Jennifer
 * @version June 2025
 */
public class GameOver extends World
{

    /**
     * Constructor sets up the Game Over screen with backgroundm
     * message box, and a placeholder player character (optional)
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        //load and scale image
        GreenfootImage bg = new GreenfootImage("cemetery1.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        //create a semi transparent white text box
        GreenfootImage textBox = new GreenfootImage(400, 120);
        textBox.setColor(new Color(255, 255, 255, 230)); 
        textBox.fill();
        textBox.setColor(Color.BLACK);
        textBox.drawRect(0, 0, 399, 119); 
        
        //set up font and position box
        Font font = new Font("Monaco", true, false, 24);
        textBox.setFont(font);
        textBox.setColor(Color.BLACK);
        textBox.drawString("You Lose!", 140, 45);
        textBox.drawString("Press Enter to Restart", 50, 85);
        int x = (bg.getWidth() - textBox.getWidth()) / 2;
        int y = (bg.getHeight() - textBox.getHeight()) / 2;
        bg.drawImage(textBox, x, y);
        
        //add player (with deat animation)
        Person person = new Person();
        addObject(person,500,300);
        
        //sound
        GreenfootSound gameOverSound = new GreenfootSound("gameoversound.mp3");
    }
    /**
     * continuously checks if enter is pressed to restart the game
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
