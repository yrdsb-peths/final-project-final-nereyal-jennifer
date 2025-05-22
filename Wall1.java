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
        int random = Greenfoot.getRandomNumber(1);
        if (random ==0)
        {
            setImage("images/wall100.jpg");
            GreenfootImage image = getImage();  
            image.scale(image.getWidth() , image.getHeight()); 
        } 
        else if (random == 1) {
            setImage("images/wall200.jpg");
            GreenfootImage image = getImage();  
            image.scale(image.getWidth() - 70, image.getHeight()- 150); 
        }
        else{
            setImage("images/wall300.jpg");
            GreenfootImage image = getImage();  
            image.scale(image.getWidth() - 70, image.getHeight()- 150);
        }
        
        }
    public void set1()
    {
        setImage("images/wall300.jpg");
        setLocation (600, 225);
        setImage("images/wall100.jpg");
        setLocation(700, 150);
    }
    public void act()
    {
        // Add your action code here.
        move(-1);
        if(getX() <= 50)
        {
            resetWall();
        }
        
    }  
    
    public void resetWall()
    {
        int num = Greenfoot.getRandomNumber(2);
        getWorld().addObject (new Wall1(), 600, Greenfoot.getRandomNumber(150));
        if (num==0)
        {
            setImage("images/wall300.jpg");
            setLocation (600, 225);
        } 
        
        else{
            setLocation(600, 150);
        }
        
    }
    
    
    
    /**
     * create walls, wall 1 would reference the previous wall put out
     * public void wallPlacer()
     * {
     *     if (wall1.getY() == 225)
     *     {
     *         then randomly place wall above or don't place a wall at all (player goes to ground)
     *      }
     *      else if (wall1.getY() == 150)
     *      {
     *          then randomly place wall at 225 or don't place a wall at all (on the bottom)
     *          
     *       }
     *       else
     *       {
     *           since the player would be on the floor, place a wall at 225
     *        }
     *}
     *public void 
     *
     */
}
