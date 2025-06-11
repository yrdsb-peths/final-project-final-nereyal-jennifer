import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The NextGame world is the second level of the game
 * The player collects Basil and avoids PoisonApples
 * the level gets harder every 5 points
 * 
 * @author Nereyal and Jennifer 
 * @version June 2025
 */
public class NextGame extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class ThemePage.
     * background, objects, spawn apple and basil
     */
    public NextGame()
    {    
        // background
        super(950, 400, 1); 
        GreenfootImage bg = new GreenfootImage("next game background.jpg");
        bg.scale(1000, 400);
        setBackground(bg);
        
        //add objects
        Person person = new Person();
        addObject(person, 300, 300);
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        spawnReward();
        spawnApple();
    }
    /**
     * if 10 basils collects, move to next level
     */
    public void act(){
        if (score == 10){
            Greenfoot.setWorld(new BetweenTwoWorld2());
        }
    }
    /**
     * spawns a basil object at a random x position at the top of the screen
     */
    public void spawnReward()
    {
        Basil food = new Basil();
        food.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(food, x, y);
    }
    
    //spawn a PoisonApple at a random x position at the top of the screen
    public void spawnApple()
    {
        PoisonApple apple = new PoisonApple();
        //increase speed 
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    /**
     * increase score by 1, update level, increase difficulty every 3 pionts
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if (score % 3 == 0){
            level += 1;
        }
    }
}
