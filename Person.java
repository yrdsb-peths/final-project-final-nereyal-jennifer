import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Person is the main playable character
 * It can run, jump, attack, and collect rewards
 * 
 * @author Nereyal
 * @version June 2025
 */
public class Person extends Actor
{
    //Movement, velocity/gravity aspect taken from online Greenfoot guide
    private int jumpHeight = 100;
    private boolean isJumping = false;
    private int gravity = 2;
    private int groundLevel = 260;
    private int yVelocity = 0;
    
    //Animation 
    GreenfootImage[] running = new GreenfootImage[8];
    GreenfootImage[] jumping = new GreenfootImage[8];
    GreenfootImage[] runningLeft = new GreenfootImage[8];
    GreenfootImage[] attack = new GreenfootImage[6];
    GreenfootImage[] die = new GreenfootImage[5];
    
    //sound
    GreenfootSound jumpSound = new GreenfootSound("jump-up-245782.mp3");
    
    //direction and animation frame tracking
    String facing = "right";
    boolean isMoving = false;
    SimpleTimer animationTimer = new SimpleTimer();
    public int runIndex = 0;
    public int jumpIndex = 0;
    public int runLeftIndex = 0;
    public int attackIndex = 0;
    public int dieIndex = 0;
    public boolean wasJumping = false;
    public boolean attacking = false;
    
    /**
     * Constructor to upload/scale images of character animations
     */
    public Person()
    {
        GreenfootImage standingImage = new GreenfootImage("images/standing.png");
        standingImage.scale(60, 110);
        setImage(standingImage);
        //running, jumping, left facing, attack, and death images
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
            attack[i] = new GreenfootImage("images/attacking/attacking" + i + ".png");
            attack[i].scale(100, 130);
        }
        for (int i = 0; i < die.length; i++)
        {
            die[i] = new GreenfootImage("images/dying/death" + i + ".png");
            die[i].scale(80, 100);
        }
        
        //set default image based on world
        World currentWorld = getWorld();
        if (currentWorld instanceof MyWorld){
            setImage(running[0]);
        }
        else if (currentWorld instanceof TitleScreen){
            setImage("images/standing.png");
        }
    }
    
    /**
     * Act called on every time. Handles movement, animation, and interactions.
     */
    public void act()
    {
        
        World currentWorld = getWorld();
        checkKeys();
        gravity();
        getReward();
        animatePerson();
        attackEagle();

    }
    /**
     * Animates the character based on movement or attack state.
     */
    public void animatePerson()
    {
        //animation depends on the specific world, use timer to determine frame
        World currentWorld = getWorld();
        if (animationTimer.millisElapsed() < 100) { 
            return;
        }
        animationTimer.mark();
        
        //attack animation if space bar clicked (attacking true)
        if(attacking)
        {
            setImage(attack[attackIndex]);
            //keep adding to attackIndex (animation pic number)
            attackIndex = (attackIndex + 1) % attack.length;
            //set attacking to false once animation done
            if (attackIndex == 0)
            {
                attacking = false;
            }
            return;
        }
        
        //allow jumping when in first game (MyWorld)
        if (currentWorld instanceof MyWorld){
            if (isJumping || yVelocity < 0) {
                setImage(jumping[jumpIndex]);
                jumpIndex = (jumpIndex + 1) % jumping.length;
                if (!wasJumping) {
                    runIndex = 0;
                }
            } 
            else{
                //set running if not jumping/attacking
                setImage(running[runIndex]);
                runIndex = (runIndex + 1) % running.length;
                if (wasJumping)
                {
                    jumpIndex = 0;
                }
            }
        }
        else{
            //be able to move left and right in any world but first game
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
        
        //death animation in game over screen
        if(currentWorld instanceof GameOver)
        {
            setImage(die[dieIndex]);
            dieIndex = (dieIndex + 1) % die.length;
        }
    
    }
    /**
     * checkKeys looks at inputs from keys for movement, jumping, and attacking.
     */

    public void checkKeys()
    {
        isMoving = false;
        World currentWorld = getWorld();
         
        if (currentWorld instanceof MyWorld) {
            //if up key pressed and not already jumping, then jump
            if (Greenfoot.isKeyDown("up") && !isJumping && getY() >= groundLevel) {
                yVelocity = -jumpHeight;
                isJumping = true;
                //start jump animation
                jumpIndex = 0;
                //play jump sound
                jumpSound.play();
            }
        }
        else{
            //if left or right key pressed, run left or right by 2
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
            //if up key pressed and not already jumping, jump
            if (Greenfoot.isKeyDown("up") && !isJumping && getY() >= groundLevel) {
                yVelocity = -jumpHeight;
                isJumping = true;
                jumpIndex = 0;
            }
            //if space key pressed and not already attacking, attack
            if(Greenfoot.isKeyDown("space") && !attacking)
            {
                attacking = true;
                attackIndex = 0;
            }
        }
        
    
    }
    /**
     * Applies gravity and keeps the player on the ground
     */
    public void gravity()
    {
        World currentWorld = getWorld();
        if (currentWorld instanceof MyWorld) {
            //add gravity to the speed to bring it down 
            yVelocity += gravity;
            setLocation(getX(), getY() + yVelocity/10);
            //back on ground, not jumping anymore
            if (getY() >= groundLevel)
            {
                setLocation(getX(), groundLevel);
                yVelocity = 0;
                isJumping = false;
            }
        }
    }
    
    /**
     * getReward collects rewards like mushrooms or 
     * basil depending on the world
     */
     public void getReward()
    {
        World currentWorld = getWorld();

        if (currentWorld instanceof MyWorld) {
            if(isTouching(Mushroom.class))
            {
                removeTouching(Mushroom.class);
                MyWorld world = (MyWorld) getWorld();
                world.resetReward();
                world.increaseScore();
            }   
        }
        if (currentWorld instanceof NextGame) {
            if(isTouching(Basil.class))
            {
                removeTouching(Basil.class);
                NextGame world = (NextGame) getWorld();
                world.spawnReward();
                world.increaseScore();
            }   
        }
    }
    /**
     * Removes eagle if touching the eagle and currently attacking
     */
    public void attackEagle()
    {
        if (attacking && isTouching(Eagle.class))
        {
            removeTouching(Eagle.class);
        }
    }
}

