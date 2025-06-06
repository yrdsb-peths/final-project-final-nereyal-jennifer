import greenfoot.*;
import java.awt.GraphicsEnvironment;
public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    private int wallTimer = 0;
    private int coinTimer = 0;
    public int imageCount = 0;
    Person person = new Person();
    private GreenfootImage bgImage = new GreenfootImage("background.jpg");
    private int scrollSpeed = 1; 
    private GreenfootImage scrollingImage; 
    private int scrollPosition = 0; 
    private int eagleTimer = 0;
    private int rockTimer = 0;
    public MyWorld() {
        super(1000, 400, 1);
        setBackground(bgImage);
        scrollingImage = new GreenfootImage (getBackground());
        addObject(person, 100, 300);
        
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        //Tree tree = new Tree();
        //addObject(tree, 150, 300);
        
        Reward reward = new Reward();
        addObject(reward, 800, 200);
        
        Eagle eagle = new Eagle();
        addObject(eagle, 1200, 150);
        
        Rock rock = new Rock();
        addObject(rock, 800, 300);
         
    }
    /**
    public void act()
    {
        wallTimer++;
        coinTimer++;
        
        if(wallTimer > 60)
        {
            int y = Greenfoot.getRandomNumber(350) + 30;
            int w = Greenfoot.getRandomNumber(50) + 100;
            addObject(new Wall1(w), 610, y);
            wallTimer = 0;
        }
        
        if(coinTimer > 100)
        {
            int y = Greenfoot.getRandomNumber(300) + 30;
            addObject(new Reward(), 610, y);
            coinTimer = 0;
        }
        
        if(person.getY() > getHeight())
        {
            showText("Game Over", getWidth()/2 - 30, getHeight()/2);
            Greenfoot.stop();
        }
    }
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
            eagleTimer = Greenfoot.getRandomNumber(70) + 100;
        }
        
        rockTimer--;
        if (rockTimer <= 0)
        {
            addObject(new Rock(), 1000, 300);
            rockTimer = Greenfoot.getRandomNumber((500) + 500);
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
        Reward reward = new Reward();
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
        addObject(reward, x, y);
    
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
