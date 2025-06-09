import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OldLady here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldLady extends Actor
{
    private String[] dialogues1 = {"Hello my dear.", "Thank you for getting here quickly.", "I am not feeling well.", "But you can help me!",
                                    "We're going to make my famous bowl.", "It'll use mushrooms and basil.", "Collect 20 mushrooms jumping over rocks (up key)", 
                                    "and attacking eagles (space bar).", "Then, run right & left for falling basil.", "I'll guide you my dear.", "Click space to start!"};
    private String[] dialogues2 = {"Great job!", "Most people die there.", "Now, just collect 10 basils from the sky!", "Use the arrow keys to move.", "Click space to start!"};
    private String[] dialogues3 = {"You did it!", "I knew you could.", "Now it's time to eat!"};
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
        World currentWorld = getWorld();
        if (currentWorld instanceof TitleScreen){
            if (isNearPerson && Greenfoot.isKeyDown("enter")) {
                if (!enterPressed) {
                    currentDialogueIndex++;
                    if (currentDialogueIndex < dialogues1.length) {
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
        
        else if (currentWorld instanceof BetweenTwoWorld1){
            if (isNearPerson && Greenfoot.isKeyDown("enter")) {
                if (!enterPressed) {
                    currentDialogueIndex++;
                    if (currentDialogueIndex < dialogues2.length) {
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
        else if (currentWorld instanceof BetweenTwoWorld2){
            if (isNearPerson && Greenfoot.isKeyDown("enter")) {
                if (!enterPressed) {
                    currentDialogueIndex++;
                    if (currentDialogueIndex < dialogues3.length) {
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
        
    }

    private void showDialogue() {
        World currentWorld = getWorld();
        if (currentWorld instanceof TitleScreen){
            if (dialogueBox == null) {
            dialogueBox = new DialogueBox(dialogues1[currentDialogueIndex]);
            getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
            } 
            else {
                dialogueBox.setText(dialogues1[currentDialogueIndex]);
            }
        }
        
        else if (currentWorld instanceof BetweenTwoWorld1){
            if (dialogueBox == null) {
                dialogueBox = new DialogueBox(dialogues2[currentDialogueIndex]);
                getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
            } 
            else {
                dialogueBox.setText(dialogues2[currentDialogueIndex]);
            }
        }
        else if (currentWorld instanceof BetweenTwoWorld2){
            if (dialogueBox == null) {
                dialogueBox = new DialogueBox(dialogues3[currentDialogueIndex]);
                getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
            } 
            else {
                dialogueBox.setText(dialogues3[currentDialogueIndex]);
            }
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
