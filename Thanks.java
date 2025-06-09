import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thanks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thanks extends World
{

    public Thanks()
    {    
        super(1000, 400, 1); 
        GreenfootImage bg = new GreenfootImage("images/thanks background.jpg");
        
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
        bg.drawString("You finished the game!", x + 100, y + 60);
        bg.drawString("Click space to play again", x + 80, y + 110);
        
        setBackground(bg);
        
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
