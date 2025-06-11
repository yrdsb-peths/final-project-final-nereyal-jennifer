import greenfoot.*;
import java.awt.GraphicsEnvironment;
public class MyWorld extends World {
    //score tracking
    public int score = 0;
    Label scoreLabel;
    
    //add person
    Person person = new Person();
    
    //background scrolling variables
    private GreenfootImage bgImage = new GreenfootImage("background.jpg");
    private int scrollSpeed = 1; 
    private GreenfootImage scrollingImage; 
    private int scrollPosition = 0; 
    
    //spawning timers for eagles and rocks
    private int eagleTimer = 200;
    private int rockTimer = 400;
    /**
     * constructor to add lavel, mushroom, eagle, rock, and background
     */
    public MyWorld() {
        super(1000, 400, 1);
        setBackground(bgImage);
        scrollingImage = new GreenfootImage (getBackground());
        addObject(person, 100, 300);
        
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        
        Mushroom mushroom = new Mushroom();
        addObject(mushroom, 800, 200);
        
        Eagle eagle = new Eagle();
        addObject(eagle, 1000, 150);
        
        Rock rock = new Rock();
        addObject(rock, 900, 300);
         
    }
    /**
     * Act has background and scrolling, eagle and rock spawning
     * transition to next world if 20 mushrooms collected
     */
     public void act() 
    { 
            
        if(scrollPosition < 0) { 
            scrollPosition = getWidth(); 
         }
        scrollPosition -= scrollSpeed; 
        paint(scrollPosition); 
        
        eagleTimer--;
        
        
        if(eagleTimer <= 0)
        {
            addObject(new Eagle(), 1000, 150);
            eagleTimer = 400;
            //make sure rocks don't spawn too soon after eagle
            if (rockTimer < 300) {
                rockTimer = 300;
            }
        }
        
        rockTimer--;
        if (rockTimer <= 0)
        {
            addObject(new Rock(), 1000, 300);
            rockTimer = Greenfoot.getRandomNumber((800) + 7000);
        }
        if (score == 20){
            Greenfoot.setWorld(new BetweenTwoWorld1());
        }
    }
    
    //scroll background based on Greenfoot guide
    private void paint(int position) 
    { 
         GreenfootImage bg = getBackground(); 
         bg.drawImage(scrollingImage, position, 0); 
         if(position > 0) { 
             bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0); 
         } 
         else { 
             bg.drawImage(scrollingImage, position + scrollingImage.getWidth(), 0); 
         } 
    }
    //respawn a mushroom at a random vertical position
    public void resetReward()
    {
        Mushroom mushroom = new Mushroom();
        int num = Greenfoot.getRandomNumber(2);
        int x = 1000;
        int y = 0;
        if (num==0)
        {
            y = 100;
        } 
        else 
        {
            y = 300;
        }
        addObject(mushroom, x, y);
    
    }
    
    //increase score by 1 and update labe
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
}
