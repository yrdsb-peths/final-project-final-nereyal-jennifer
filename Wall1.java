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
*/       
    
    private static int lastWallX = 600;
    private static int lastWallY = 300;
    private boolean hasSpawnedNextWall = false;
    
    private final int[] yLevels = {135, 225, 315};
    
    public Wall1()
    {
        setWallImage();
    }
    
    public void act()
    {
        move(-1);
        if(!hasSpawnedNextWall && getX() <=500)
        {
            spawnNextWall();
            hasSpawnedNextWall = true;
        }
        
        if(getX() <= 5)
        {
            getWorld().removeObject(this);
        }
    }
    
    private void setWallImage()
    {
        int randomSize = Greenfoot.getRandomNumber(1);
        if (randomSize ==0)
        {
            setImage("images/wall100.jpg");
            GreenfootImage image = getImage();  
            image.scale(image.getWidth() , image.getHeight()); 
        } 
        else if (randomSize == 1) {
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
    
    private void spawnNextWall()
    {
        int spaceX = 150;
        int newX = lastWallX + spaceX;
        
        int index = getYLevelIndex(lastWallY);
        int direction;
        int random = Greenfoot.getRandomNumber(2);
        if (random == 0)
        {
            direction = -1;
        }
        else {
            direction = 1;
        }
        int newIndex = index + direction;
        
        if (newIndex < 0)
        {
            newIndex = 1;
        }
        
        if (newIndex > 2)
        {
            newIndex = 1;
        }
        
        int newY = yLevels[newIndex];
        
        getWorld().addObject(new Wall1(), newX, newY);
        
        lastWallX = newX;
        lastWallY = newY;
    }
    
    private int getYLevelIndex(int y)
    {
        for (int i = 0; i <yLevels.length; i++)
        {
            if (yLevels[i] == y)
            {
                return i;
            }
        }
        return 2;
    }
}
