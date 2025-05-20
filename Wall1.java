import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall1 extends Actor
{
    /**
     * Act - do whatever the Wall1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Wall1(){
        setImage("images/wall.jpg");
        GreenfootImage image = getImage();  
        image.scale(image.getWidth() - 70, image.getHeight()- 150);  
        }
    public void act()
    {
        // Add your action code here.
        
        
    }
    public void resetWall()
    {
        int num = Greenfoot.getRandomNumber(2);
        if (num==0)
        {
            setLocation(600,300);
        } 
        else if (num == 1) {
            setLocation(600,100);
        }
        else{
            setLocation(600, 500);
        }
        
    }
}
