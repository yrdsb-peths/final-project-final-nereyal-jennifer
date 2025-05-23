import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    public MyWorld() {
        super(600, 400, 1);

        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        Person person = new Person();
        addObject(person, 150, 300);
        
        Reward reward = new Reward();
        addObject(reward, 600, 150);
        Wall1 wall = new Wall1();
        addObject(wall, 600, 225);
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        if (wall.getX() == 50)
        {
            Wall1 wall2 = new Wall1();
            addObject(wall2, 600, 150);
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
