import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OldLady here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldLady extends Actor
{
    private String[] dialogues = {"ajergb", "kayrgfbauek"};
    private int dialogueIndex = 0;
    private DialogueBox dialogueBox;
    
    public OldLady()
    {
        setImage("old lady.png");
        getImage().scale(40, 80);
    }

    public void addedToWorld(World world) {
        dialogueBox = new DialogueBox(dialogues[dialogueIndex]);
        world.addObject(dialogueBox, getX() + 100, getY() - 60);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            updateDialogue();
            Greenfoot.delay(10);
        }
    }

    private void updateDialogue()
    {
        dialogueIndex = (dialogueIndex + 1) % dialogues.length;
        if (dialogueBox != null)
        {
            dialogueBox.setText(dialogues[dialogueIndex]);
        }
    }
}
