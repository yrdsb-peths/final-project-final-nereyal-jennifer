import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThemePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextGame extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class ThemePage.
     * 
     */
    public NextGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 400, 1); 
        GreenfootImage bg = new GreenfootImage("next game background.jpg");
        bg.scale(1000, 400);
        setBackground(bg);
        Person person = new Person();
        addObject(person, 300, 300);
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        spawnReward();
    }
    public void act(){
        if (score == 20){
            Greenfoot.setWorld(new BetweenTwoWorld2());
        }
    }
    public void spawnReward()
    {
        Reward2 food = new Reward2();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(food, x, y);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
}
