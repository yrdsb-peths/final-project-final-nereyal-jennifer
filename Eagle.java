import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Eagle is a moving enemy that flies from right to left
 * It plays an animation while moving and interacts with the Person
 * If it touches the Person and they are not attacking, game ends
 * 
 * @author Nereyal
 * @version June 2025
 */
public class Eagle extends Actor
{
    //array to hold flight animation
    GreenfootImage[] flying = new GreenfootImage[11]; 
    //current frame index for animation
    private int imageIndex = 0;
    /**
     * Constructor that sets up eagle's flying animation frames
     */
    public Eagle()
    {
        animateEagle();
    }
    
    /**
     * Animates eagle, moves eagle left, removes eagle off screen, ends game
     */
    public void act()
    {
        // Add your action code here.
        imageIndex = (imageIndex + 1) % flying.length;
        setImage(flying[imageIndex]);
        move(-2);
        MyWorld world= (MyWorld) getWorld();
        if(getX() <= 0)
        {
            world.removeObject(this);
        }
        
        else if(isTouching(Person.class))
        {
            Person person = (Person)getOneIntersectingObject(Person.class);
            if (!person.attacking)
            {
                world.removeObject(this);
                GameOver gameOver = new GameOver();
                Greenfoot.setWorld(gameOver);
            }
  
        }
        
    }
    
    /**
     * loads and scales eagle flying animation pictures as array
     */
    public void animateEagle()
    {
        for (int i = 0; i < flying.length; i++)
        {
            flying[i] = new GreenfootImage("images/eagle/fly" + i + ".png");
            flying[i].scale(50, 50);
        }
    }
}
