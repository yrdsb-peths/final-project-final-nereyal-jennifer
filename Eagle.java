import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author Nereyal
 * @version May 2025
 */
public class Eagle extends Actor
{
    GreenfootImage[] flying = new GreenfootImage[11]; 
    private int imageIndex = 0;
    public Eagle()
    {
        for (int i = 0; i < flying.length; i++)
        {
            flying[i] = new GreenfootImage("images/eagle/fly" + i + ".png");
            flying[i].scale(50, 50);
        }
    }
    public void act()
    {
        // Add your action code here.
        imageIndex = (imageIndex + 1) % flying.length;
        setImage(flying[imageIndex]);
        move(-3);
        MyWorld world= (MyWorld) getWorld();
        if(getX() <= 0)
        {
            world.removeObject(this);
        }
        
        else if(isTouching(Person.class))
        {
            world.removeObject(this);
            //game over screen!
            
        }
        
    }
}
