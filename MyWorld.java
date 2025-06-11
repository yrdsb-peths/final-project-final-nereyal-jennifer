import greenfoot.*;
import java.awt.GraphicsEnvironment;
public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    private int coinTimer = 0;
    public int imageCount = 0;
    Person person = new Person();
    private GreenfootImage bgImage = new GreenfootImage("background.jpg");
    private int scrollSpeed = 1; 
    private GreenfootImage scrollingImage; 
    private int scrollPosition = 0; 
    private int eagleTimer = 200;
    private int rockTimer = 400;
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
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    
     /**
    private void checkAvailableFonts() {
        String[] fontNames = GraphicsEnvironment
        .getLocalGraphicsEnvironment()
        .getAvailableFontFamilyNames();
        for (String name : fontNames) {
            System.out.println(name);
        }
    }
    */
}
