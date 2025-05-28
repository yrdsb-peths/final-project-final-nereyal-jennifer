import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    private int wallTimer = 0;
    private int coinTimer = 0;
    Person person = new Person();
    public MyWorld() {
        super(600, 400, 1);

        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        

        addObject(person, 100, 200);
        
        Wall1 wall = new Wall1();
        addObject(wall, 150, 200);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
         
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
