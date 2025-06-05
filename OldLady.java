import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OldLady here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldLady extends Actor
{
    private String[] dialogues = {"balabala","balabala"};
    private int currentDialogue = 0;
    private TextBox bubble;
    
    public OldLady() {
        setImage("old lady.png"); 
        getImage().scale(40, 80); 
        
        bubble = new TextBox(dialogues[currentDialogue]);
        updateBubblePosition();
    }
    
    public void addedToWorld(World world) {
        world.addObject(bubble, getX(), getY()); 
        updateBubblePosition();
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            nextDialogue();
        }
    }
    
    private void nextDialogue() {
        currentDialogue = (currentDialogue + 1) % dialogues.length;
        bubble.updateText(dialogues[currentDialogue]);
        updateBubblePosition();
    }
    
    private void updateBubblePosition() {
        if (bubble.getWorld() != null) {
            bubble.setLocation(getX() + 70, getY() - 60);
        }
    }
}
