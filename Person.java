import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Person is the main playable character
 * 
 * @author Nereyal
 * @version May 2025
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int jumpHeight = 100;
    private boolean isJumping = false;
    private int gravity = 2;
    private int groundLevel = 260;
    private int yVelocity = 0;
    
    GreenfootImage[] running = new GreenfootImage[8];
    GreenfootImage[] jumping = new GreenfootImage[8];
    GreenfootImage[] runningLeft = new GreenfootImage[8];
    String facing = "right";
    boolean isMoving = false;
    SimpleTimer animationTimer = new SimpleTimer();
    public int runIndex = 0;
    public int jumpIndex = 0;
    public int runLeftIndex = 0;
    public int attackIndex = 0;
    public boolean wasJumping = false;
    public boolean attacking = false;
    public Person()
    {
        GreenfootImage standingImage = new GreenfootImage("images/standing.png");
        standingImage.scale(60, 110);
        setImage(standingImage);
        for (int i = 0; i < running.length; i++)
        {
            running[i] = new GreenfootImage("images/running/run" + i + ".png");
            running[i].scale(80, 100);
        }
        for (int i = 0; i < jumping.length; i++)
        {   
            jumping[i] = new GreenfootImage("images/jumping/jump" + i + ".png");
            jumping[i].scale(120, 120);
        }
        for (int i = 0; i < running.length; i++)
        {
            running[i] = new GreenfootImage("images/running/run" + i + ".png");
            running[i].scale(80, 100);
        }
        for (int i = 0; i < runningLeft.length; i++)
        {
                runningLeft[i] = new GreenfootImage("images/running/run" + i + ".png");
                runningLeft[i].mirrorHorizontally();
                runningLeft[i].scale(80, 100);
        }
        for (int i = 0; i < attack.length; i++)
        {
            attack[i] = new GreenfootImage("images/attacking/attack" + i + ".png");
            attack[i].scale(80, 100);
        }
        
        World currentWorld = getWorld();
        if (currentWorld instanceof MyWorld){
            setImage(running[0]);
        }
        else if (currentWorld instanceof TitleScreen){
            setImage("images/standing.png");
        }
    }
    public void animatePerson()
    {
        World currentWorld = getWorld();
        if (animationTimer.millisElapsed() < 100) { 
            return;
        }
        animationTimer.mark();
        
        if(attacking)
        {
            setImage(attack[attackIndex]);
            attackIndex = (attackIndex + 1) % attack.length;
            if (attackIndex == 0)
            {
                attacking = false;
            }
            return;
        }
        if (currentWorld instanceof MyWorld){
            if (isJumping || yVelocity < 0) {
                setImage(jumping[jumpIndex]);
                jumpIndex = (jumpIndex + 1) % jumping.length;
                if (!wasJumping) {
                    runIndex = 0;
                }
            } 
            else{
                setImage(running[runIndex]);
                runIndex = (runIndex + 1) % running.length;
                if (wasJumping)
                {
                    jumpIndex = 0;
                }
            }
        }
        else{
            if(facing.equals("right") && isMoving == true)
            {
                setImage(running[runIndex]);
                runIndex = (runIndex + 1) % running.length;
            }
            else if (facing.equals("left") && isMoving == true)
            {   
                setImage(runningLeft[runLeftIndex]);
                runLeftIndex = (runLeftIndex + 1) % runningLeft.length;
            }
            else{
                GreenfootImage standingImage = new GreenfootImage("images/standing.png");
                standingImage.scale(60, 110);
                setImage(standingImage);
                
            }
        }
    
    }
    public void act()
    {
        
        World currentWorld = getWorld();
        checkKeys();
        gravity();
        eat();
        animatePerson();

    }

    public void checkKeys()
    {
        isMoving = false;
        World currentWorld = getWorld();
         
        if (currentWorld instanceof MyWorld) {
        
            if (Greenfoot.isKeyDown("space") && !isJumping && getY() >= groundLevel) {
                yVelocity = -jumpHeight;
                isJumping = true;
                jumpIndex = 0;
            }
        }
        else{
        
            if (Greenfoot.isKeyDown("left")) {
                setLocation(getX() - 2, getY());
                isMoving = true;
                facing = "left";
            }
            if (Greenfoot.isKeyDown("right")) {
                setLocation(getX() + 2, getY());
                isMoving = true;
                facing = "right";
            }

        } 
        if (currentWorld instanceof MyWorld) {
        
            if (Greenfoot.isKeyDown("up") && !isJumping && getY() >= groundLevel) {
                yVelocity = -jumpHeight;
                isJumping = true;
                jumpIndex = 0;
            }
            if(Greenfoot.isKeyDown("enter") && !attacking)
            {
                attacking = true;
                attackIndex = 0;
            }
        }
        
    
    }
    public void gravity()
    {
        World currentWorld = getWorld();

        if (currentWorld instanceof MyWorld) {
            yVelocity += gravity;
            setLocation(getX(), getY() + yVelocity/10);
            if (getY() >= groundLevel)
            {
                setLocation(getX(), groundLevel);
                yVelocity = 0;
                isJumping = false;
            }
        }
    }
    
     public void eat()
    {
        World currentWorld = getWorld();

        if (currentWorld instanceof MyWorld) {
            if(isTouching(Reward.class))
            {
            removeTouching(Reward.class);
            MyWorld world = (MyWorld) getWorld();
            world.resetReward();
            world.increaseScore();
            }   
        }
        if (currentWorld instanceof NextGame) {
            if(isTouching(Reward2.class))
            {
            removeTouching(Reward2.class);
            NextGame world = (NextGame) getWorld();
            world.spawnReward();
            world.increaseScore();
            }   
        }
    }
    
}

