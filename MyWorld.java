import greenfoot.*;

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
    private int spawnTimer = 0;
    public MyWorld() {
        super(700, 400, 1);
        setBackground(bgImage);
        scrollingImage = new GreenfootImage (getBackground());
        addObject(person, 100, 300);
        
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        //Tree tree = new Tree();
        //addObject(tree, 150, 300);
        
        Reward reward = new Reward();
        addObject(reward, 150, 200);
        
        Frog frog = new Frog();
        addObject(frog, 600, 300);
         
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
        
        spawnTimer--;
        
        if(spawnTimer <= 0)
        {
            addObject(new Frog(), 600, 300);
            spawnTimer = Greenfoot.getRandomNumber(60) + 60;
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
        int x = 600;
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
}
