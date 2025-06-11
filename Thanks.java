import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Thanks world is the final screen after the player finishes the game
 * displays thnak and gives option to restart
 * 
 * @author Jennifer and Nereyal
 * @version June 2025
 */
public class Thanks extends World
{
    /**
     * constructor to set background, box with thanks message
     */
    public Thanks()
    {    
        super(1000, 400, 1); 
        GreenfootImage bg = new GreenfootImage("images/thanks background.jpg");
        
        //define box and dimensions/position
         int boxWidth = 500;
        int boxHeight = 150;
        int x = (getWidth() - boxWidth) / 2;
        int y = (getHeight() - boxHeight) / 2;

        //semi transparent white box in the center
        bg.setColor(new Color(255, 255, 255, 230));
        bg.fillRect(x, y, boxWidth, boxHeight);
        bg.setColor(Color.BLACK);
        bg.drawRect(x, y, boxWidth, boxHeight);

        //box border and message
        bg.setColor(Color.BLACK);
        bg.setFont(new Font("Monaco", 24));
        bg.drawString("You finished the game!", x + 100, y + 60);
        bg.drawString("Click enter to play again", x + 80, y + 110);
        
        //set this image as the background
        setBackground(bg);
        
    }
    /**
     * Act - click enter to go to titlescreen, restart game
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
