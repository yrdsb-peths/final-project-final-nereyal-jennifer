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
    private int currentDialogueIndex = -1;
    private boolean isNearPerson = false;
    private boolean enterPressed = false;
    private int dialogueIndex = 0;
    private DialogueBox dialogueBox;
    
    public OldLady()
    {
        setImage("old lady.png");
        getImage().scale(40, 80);
    }

    /**
    public void addedToWorld(World world) {
        dialogueBox = new DialogueBox(dialogues[dialogueIndex]);
        world.addObject(dialogueBox, getX() + 100, getY() - 60);
    }
    */

    public void act() {
        checkProximity();
        handleDialogueInput();
        updateDialogueBoxPosition();
    }

    private void checkProximity() {
        Person person = (Person) getWorld().getObjects(Person.class).get(0);
        if (person != null && !isNearPerson) {
            int distance = (int)Math.hypot(getX() - person.getX(), getY() - person.getY());
            if (distance < 120) {
                isNearPerson = true;
                currentDialogueIndex = 0;
                showDialogue();
            }
        }
    }

    private void handleDialogueInput() {
        if (isNearPerson && Greenfoot.isKeyDown("enter")) {
            if (!enterPressed) {
                currentDialogueIndex++;
                if (currentDialogueIndex < dialogues.length) {
                    showDialogue();
                } 
                else {
                    removeDialogue();
                    isNearPerson = false;
                    currentDialogueIndex = -1;
                }
                enterPressed = true;
            }
        } 
        else if (!Greenfoot.isKeyDown("enter")) {
            enterPressed = false;
        }
    }

    private void showDialogue() {
        if (dialogueBox == null) {
            dialogueBox = new DialogueBox(dialogues[currentDialogueIndex]);
            getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
        } 
        else {
            dialogueBox.setText(dialogues[currentDialogueIndex]);
        }
    }      

    private void removeDialogue() {
        if (dialogueBox != null) {
            getWorld().removeObject(dialogueBox);
            dialogueBox = null;
        }
    }

    private void updateDialogueBoxPosition() {
        if (dialogueBox != null) {
            dialogueBox.setLocation(getX() + 100, getY() - 60);
        }
    }
}
